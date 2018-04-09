package br.com.flexvision.befd.controller;

import java.util.List;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.SubItem;
import br.com.flexvision.befd.flex4.service.GroupService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("group")
public class GroupController extends MainController{

	@Autowired
	private GroupService service; 
	
	@RequestMapping(value="/listGroups", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody List<SubItem> getListData(@RequestBody Metric metric) {
		return service.getListByFilter(metric);
	}

}
