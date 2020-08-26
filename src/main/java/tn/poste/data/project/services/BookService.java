package tn.poste.data.project.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.BookDto;
import tn.poste.data.project.repos.BookRepository;

@Service
@AllArgsConstructor
public class BookService {
	
	private BookRepository bookRepository;
	private ModelMapper mapper;
	
	public List<BookDto> getAll(){
		return bookRepository.findAll().stream()
								.map(book-> mapper.map(book, BookDto.class))
								.collect(Collectors.toList());
			
		 
	}

}
