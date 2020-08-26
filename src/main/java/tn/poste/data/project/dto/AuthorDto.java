package tn.poste.data.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
	
	private String name;
	private String firstName;
	
	private int telphoneNumber;

	private List<BookDto> books;
	
	private AddressDto address;

	public AuthorDto(String name, String firstName, int telphoneNumber) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.telphoneNumber = telphoneNumber;
	}
	
	

}
