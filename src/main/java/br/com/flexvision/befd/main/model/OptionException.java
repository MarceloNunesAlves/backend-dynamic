package br.com.flexvision.befd.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import br.com.flexvision.befd.flex4.dto.TypeOrigin;

@Entity
public class OptionException {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column
	private String name;
	@Column
	private boolean com = false;
	@Column
	private TypeOrigin origin;

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
