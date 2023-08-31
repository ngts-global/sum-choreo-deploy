package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.MarkDTO;
import com.ngts.projects.scm.core.api.entity.Mark;
import com.ngts.projects.scm.core.api.repository.MarkRepository;
import com.ngts.projects.scm.core.api.vo.MarkQueryVO;
import com.ngts.projects.scm.core.api.vo.MarkUpdateVO;
import com.ngts.projects.scm.core.api.vo.MarkVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    public Integer save(MarkVO vO) {
        Mark bean = new Mark();
        BeanUtils.copyProperties(vO, bean);
        bean = markRepository.save(bean);
        return bean.getMarkId();
    }

    public void delete(Integer id) {
        markRepository.deleteById(id);
    }

    public void update(Integer id, MarkUpdateVO vO) {
        Mark bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        markRepository.save(bean);
    }

    public MarkDTO getById(Integer id) {
        Mark original = requireOne(id);
        return toDTO(original);
    }

    public Page<MarkDTO> query(MarkQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private MarkDTO toDTO(Mark original) {
        MarkDTO bean = new MarkDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Mark requireOne(Integer id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
