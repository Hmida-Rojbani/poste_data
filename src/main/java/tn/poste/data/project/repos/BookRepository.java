package tn.poste.data.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.poste.data.project.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{

}
