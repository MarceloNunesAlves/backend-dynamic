package br.com.flexvision.befd.controller;

import java.util.Optional;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.flexvision.befd.main.model.Dashboard;
import br.com.flexvision.befd.main.model.RowView;
import br.com.flexvision.befd.main.service.RowViewService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/rowView")
public class RowViewController extends MainController{

	@Autowired
	private RowViewService service;
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Optional<RowView> findById(Integer id) {
		return service.findById(id);
	}
	
	@RequestMapping(value="/listByDashboard", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<RowView> getListByDashboard(@RequestBody Dashboard dashboard) {
		return service.listByDashboard(dashboard);
	}

	@RequestMapping(value="/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody RowView save(@RequestBody RowView rowView) {
		return service.save(rowView);
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public void delete(@RequestBody RowView rowView) {
		service.delete(rowView);
	}

}
