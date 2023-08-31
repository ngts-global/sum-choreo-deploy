package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.DormitoryDTO;
import com.ngts.projects.scm.core.api.entity.Dormitory;
import com.ngts.projects.scm.core.api.repository.DormitoryRepository;
import com.ngts.projects.scm.core.api.vo.DormitoryQueryVO;
import com.ngts.projects.scm.core.api.vo.DormitoryUpdateVO;
import com.ngts.projects.scm.core.api.vo.DormitoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DormitoryService {

    @Autowired
    private DormitoryRepository dormitoryRepository;

    public Integer save(DormitoryVO vO) {
        Dormitory bean = new Dormitory();
        BeanUtils.copyProperties(vO, bean);
        bean = dormitoryRepository.save(bean);
        return bean.getDormitoryId();
    }

    public void delete(Integer id) {
        dormitoryRepository.deleteById(id);
    }

    public void update(Integer id, DormitoryUpdateVO vO) {
        Dormitory bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        dormitoryRepository.save(bean);
    }

    public DormitoryDTO getById(Integer id) {
        Dormitory original = requireOne(id);
        return toDTO(original);
    }

    public Page<DormitoryDTO> query(DormitoryQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private DormitoryDTO toDTO(Dormitory original) {
        DormitoryDTO bean = new DormitoryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Dormitory requireOne(Integer id) {
        return dormitoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
