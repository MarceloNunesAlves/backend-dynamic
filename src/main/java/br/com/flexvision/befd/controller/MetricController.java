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

import br.com.flexvision.befd.flex4.dto.DetailSerie;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.Serie;
import br.com.flexvision.befd.flex4.service.MetricService;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/metric")
public class MetricController extends MainController{

	@Autowired
	private MetricService service; 
	
	@RequestMapping(value="/listMetricWithType", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody List<Metric> getListMetrics() {
		return service.listAllMetrics();
	}

	@RequestMapping(value="/listSerie", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody List<DetailSerie> getListData(@RequestBody List<Metric> metrics) {
		return service.getListData(metrics);
	}

}
