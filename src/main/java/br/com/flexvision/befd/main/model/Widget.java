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
import javax.persistence.OrderBy;

@Entity
public class Widget implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6444280083288680326L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column
	private String height;

	@Column
	private String classCol;
	
	@Column
	private Integer columnLayout;

	@Column
	private String caption;

	@OneToMany(cascade = {CascadeType.ALL}, orphanRemoval=true)
	@JoinColumn(name = "widget_id")
	@OrderBy("position ASC")
	private List<ItemFilter> optionGraph;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getClassCol() {
		return classCol;
	}
	
	public Integer getColumnLayout() {
		return columnLayout;
	}

	public void setColumnLayout(Integer columnLayout) {
		this.columnLayout = columnLayout;
	}

	public void setClassCol(String classCol) {
		this.classCol = classCol;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public List<ItemFilter> getOptionGraph() {
		return optionGraph;
	}

	public void setOptionGraph(List<ItemFilter> optionGraph) {
		this.optionGraph = optionGraph;
	}
	
}