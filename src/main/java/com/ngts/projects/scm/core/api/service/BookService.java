package com.ngts.projects.scm.core.api.service;

import com.ngts.projects.scm.core.api.dto.BookDTO;
import com.ngts.projects.scm.core.api.entity.Book;
import com.ngts.projects.scm.core.api.repository.BookRepository;
import com.ngts.projects.scm.core.api.vo.BookQueryVO;
import com.ngts.projects.scm.core.api.vo.BookUpdateVO;
import com.ngts.projects.scm.core.api.vo.BookVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Integer save(BookVO vO) {
        Book bean = new Book();
        BeanUtils.copyProperties(vO, bean);
        bean = bookRepository.save(bean);
        return bean.getBookId();
    }

    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    public void update(Integer id, BookUpdateVO vO) {
        Book bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        bookRepository.save(bean);
    }

    public BookDTO getById(Integer id) {
        Book original = requireOne(id);
        return toDTO(original);
    }

    public Page<BookDTO> query(BookQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private BookDTO toDTO(Book original) {
        BookDTO bean = new BookDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Book requireOne(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
