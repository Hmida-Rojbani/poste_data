package tn.poste.data.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.data.project.entities.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long>{

}
