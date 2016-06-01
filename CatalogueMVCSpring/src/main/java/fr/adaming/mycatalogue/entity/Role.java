package fr.adaming.mycatalogue.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long idRole;
	
	private String roleName;

	//ACCESSEURS
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getIdRole() {
		return idRole;
	}
	
	

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	//CONSTRUCTEURS
	public Role() {
		
	}
	
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
	}
	
}
