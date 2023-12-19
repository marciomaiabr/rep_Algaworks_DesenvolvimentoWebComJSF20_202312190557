package pkgs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String razSoc;
	private String nomFantasia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRazSoc() {
		return razSoc;
	}

	public void setRazSoc(String razSoc) {
		this.razSoc = razSoc;
	}

	public String getNomFantasia() {
		return nomFantasia;
	}

	public void setNomFantasia(String nomFantasia) {
		this.nomFantasia = nomFantasia;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razSoc=" + razSoc + ", nomFantasia=" + nomFantasia + "]";
	}

}
