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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class RowView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2113507563015103559L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "dashboard_id")
	private Dashboard dashboard;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Widget> Widgets;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Dashboard getDashboard() {
		return dashboard;
	}

	public void setDashboard(Dashboard dashboard) {
		this.dashboard = dashboard;
	}

	public List<Widget> getWidgets() {
		return Widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		Widgets = widgets;
	}

}
