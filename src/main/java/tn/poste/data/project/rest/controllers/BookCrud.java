package tn.poste.data.project.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.poste.data.project.dto.BookDto;
import tn.poste.data.project.services.BookService;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookCrud {
	
	private BookService bookService;
	
	@GetMapping("/all")
	public List<BookDto> getAll(){
		return bookService.getAll();
	}

}
