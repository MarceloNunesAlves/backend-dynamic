package br.com.flexvision.befd.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.WidgetDAO;
import br.com.flexvision.befd.main.model.Widget;

@Service
public class WidgetService {

	@Autowired
	private WidgetDAO dao;
	
	public Widget save(Widget widget) {
		return dao.save(widget);
	}
	
	public Iterable<Widget> listAll() {
		return dao.findAll();
	}
	
	public Optional<Widget> findById(Integer id) {
		return dao.findById(id);
	}
	
	public void deleteById(Integer id) {
		dao.deleteById(id);
	}
}
