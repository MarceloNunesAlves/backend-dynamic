package br.com.flexvision.befd.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.DashboardDAO;
import br.com.flexvision.befd.main.model.Dashboard;

@Service
public class DashboardService {

	@Autowired
	private DashboardDAO dao;
	
	public Dashboard save(Dashboard dashboard) {
		return dao.save(dashboard);
	}
	
	public Iterable<Dashboard> listAll() {
		return dao.findAll();
	}
	
	public Optional<Dashboard> findById(Integer id) {
		return dao.findById(id);
	}
}
