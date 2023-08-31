package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.TeacherDTO;
import com.ngts.projects.scm.core.api.entity.Teacher;
import com.ngts.projects.scm.core.api.repository.TeacherRepository;
import com.ngts.projects.scm.core.api.vo.TeacherQueryVO;
import com.ngts.projects.scm.core.api.vo.TeacherUpdateVO;
import com.ngts.projects.scm.core.api.vo.TeacherVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TeacherRepository teacherRepository;

    public Integer save(TeacherVO vO) {
        Teacher bean = new Teacher();
        BeanUtils.copyProperties(vO, bean);
        bean = teacherRepository.save(bean);
        return bean.getTeacherId();
    }

    public void delete(Integer id) {
        teacherRepository.deleteById(id);
    }

    public void update(Integer id, TeacherUpdateVO vO) {
        Teacher bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        teacherRepository.save(bean);
    }

    public TeacherDTO getById(Integer id) {
        Teacher original = requireOne(id);
        return toDTO(original);
    }

    public Page<TeacherDTO> query(TeacherQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TeacherDTO toDTO(Teacher original) {
        TeacherDTO bean = new TeacherDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Teacher requireOne(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository
                .findAll()
                .stream()
                .map(this::mapToStudentDTO)
                .collect(Collectors.toList());
    }

    private TeacherDTO mapToStudentDTO(Teacher teacher) {
        return mapper.map(teacher, TeacherDTO.class);
    }

}
