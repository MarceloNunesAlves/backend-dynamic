package br.com.flexvision.befd.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.RowViewDAO;
import br.com.flexvision.befd.main.model.Dashboard;
import br.com.flexvision.befd.main.model.RowView;

@Service
public class RowViewService {

	@Autowired
	private RowViewDAO dao;
	
	public RowView save(RowView rowView) {
		return dao.save(rowView);
	}
	
	public Iterable<RowView> listByDashboard(Dashboard dashboard) {
		return dao.findByDashboard(dashboard);
	}
	
	public Optional<RowView> findById(Integer id) {
		return dao.findById(id);
	}

	public void delete(RowView rowView) {
		dao.delete(rowView);
	}

}
