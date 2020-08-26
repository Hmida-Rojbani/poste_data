package tn.poste.data.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
	private String title;
	private String isbn;

	private AuthorDto author;

	public BookDto(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	
	
}
