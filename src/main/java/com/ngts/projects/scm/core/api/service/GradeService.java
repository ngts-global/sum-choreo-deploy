package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.GradeDTO;
import com.ngts.projects.scm.core.api.entity.Grade;
import com.ngts.projects.scm.core.api.repository.GradeRepository;
import com.ngts.projects.scm.core.api.vo.GradeQueryVO;
import com.ngts.projects.scm.core.api.vo.GradeUpdateVO;
import com.ngts.projects.scm.core.api.vo.GradeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GradeService {

    @Autowired
    private GradeRepository gradeRepository;

    public Integer save(GradeVO vO) {
        Grade bean = new Grade();
        BeanUtils.copyProperties(vO, bean);
        bean = gradeRepository.save(bean);
        return bean.getGradeId();
    }

    public void delete(Integer id) {
        gradeRepository.deleteById(id);
    }

    public void update(Integer id, GradeUpdateVO vO) {
        Grade bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        gradeRepository.save(bean);
    }

    public GradeDTO getById(Integer id) {
        Grade original = requireOne(id);
        return toDTO(original);
    }

    public Page<GradeDTO> query(GradeQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GradeDTO toDTO(Grade original) {
        GradeDTO bean = new GradeDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Grade requireOne(Integer id) {
        return gradeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
