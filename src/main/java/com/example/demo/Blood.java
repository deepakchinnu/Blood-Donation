package com.example.demo;
import javax.persistence.*;
@Entity
@Table(name = "blood")
public class Blood {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @Column(nullable = false, length = 45)
	private String name;
    @Column(nullable = false, unique = true, length = 45)
	private String email;
    @Column(nullable = false,length = 45)
	private String age;
    @Column(nullable = false,length = 45)
	private String bloodgroup;
    @Column(nullable = false,length = 45)
	private String gender;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
