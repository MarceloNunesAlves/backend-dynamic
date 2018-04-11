package br.com.flexvision.befd.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import br.com.flexvision.befd.flex4.dto.TypeOrigin;

@Entity
public class OptionException {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column
	private String name;
	@Column
	private boolean com = false;
	@Column
	private TypeOrigin origin;
	@ManyToOne
	@JoinColumn(name = "itemFilter_id")
	private ItemFilter itemFilter;

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

	public ItemFilter getItemFilter() {
		return itemFilter;
	}

	public void setItemFilter(ItemFilter itemFilter) {
		this.itemFilter = itemFilter;
	}
	
}
