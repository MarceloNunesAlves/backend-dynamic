package br.com.flexvision.befd.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RowView {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@OneToMany
	private List<Widget> Widgets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Widget> getWidgets() {
		return Widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		Widgets = widgets;
	}

}
