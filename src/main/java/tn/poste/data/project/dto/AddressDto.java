package tn.poste.data.project.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
	
	private int number;
	private String street;
	private String city;

}
