package hibernate.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import jakarta.persistence.ManyToMany;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String roleName;
	private String code;
	@ManyToMany(mappedBy = "roleList")
	private Set<Customer> cusList = new HashSet<Customer>();

	public Role() {
	}

	public Role(Integer id, String roleName, String code) {
		this.id = id;
		this.roleName = roleName;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<Customer> getCusList() {
		return cusList;
	}

	public void setCusList(Set<Customer> cusList) {
		this.cusList = cusList;
	}

}
