package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.UsersDTO;
import com.ngts.projects.scm.core.api.entity.Users;
import com.ngts.projects.scm.core.api.repository.UsersRepository;
import com.ngts.projects.scm.core.api.vo.UsersQueryVO;
import com.ngts.projects.scm.core.api.vo.UsersUpdateVO;
import com.ngts.projects.scm.core.api.vo.UsersVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Integer save(UsersVO vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = usersRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }

    public void update(Integer id, UsersUpdateVO vO) {
        Users bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usersRepository.save(bean);
    }

    public UsersDTO getById(Integer id) {
        Users original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsersDTO> query(UsersQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UsersDTO toDTO(Users original) {
        UsersDTO bean = new UsersDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Users requireOne(Integer id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
