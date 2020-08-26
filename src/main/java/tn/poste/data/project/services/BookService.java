package tn.poste.data.project.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.entities.BookEntity;
import tn.poste.data.project.repos.BookRepository;

@Service
@AllArgsConstructor
public class BookService {
	
	private BookRepository bookRepository;
	
	public List<BookEntity> getAll(){
		return bookRepository.findAll();
	}

}
