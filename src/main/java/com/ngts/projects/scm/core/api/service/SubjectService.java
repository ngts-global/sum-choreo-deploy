package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.SubjectDTO;
import com.ngts.projects.scm.core.api.entity.Subject;
import com.ngts.projects.scm.core.api.repository.SubjectRepository;
import com.ngts.projects.scm.core.api.vo.SubjectQueryVO;
import com.ngts.projects.scm.core.api.vo.SubjectUpdateVO;
import com.ngts.projects.scm.core.api.vo.SubjectVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public Integer save(SubjectVO vO) {
        Subject bean = new Subject();
        BeanUtils.copyProperties(vO, bean);
        bean = subjectRepository.save(bean);
        return bean.getSubjectId();
    }

    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    public void update(Integer id, SubjectUpdateVO vO) {
        Subject bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        subjectRepository.save(bean);
    }

    public SubjectDTO getById(Integer id) {
        Subject original = requireOne(id);
        return toDTO(original);
    }

    public Page<SubjectDTO> query(SubjectQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SubjectDTO toDTO(Subject original) {
        SubjectDTO bean = new SubjectDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Subject requireOne(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
