package tn.poste.data.project.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.AuthorDto;
import tn.poste.data.project.entities.AuthorEntity;
import tn.poste.data.project.services.AuthorService;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorCrud {
	
	private AuthorService authorService;
	
	@GetMapping("/all")
	public List<AuthorEntity> allAuthors(){
		return authorService.getAll();
	}
	
	@GetMapping("/id/{id}")
	public AuthorDto OneAuthor(@PathVariable("id") Long id){
		return authorService.getById(id);
	}
	
	@PostMapping("/save")
	public AuthorEntity saveAuthor(@RequestBody AuthorEntity auth) {
		return authorService.createAuthor(auth);
	}

}
