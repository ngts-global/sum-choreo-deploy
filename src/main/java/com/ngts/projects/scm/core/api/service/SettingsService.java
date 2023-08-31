package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.SettingsDTO;
import com.ngts.projects.scm.core.api.entity.Settings;
import com.ngts.projects.scm.core.api.repository.SettingsRepository;
import com.ngts.projects.scm.core.api.vo.SettingsQueryVO;
import com.ngts.projects.scm.core.api.vo.SettingsUpdateVO;
import com.ngts.projects.scm.core.api.vo.SettingsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository settingsRepository;

    public Integer save(SettingsVO vO) {
        Settings bean = new Settings();
        BeanUtils.copyProperties(vO, bean);
        bean = settingsRepository.save(bean);
        return bean.getSettingsId();
    }

    public void delete(Integer id) {
        settingsRepository.deleteById(id);
    }

    public void update(Integer id, SettingsUpdateVO vO) {
        Settings bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        settingsRepository.save(bean);
    }

    public SettingsDTO getById(Integer id) {
        Settings original = requireOne(id);
        return toDTO(original);
    }

    public Page<SettingsDTO> query(SettingsQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private SettingsDTO toDTO(Settings original) {
        SettingsDTO bean = new SettingsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Settings requireOne(Integer id) {
        return settingsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
