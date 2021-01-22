package natan.io.projeto1.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String name;
	
	@ManyToMany
	private Set<Role> roles;	
	
	public User() {
	}

	public User(String name, String email) {
		super();
		this.email = email;
		this.name = name;
	}


	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
