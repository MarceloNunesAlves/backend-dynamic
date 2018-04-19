package br.com.flexvision.befd.main.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3991815446605096519L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	@Column(name = "colorPrimary")
	private String colorPrimary;
	@Column(name = "fontPrimaryDark")
	private Boolean fontPrimaryDark;
	@Column(name = "colorSecondary")
	private String colorSecondary;
	@Column(name = "fontSecondaryDark")
	private Boolean fontSecondaryDark;
	@Column(name = "logo", nullable=true, columnDefinition="mediumblob")
	private String logo;
	
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
	public String getColorPrimary() {
		return colorPrimary;
	}
	public void setColorPrimary(String colorPrimary) {
		this.colorPrimary = colorPrimary;
	}
	public Boolean getFontPrimaryDark() {
		return fontPrimaryDark;
	}
	public void setFontPrimaryDark(Boolean fontPrimaryDark) {
		this.fontPrimaryDark = fontPrimaryDark;
	}
	public String getColorSecondary() {
		return colorSecondary;
	}
	public void setColorSecondary(String colorSecondary) {
		this.colorSecondary = colorSecondary;
	}
	public Boolean getFontSecondaryDark() {
		return fontSecondaryDark;
	}
	public void setFontSecondaryDark(Boolean fontSecondaryDark) {
		this.fontSecondaryDark = fontSecondaryDark;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

}
