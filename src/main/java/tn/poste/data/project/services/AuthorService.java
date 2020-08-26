package tn.poste.data.project.services;



import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.AuthorDto;
import tn.poste.data.project.entities.AuthorEntity;
import tn.poste.data.project.repos.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {
	
	private AuthorRepository authorRepository;
	private ModelMapper modelMapper;
	
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
	
			return modelMapper.map(author,AuthorDto.class);
	}
	
	public AuthorEntity createAuthor(AuthorEntity author) {
		if(author.getName() != null && author.getFirstName() != null)
			author = authorRepository.save(author);
		else
			throw new RuntimeException(" Null Fields in the author");
		return author;
	}
	
	public AuthorDto getByName(String name){
		
			return modelMapper.map(authorRepository.findByName(name).get(0),AuthorDto.class);
	}
	
	
	

}
