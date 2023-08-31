package com.ngts.projects.scm.core.api.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.ngts.projects.scm.core.api.entity.ERole;
import com.ngts.projects.scm.core.api.entity.Roles;
import com.ngts.projects.scm.core.api.entity.Users;
import com.ngts.projects.scm.core.api.repository.RolesRepository;
import com.ngts.projects.scm.core.api.repository.UsersRepository;
import com.ngts.projects.scm.core.api.security.redis.PublisherService;
import com.ngts.projects.scm.core.api.security.redis.RedisCacheUtils;
import com.ngts.projects.scm.core.api.service.UserDetailsImpl;
import com.ngts.projects.scm.core.api.utils.RolesUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ngts.projects.scm.core.api.payload.request.LoginRequest;
import com.ngts.projects.scm.core.api.payload.request.SignupRequest;
import com.ngts.projects.scm.core.api.payload.response.UserInfoResponse;
import com.ngts.projects.scm.core.api.payload.response.MessageResponse;
import com.ngts.projects.scm.core.api.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;

//for Angular Client (withCredentials)
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@Slf4j
//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(tags = {"This is for authentication API swagger"} )
@RequestMapping("/api/auth")
public class AuthController {


  @Autowired
  PublisherService publisherService;

  @Autowired
  RolesUtils rolesUtils;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UsersRepository userRepository;

  @Autowired
  RolesRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @Autowired
  private RedisCacheUtils redisCacheUtils;

  @Value("${ngtsscm.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  @ApiOperation(value = "SignIn API : ", notes = " NGTS SCM Sign in` \n  ")
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    if(roles != null && roles.size() > 0){
          String role = roles.get(0);
          String roleStripped = role.substring(role.indexOf("_")+1);
      userDetails.setApiList(rolesUtils.getFunctionsList(roleStripped));
    }
    redisCacheUtils.hSet(jwtCookie.getValue(), "auth_cookie",userDetails, jwtExpirationMs );

    try {
      publisherService.publish("User logged in "+ userDetails.getUsername());
    }catch (Exception e){
      log.error("Error in publishing events");
    }
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
        .body(new UserInfoResponse(userDetails.getId(),
                                   userDetails.getUsername(),
                                   userDetails.getEmail(),
                                   roles,
                                   userDetails.getApiList(),
                                    jwtExpirationMs
                ));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest){

    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    Users users = new Users();
    users.setUsername(signUpRequest.getUsername());
    users.setEmail(signUpRequest.getEmail());
    users.setPassword(encoder.encode(signUpRequest.getPassword()));

    Set<String> strRoles = signUpRequest.getRole();
    Set<Roles> roles = new HashSet<>();

    if (strRoles == null) {
      Roles userRole = roleRepository.findByName(ERole.ROLE_STUDENTS)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Roles adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);
          break;
        case "staffs":
          Roles modRole = roleRepository.findByName(ERole.ROLE_STAFFS)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);
          break;
        default:
          Roles userRole = roleRepository.findByName(ERole.ROLE_STUDENTS)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }
    users.setRoles(roles);
    userRepository.save(users);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}
