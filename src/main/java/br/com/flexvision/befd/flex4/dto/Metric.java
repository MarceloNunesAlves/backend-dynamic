package br.com.flexvision.befd.flex4.dto;

public class Metric {

	private int met_id;
	private String name;
	private int ndt_id;
	private String unit_type;

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
	
}
