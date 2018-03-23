package br.com.flexvision.befd.flex4.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.flexvision.befd.flex4.dao.MetricDAO;
import br.com.flexvision.befd.flex4.dto.InfluxData;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.Serie;
import br.com.flexvision.befd.flex4.dto.WrapperInfluxToSerie;

@Service
public class MetricService {

	@Autowired
	private MetricDAO dao;
	
	public List<Metric> listAllMetrics(){
		return dao.listAllMetrics();
	}
	
	//db=flex_metric&q=select mean(value) from data_metric where node_id in ('"+id_node+"') and met_id = xxx and time >= now()-2h group by time(5m)"
	//select mean(value) as value from data_metric where node_id =~ /16635|16636|16720/ and met_id = '1' and time >= now()-2h group by time(5m)
	public List<Serie> getListData(Metric m){
		StringBuffer idsNode = new StringBuffer("");
		StringBuffer query = new StringBuffer("");
		StringBuffer url = new StringBuffer("");
		
		List<Integer> listNodes = dao.listNodes(m.getMet_id(), m.getNdt_id());
		listNodes.stream().forEach((item) -> {
			idsNode.append("|");idsNode.append(item.intValue());
		});

		query.append("db=flex4&q=");
		query.append("select mean(value) as value from data_metric where node_id =~ /");
		query.append(idsNode.substring(1));
		query.append("/ and met_id = '");
		query.append(m.getMet_id());
		query.append("' and time >= now()-2h group by time(5m)");
		
		url.append("http://172.16.12.236:8086/query?pretty=true");
		
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<String> entity = new HttpEntity<>(query.toString(), headers);
		
		System.out.println(url);
		System.out.println(entity);
		
		InfluxData ret = restTemplate.postForObject(url.toString(), entity, InfluxData.class);
		
		return (new WrapperInfluxToSerie(ret)).toListSeries();
	}

}
