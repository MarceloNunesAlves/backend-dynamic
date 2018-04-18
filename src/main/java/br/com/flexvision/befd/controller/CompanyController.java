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
import br.com.flexvision.befd.main.model.Company;
import br.com.flexvision.befd.main.service.CompanyService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/company")
public class CompanyController extends MainController{

	@Autowired
	private CompanyService service; 
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Optional<Company> findById(Integer id) {
		return service.findById(id);
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Iterable<Company> getListAll() {
		return service.listAll();
	}

	@RequestMapping(value="/", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody Company save(@RequestBody Company company) {
		return service.save(company);
	}

}
