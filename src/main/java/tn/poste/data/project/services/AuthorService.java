package tn.poste.data.project.services;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.AuthorDto;
import tn.poste.data.project.entities.AddressEntity;
import tn.poste.data.project.entities.AuthorEntity;
import tn.poste.data.project.repos.AddressRepository;
import tn.poste.data.project.repos.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {
	
	private AuthorRepository authorRepository;
	private AddressRepository addressRepository;
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
	
	public AuthorDto createAuthor(AuthorDto authorDto) {
		AuthorEntity author = modelMapper.map(authorDto, AuthorEntity.class);
		AddressEntity adEntity = modelMapper.map(authorDto.getAddress(), AddressEntity.class);
		addressRepository.save(adEntity);
		author.setBooks(new ArrayList<>());
		author.setAddress(adEntity);
		
		if(author.getName() != null && author.getFirstName() != null)
			author = authorRepository.save(author);
		else
			throw new IllegalArgumentException(" Null Fields in the author");
		return modelMapper.map(author, AuthorDto.class);
	}
	
	public AuthorDto getByName(String name){
		
			return modelMapper.map(authorRepository.findByName(name).get(0),AuthorDto.class);
	}
	
	
	

}
