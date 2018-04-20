package br.com.flexvision.befd.flex4.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import br.com.flexvision.befd.flex4.dao.MetricDAO;
import br.com.flexvision.befd.flex4.dto.DetailSerie;
import br.com.flexvision.befd.flex4.dto.InfluxData;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.Serie;
import br.com.flexvision.befd.flex4.dto.WrapperInfluxToSerie;

@Service
public class MetricService {

	@Autowired
	private MetricDAO dao;
	
	@Autowired
	private OtherDataService serviceOther;
	
	public List<Metric> listAllMetrics(){
		return dao.listAllMetrics();
	}
	
	public List<DetailSerie> getListData(List<Metric> metrics){
		List<DetailSerie> listReturn = new ArrayList<DetailSerie>();
		metrics.forEach((m) -> {
			System.out.println(m.getOri());
			switch (m.getOri()) {
			case FLEX:
				listReturn.add(dataFlex4(m));	
				break;
			case OTHER:
				listReturn.add(dataOther(m));
				break;
			default:
				break;
			}
		});
		return listReturn;
	}

	private DetailSerie dataFlex4(Metric m) {
		StringBuffer idsNode = new StringBuffer("");
		StringBuffer query = new StringBuffer("");
		StringBuffer url = new StringBuffer("");
		List<Integer> withSite = new ArrayList<Integer>();List<Integer> withoutSite = new ArrayList<Integer>();
		List<Integer> withGroup = new ArrayList<Integer>();List<Integer> withoutGroup = new ArrayList<Integer>();
		List<Integer> withNode = new ArrayList<Integer>();List<Integer> withoutNode = new ArrayList<Integer>();
		
		if(m.getOptions()!=null) {
			m.getOptions().stream().forEach((item) -> {
				switch (item.getOrigin()) {
					case SITE:
						if(item.isCom())
							withSite.add(item.getIdOri());
						else
							withoutSite.add(item.getIdOri());
						break;
					case GROUP:
						if(item.isCom())
							withGroup.add(item.getIdOri());
						else
							withoutGroup.add(item.getIdOri());
						break;
					case NODE:
						if(item.isCom())
							withNode.add(item.getIdOri());
						else
							withoutNode.add(item.getIdOri());
						break;
					default:
						break;
				}
			});
		}
		
		List<Integer> listNodes = dao.listNodesByFilter(m.getMet_id(), m.getNdt_id(), withSite, withoutSite, withGroup, withoutGroup, withNode, withoutNode);
		
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
		return new DetailSerie(m,(new WrapperInfluxToSerie(ret)).toListSeries());
	}

	private DetailSerie dataOther(Metric m) {
		List<Serie> list = serviceOther.listSerieOther();
		return new DetailSerie(m, list);
	}

}
