package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.ClassRoutineDTO;
import com.ngts.projects.scm.core.api.entity.ClassRoutine;
import com.ngts.projects.scm.core.api.repository.ClassRoutineRepository;
import com.ngts.projects.scm.core.api.vo.ClassRoutineQueryVO;
import com.ngts.projects.scm.core.api.vo.ClassRoutineUpdateVO;
import com.ngts.projects.scm.core.api.vo.ClassRoutineVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClassRoutineService {

    @Autowired
    private ClassRoutineRepository classRoutineRepository;

    public Integer save(ClassRoutineVO vO) {
        ClassRoutine bean = new ClassRoutine();
        BeanUtils.copyProperties(vO, bean);
        bean = classRoutineRepository.save(bean);
        return bean.getClassRoutineId();
    }

    public void delete(Integer id) {
        classRoutineRepository.deleteById(id);
    }

    public void update(Integer id, ClassRoutineUpdateVO vO) {
        ClassRoutine bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        classRoutineRepository.save(bean);
    }

    public ClassRoutineDTO getById(Integer id) {
        ClassRoutine original = requireOne(id);
        return toDTO(original);
    }

    public Page<ClassRoutineDTO> query(ClassRoutineQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ClassRoutineDTO toDTO(ClassRoutine original) {
        ClassRoutineDTO bean = new ClassRoutineDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private ClassRoutine requireOne(Integer id) {
        return classRoutineRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
