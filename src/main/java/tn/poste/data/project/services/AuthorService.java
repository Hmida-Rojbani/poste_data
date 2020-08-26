package tn.poste.data.project.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.AuthorDto;
import tn.poste.data.project.dto.BookDto;
import tn.poste.data.project.entities.AuthorEntity;
import tn.poste.data.project.entities.BookEntity;
import tn.poste.data.project.repos.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {
	
	private AuthorRepository authorRepository;
	
	public List<AuthorEntity> getAll(){
		return authorRepository.findAll();
	}
	
	public AuthorDto getById(Long id){
		Optional<AuthorEntity> opt = authorRepository.findById(id);
		/*AuthorEntity author = null;
		if(opt.isPresent())
			author = opt.get();
		return author;
		*/
		
		AuthorEntity author = opt.orElse(null);
		/*List<BookDto> books = new ArrayList<>();
		for (BookEntity book : author.getBooks()) {
			books.add(new BookDto(book.getTitle(), book.getIsbn()));
		}*/
		
		List<BookDto> books = author.getBooks().stream()
				.map(book -> new BookDto(book.getTitle(), book.getIsbn()))
				.collect(Collectors.toList());
		
			AuthorDto dto = new AuthorDto(author.getName(), author.getFirstName(), author.getTelphoneNumber(), books);
		ModelMapper modelMapper= new ModelMapper();
		modelMapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.STRICT);
			return modelMapper.map(author,AuthorDto.class);
	}
	
	public AuthorEntity createAuthor(AuthorEntity author) {
		if(author.getName() != null && author.getFirstName() != null)
			author = authorRepository.save(author);
		else
			throw new RuntimeException(" Null Fields in the author");
		return author;
	}
	

}
