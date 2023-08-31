package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.ParentDTO;
import com.ngts.projects.scm.core.api.entity.Parent;
import com.ngts.projects.scm.core.api.repository.ParentRepository;
import com.ngts.projects.scm.core.api.vo.ParentQueryVO;
import com.ngts.projects.scm.core.api.vo.ParentUpdateVO;
import com.ngts.projects.scm.core.api.vo.ParentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    public Integer save(ParentVO vO) {
        Parent bean = new Parent();
        BeanUtils.copyProperties(vO, bean);
        bean = parentRepository.save(bean);
        return bean.getParentId();
    }

    public void delete(Integer id) {
        parentRepository.deleteById(id);
    }

    public void update(Integer id, ParentUpdateVO vO) {
        Parent bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        parentRepository.save(bean);
    }

    public ParentDTO getById(Integer id) {
        Parent original = requireOne(id);
        return toDTO(original);
    }

    public Page<ParentDTO> query(ParentQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ParentDTO toDTO(Parent original) {
        ParentDTO bean = new ParentDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Parent requireOne(Integer id) {
        return parentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
