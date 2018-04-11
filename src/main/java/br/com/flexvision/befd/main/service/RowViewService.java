package br.com.flexvision.befd.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.RowViewDAO;
import br.com.flexvision.befd.main.model.RowView;

@Service
public class RowViewService {

	@Autowired
	private RowViewDAO dao;
	
	public RowView save(RowView rowView) {
		System.out.println(rowView);
		return dao.save(rowView);
	}
	
	public Iterable<RowView> listAll() {
		return dao.findAll();
	}
	
	public Optional<RowView> findById(Integer id) {
		return dao.findById(id);
	}
}
