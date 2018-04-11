package br.com.flexvision.befd.main.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ItemFilter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column
	private String name;
	@Column
	private String tituloSerie;
	@Column
	private int ndt_id;
	@Column
	private String unit_type;
	@OneToMany
	private List<OptionException> options;
	
	@ManyToOne
	@JoinColumn(name = "widget_id")
	private Widget widget;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTituloSerie() {
		return tituloSerie;
	}

	public void setTituloSerie(String tituloSerie) {
		this.tituloSerie = tituloSerie;
	}

	public int getNdt_id() {
		return ndt_id;
	}

	public void setNdt_id(int ndt_id) {
		this.ndt_id = ndt_id;
	}

	public String getUnit_type() {
		return unit_type;
	}

	public void setUnit_type(String unit_type) {
		this.unit_type = unit_type;
	}

	public List<OptionException> getOptions() {
		return options;
	}

	public void setOptions(List<OptionException> options) {
		this.options = options;
	}

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

}
