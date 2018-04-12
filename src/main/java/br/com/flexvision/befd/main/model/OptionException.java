package br.com.flexvision.befd.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.flexvision.befd.flex4.dto.TypeOrigin;

@Entity
public class OptionException {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column
	private Integer idOri;
	@Column
	private String name;
	@Column
	private boolean com = false;
	@Column
	private TypeOrigin origin;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdOri() {
		return idOri;
	}

	public void setIdOri(Integer idOri) {
		this.idOri = idOri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCom() {
		return com;
	}

	public void setCom(boolean com) {
		this.com = com;
	}

	public TypeOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(TypeOrigin origin) {
		this.origin = origin;
	}
	
}
