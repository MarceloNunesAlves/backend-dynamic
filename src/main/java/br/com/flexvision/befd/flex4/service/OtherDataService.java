package br.com.flexvision.befd.flex4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flexvision.befd.flex4.dao.OtherDataDAO;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.Serie;

@Service
public class OtherDataService {

	@Autowired
	private OtherDataDAO dao;
	
	public List<Serie> listSerieOther(Metric m){
		return dao.listSerieOther(m);
	}
}
