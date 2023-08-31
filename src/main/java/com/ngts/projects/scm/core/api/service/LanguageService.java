package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.LanguageDTO;
import com.ngts.projects.scm.core.api.entity.Language;
import com.ngts.projects.scm.core.api.repository.LanguageRepository;
import com.ngts.projects.scm.core.api.vo.LanguageQueryVO;
import com.ngts.projects.scm.core.api.vo.LanguageUpdateVO;
import com.ngts.projects.scm.core.api.vo.LanguageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public Integer save(LanguageVO vO) {
        Language bean = new Language();
        BeanUtils.copyProperties(vO, bean);
        bean = languageRepository.save(bean);
        return bean.getPhraseId();
    }

    public void delete(Integer id) {
        languageRepository.deleteById(id);
    }

    public void update(Integer id, LanguageUpdateVO vO) {
        Language bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        languageRepository.save(bean);
    }

    public LanguageDTO getById(Integer id) {
        Language original = requireOne(id);
        return toDTO(original);
    }

    public Page<LanguageDTO> query(LanguageQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private LanguageDTO toDTO(Language original) {
        LanguageDTO bean = new LanguageDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Language requireOne(Integer id) {
        return languageRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
