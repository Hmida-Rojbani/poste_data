package tn.poste.data.project.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tn.poste.data.project.entities.AuthorEntity;
import tn.poste.data.project.repos.AuthorRepository;

@Service
@AllArgsConstructor
public class AuthorService {
	
	private AuthorRepository authorRepository;
	
	public List<AuthorEntity> getAll(){
		return authorRepository.findAll();
	}
	
	public AuthorEntity getById(Long id){
		Optional<AuthorEntity> opt = authorRepository.findById(id);
		/*AuthorEntity author = null;
		if(opt.isPresent())
			author = opt.get();
		return author;
		*/
		
		return opt.orElse(null);
	}
	

}
