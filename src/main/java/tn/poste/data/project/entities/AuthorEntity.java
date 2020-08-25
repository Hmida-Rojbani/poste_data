package tn.poste.data.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "telphoneNumber")
@Entity
@Table(name = "Author")
public class AuthorEntity {
	
	@Id
	private Long id;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String firstName;
	private int telphoneNumber;

}
