package br.com.flexvision.befd.flex4.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Metric implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2328241671911254760L;
	
	private int met_id;
	private String name;
	private String tituloSerie;
	private int ndt_id;
	private String unit_type;
	private String color;
	private int position;
	private List<SubItem> options;
	private DataSourceOrigin ori;
	
	public Metric() {
		super();
		this.options = new ArrayList<SubItem>();
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
	public List<SubItem> getOptions() {
		return options;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public void setOptions(List<SubItem> options) {
		this.options = options;
	}
	public String getTituloSerie() {
		return tituloSerie;
	}
	public void setTituloSerie(String tituloSerie) {
		this.tituloSerie = tituloSerie;
	}
	public DataSourceOrigin getOri() {
		return ori;
	}
	public void setOri(DataSourceOrigin ori) {
		this.ori = ori;
	}

}
