package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.NoticeboardDTO;
import com.ngts.projects.scm.core.api.entity.Noticeboard;
import com.ngts.projects.scm.core.api.repository.NoticeboardRepository;
import com.ngts.projects.scm.core.api.vo.NoticeboardQueryVO;
import com.ngts.projects.scm.core.api.vo.NoticeboardUpdateVO;
import com.ngts.projects.scm.core.api.vo.NoticeboardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class NoticeboardService {

    @Autowired
    private NoticeboardRepository noticeboardRepository;

    public Integer save(NoticeboardVO vO) {
        Noticeboard bean = new Noticeboard();
        BeanUtils.copyProperties(vO, bean);
        bean = noticeboardRepository.save(bean);
        return bean.getNoticeId();
    }

    public void delete(Integer id) {
        noticeboardRepository.deleteById(id);
    }

    public void update(Integer id, NoticeboardUpdateVO vO) {
        Noticeboard bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        noticeboardRepository.save(bean);
    }

    public NoticeboardDTO getById(Integer id) {
        Noticeboard original = requireOne(id);
        return toDTO(original);
    }

    public Page<NoticeboardDTO> query(NoticeboardQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private NoticeboardDTO toDTO(Noticeboard original) {
        NoticeboardDTO bean = new NoticeboardDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Noticeboard requireOne(Integer id) {
        return noticeboardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
