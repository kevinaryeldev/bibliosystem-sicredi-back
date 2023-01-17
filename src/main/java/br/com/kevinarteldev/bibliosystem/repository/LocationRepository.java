package br.com.kevinarteldev.bibliosystem.repository;


import br.com.kevinarteldev.bibliosystem.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

}
