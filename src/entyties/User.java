package entyties;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "USER")
public class User {

	public enum Role {
		ADMIN,DISPO,FACTORING,SELLER,VIEWER
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
	
	@Column(name ="USER_NAME")
	private String name;
	
	@Column(name ="USER_SURNAME")
	private String surname;
	
	@Column(name ="USER_SHORTNAME")
	private String shortName;
	
	@Column(name ="USER_LOGIN")
	private String login;
	
	@Column(name ="USER_PASSWORD")
	private String password;

	@OneToMany(mappedBy = "user")
	private List<OrderCiment> orderCiments;
	/*
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Customer> customers;
	*/

	@Column(name ="USER_ROLE")
	@Enumerated(EnumType.STRING)
	private Role role;



	public User() {
		
	}

	public User(String name, String surname, String shortName, String login, String password) {
		
		this.name = name;
		this.surname = surname;
		this.shortName = shortName;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;

	}

	public Role getRole() {
		return this.role;
	}
	




	
	
}
