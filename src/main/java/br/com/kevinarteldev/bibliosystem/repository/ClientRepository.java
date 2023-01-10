package br.com.kevinarteldev.bibliosystem.repository;

import br.com.kevinarteldev.bibliosystem.entity.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    @Query("Select * FROM Client ORDER BY id")
    Page<ClientEntity> returnAll(Pageable pageable);
}
