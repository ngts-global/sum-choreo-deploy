package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.ClassDTO;
import com.ngts.projects.scm.core.api.entity.Class;
import com.ngts.projects.scm.core.api.repository.ClassRepository;
import com.ngts.projects.scm.core.api.vo.ClassQueryVO;
import com.ngts.projects.scm.core.api.vo.ClassUpdateVO;
import com.ngts.projects.scm.core.api.vo.ClassVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public Integer save(ClassVO vO) {
        Class bean = new Class();
        BeanUtils.copyProperties(vO, bean);
        bean = classRepository.save(bean);
        return bean.getClassId();
    }

    public void delete(Integer id) {
        classRepository.deleteById(id);
    }

    public void update(Integer id, ClassUpdateVO vO) {
        Class bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        classRepository.save(bean);
    }

    public ClassDTO getById(Integer id) {
        Class original = requireOne(id);
        return toDTO(original);
    }

    public Page<ClassDTO> query(ClassQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ClassDTO toDTO(Class original) {
        ClassDTO bean = new ClassDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Class requireOne(Integer id) {
        return classRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
