package tn.poste.data.project.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
	
	@NotNull(message = "Name must not be null")
	private String name;
	@NotBlank(message = "FirstName must exist")
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
