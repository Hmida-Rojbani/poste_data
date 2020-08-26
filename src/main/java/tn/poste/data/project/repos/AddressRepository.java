package tn.poste.data.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.data.project.entities.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long>{

}
