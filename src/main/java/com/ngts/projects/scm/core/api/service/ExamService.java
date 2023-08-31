package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.ExamDTO;
import com.ngts.projects.scm.core.api.entity.Exam;
import com.ngts.projects.scm.core.api.repository.ExamRepository;
import com.ngts.projects.scm.core.api.vo.ExamQueryVO;
import com.ngts.projects.scm.core.api.vo.ExamUpdateVO;
import com.ngts.projects.scm.core.api.vo.ExamVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public Integer save(ExamVO vO) {
        Exam bean = new Exam();
        BeanUtils.copyProperties(vO, bean);
        bean = examRepository.save(bean);
        return bean.getExamId();
    }

    public void delete(Integer id) {
        examRepository.deleteById(id);
    }

    public void update(Integer id, ExamUpdateVO vO) {
        Exam bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        examRepository.save(bean);
    }

    public ExamDTO getById(Integer id) {
        Exam original = requireOne(id);
        return toDTO(original);
    }

    public Page<ExamDTO> query(ExamQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ExamDTO toDTO(Exam original) {
        ExamDTO bean = new ExamDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Exam requireOne(Integer id) {
        return examRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
