package br.com.flexvision.befd.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Dashboard implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4524577518278613281L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "titleDash")
	private String titleDash;

	@Transient
	private List<RowView> rowsView = new ArrayList<RowView>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getTitleDash() {
		return titleDash;
	}

	public void setTitleDash(String titleDash) {
		this.titleDash = titleDash;
	}

	public List<RowView> getRowsView() {
		return rowsView;
	}

	public void setRowsView(List<RowView> rowsView) {
		this.rowsView = rowsView;
	}

}
