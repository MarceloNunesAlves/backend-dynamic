package br.com.flexvision.befd.main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import br.com.flexvision.befd.flex4.dto.DataSourceOrigin;

@Entity
public class ItemFilter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1704802647246877006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column
	private int met_id;
	@Column
	private String name;
	@Column
	private String tituloSerie;
	@Column
	private int ndt_id;
	@Column
	private String unit_type;
	@Column
	private String color;
	@Column
	private Integer position;
	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval=true)
	@JoinColumn(name = "itemFilter_id")
	private List<OptionException> options;
	@Column
	private DataSourceOrigin ori;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public int getMet_id() {
		return met_id;
	}
	public void setMet_id(int met_id) {
		this.met_id = met_id;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}

	public DataSourceOrigin getOri() {
		return ori;
	}

	public void setOri(DataSourceOrigin ori) {
		this.ori = ori;
	}

	public List<OptionException> getOptions() {
		return options;
	}
	public void setOptions(List<OptionException> options) {
		this.options = options;
	}
}
