package com.example.libproj.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import com.example.libproj.enums.Role;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    
    
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<User> users;
    
    public Admin() {
    }

    public Admin(String name, String email) {
        this.name = name;
        this.email = email;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

	

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", email=" + email +  "]";
	}

   
	
}
