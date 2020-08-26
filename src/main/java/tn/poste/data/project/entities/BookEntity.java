package tn.poste.data.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import tn.poste.data.project.dto.AuthorDto;


@Entity
@Data
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	@Column(unique = true)
	private String isbn;
	
	@ManyToOne
	private AuthorEntity author;
	
	public AuthorDto getAuthor() {
		return new AuthorDto(author.getName(), author.getFirstName(), author.getTelphoneNumber());
	}

}
