package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.RolesDTO;
import com.ngts.projects.scm.core.api.entity.Roles;
import com.ngts.projects.scm.core.api.repository.RolesRepository;
import com.ngts.projects.scm.core.api.vo.RolesQueryVO;
import com.ngts.projects.scm.core.api.vo.RolesUpdateVO;
import com.ngts.projects.scm.core.api.vo.RolesVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public Integer save(RolesVO vO) {
        Roles bean = new Roles();
        BeanUtils.copyProperties(vO, bean);
        bean = rolesRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        rolesRepository.deleteById(id);
    }

    public void update(Integer id, RolesUpdateVO vO) {
        Roles bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        rolesRepository.save(bean);
    }

    public RolesDTO getById(Integer id) {
        Roles original = requireOne(id);
        return toDTO(original);
    }

    public Page<RolesDTO> query(RolesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private RolesDTO toDTO(Roles original) {
        RolesDTO bean = new RolesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Roles requireOne(Integer id) {
        return rolesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
