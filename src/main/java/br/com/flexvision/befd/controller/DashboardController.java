package br.com.flexvision.befd.controller;

import java.util.Optional;

import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.flexvision.befd.main.model.Dashboard;
import br.com.flexvision.befd.main.service.DashboardService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/dashboard")
public class DashboardController extends MainController{

	@Autowired
	private DashboardService service; 
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Optional<Dashboard> findById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<Dashboard> getListAll() {
		return service.listAll();
	}

	@RequestMapping(value="/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Dashboard save(@RequestBody Dashboard dashboard) {
		return service.save(dashboard);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Boolean delete(@PathVariable("id") Integer id) {
		service.deleteById(id);
		return true;
	}

}
