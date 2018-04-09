package br.com.flexvision.befd.flex4.dto;

import java.io.Serializable;

public class SubItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2216670632294044657L;
	
	private int id;
	private String name;
	private boolean com=false;
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
