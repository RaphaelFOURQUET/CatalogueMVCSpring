package fr.adaming.mycatalogue.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUser;
	
	private String userName;
	
	private String password;
	
	private boolean actived;
	
	//Va creer une classe d'association par defaut
	@OneToMany
	private List<Role> roles;

	//ACCESSEURS
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getIdUser() {
		return idUser;
	}

	//CONSTRUCTEURS
	public User() {
		
	}
	
	public User(String userName, String password, boolean actived, List<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.actived = actived;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", actived=" + actived
				+ ", roles=" + roles + "]";
	}
	
	

}
