package com.FSAD_SDP_10.library_backend.repository;

import com.FSAD_SDP_10.library_backend.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring gives you .findAll(), .save(), .delete() for free!
}