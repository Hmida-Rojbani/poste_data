package tn.poste.data.project.entities;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import tn.poste.data.project.dto.AddressDto;
import tn.poste.data.project.dto.BookDto;

@Getter
@Setter
@ToString(exclude = "telphoneNumber")
@Entity
@Table(name = "Author")
public class AuthorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String firstName;
	private int telphoneNumber;

	
	@OneToMany(mappedBy = "author")
	private List<BookEntity> books;
	
	@OneToOne
	private AddressEntity address;
	
	
	public List<BookDto> getBooks(){
		return books.stream()
					.map(book -> new BookDto(book.getTitle(), book.getIsbn()))
					.collect(Collectors.toList());
	}
	
	public AddressDto getAddress() {
		return AddressDto.builder()
						 .number(address.getNumber())
						 .street(address.getStreet())
						 .city(address.getCity())
						 .build();
							
	}
}
