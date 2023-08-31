package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.UserRolesDTO;
import com.ngts.projects.scm.core.api.entity.UserRoles;
import com.ngts.projects.scm.core.api.repository.UserRolesRepository;
import com.ngts.projects.scm.core.api.vo.UserRolesQueryVO;
import com.ngts.projects.scm.core.api.vo.UserRolesUpdateVO;
import com.ngts.projects.scm.core.api.vo.UserRolesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserRolesService {

    @Autowired
    private UserRolesRepository userRolesRepository;

    public Integer save(UserRolesVO vO) {
        UserRoles bean = new UserRoles();
        BeanUtils.copyProperties(vO, bean);
        bean = userRolesRepository.save(bean);
        return bean.getRoleId();
    }

    public void delete(Integer id) {
        userRolesRepository.deleteById(id);
    }

    public void update(Integer id, UserRolesUpdateVO vO) {
        UserRoles bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRolesRepository.save(bean);
    }

    public UserRolesDTO getById(Integer id) {
        UserRoles original = requireOne(id);
        return toDTO(original);
    }

    public Page<UserRolesDTO> query(UserRolesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserRolesDTO toDTO(UserRoles original) {
        UserRolesDTO bean = new UserRolesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UserRoles requireOne(Integer id) {
        return userRolesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
