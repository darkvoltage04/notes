package security.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
//@Table(name="MyUser")

public class User {
	
	@Id
	private String userName;
	private String userPassword;
	private boolean isActivated=true;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "User_Role",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles=new HashSet();
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isActivated() {
		return isActivated;
	}
	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPassword=" + userPassword + ", isActivated=" + isActivated
				+ ", roles=" + roles + "]";
	}
	
	
	
	

}
