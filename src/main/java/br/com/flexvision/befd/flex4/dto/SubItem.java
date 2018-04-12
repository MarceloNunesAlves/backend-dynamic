package br.com.flexvision.befd.flex4.dto;

import java.io.Serializable;

public class SubItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2216670632294044657L;
	
	private int idOri;
	private String name;
	private boolean com=false;
	private TypeOrigin origin;
	
	public int getIdOri() {
		return idOri;
	}
	public void setIdOri(int idOri) {
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
