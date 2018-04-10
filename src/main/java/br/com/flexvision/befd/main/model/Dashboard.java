package br.com.flexvision.befd.main.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dashboard {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "titleDash")
	private String titleDash;

	@OneToMany
	private List<RowView> rowsView;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<RowView> getRowsView() {
		return rowsView;
	}

	public void setRowsView(List<RowView> rowsView) {
		this.rowsView = rowsView;
	}

}