package br.com.flexvision.befd.flex4.dto;

import java.util.List;

public class DetailSerie {

	private List<Serie> listValues;
	private Metric detailSerie;
	
	public DetailSerie(Metric detailSerie, List<Serie> listValues) {
		super();
		this.listValues = listValues;
		this.detailSerie = detailSerie;
	}
	
	public List<Serie> getListValues() {
		return listValues;
	}
	public void setListValues(List<Serie> listValues) {
		this.listValues = listValues;
	}
	public Metric getDetailSerie() {
		return detailSerie;
	}
	public void setDetailSerie(Metric detailSerie) {
		this.detailSerie = detailSerie;
	}
	
}
