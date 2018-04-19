package br.com.flexvision.befd.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.DashboardDAO;
import br.com.flexvision.befd.main.model.Dashboard;
import br.com.flexvision.befd.main.model.RowView;

@Service
public class DashboardService {

	@Autowired
	private DashboardDAO dao;
	
	@Autowired
	private RowViewService serviceRows;
	
	public Dashboard save(Dashboard dashboard) {
		return dao.save(dashboard);
	}
	
	public Iterable<Dashboard> listAll() {
		return dao.findAll();
	}
	
	public Optional<Dashboard> findById(Integer id) {
		return dao.findById(id);
	}
	
	public void deleteById(Integer id) {
		//Remove as linhas
		Iterable<RowView> rows = serviceRows.listByDashboard((this.findById(id)).get());
		rows.forEach(row -> {
			serviceRows.delete(row.getId());
		});
		//Exclui o dashboard
		dao.deleteById(id);
	}
}
