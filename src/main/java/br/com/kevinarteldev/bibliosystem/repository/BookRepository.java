package br.com.kevinarteldev.bibliosystem.repository;

import br.com.kevinarteldev.bibliosystem.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {
}
