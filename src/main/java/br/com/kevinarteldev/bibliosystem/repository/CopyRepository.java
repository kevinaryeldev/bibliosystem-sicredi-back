package br.com.kevinarteldev.bibliosystem.repository;
import br.com.kevinarteldev.bibliosystem.entity.CopyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends JpaRepository<CopyEntity, Integer> {
}
