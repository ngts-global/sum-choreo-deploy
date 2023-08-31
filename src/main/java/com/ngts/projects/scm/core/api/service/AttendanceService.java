package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.AttendanceDTO;
import com.ngts.projects.scm.core.api.entity.Attendance;
import com.ngts.projects.scm.core.api.repository.AttendanceRepository;
import com.ngts.projects.scm.core.api.vo.AttendanceQueryVO;
import com.ngts.projects.scm.core.api.vo.AttendanceUpdateVO;
import com.ngts.projects.scm.core.api.vo.AttendanceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Integer save(AttendanceVO vO) {
        Attendance bean = new Attendance();
        BeanUtils.copyProperties(vO, bean);
        bean = attendanceRepository.save(bean);
        return bean.getAttendanceId();
    }

    public void delete(Integer id) {
        attendanceRepository.deleteById(id);
    }

    public void update(Integer id, AttendanceUpdateVO vO) {
        Attendance bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        attendanceRepository.save(bean);
    }

    public AttendanceDTO getById(Integer id) {
        Attendance original = requireOne(id);
        return toDTO(original);
    }

    public Page<AttendanceDTO> query(AttendanceQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private AttendanceDTO toDTO(Attendance original) {
        AttendanceDTO bean = new AttendanceDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Attendance requireOne(Integer id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
