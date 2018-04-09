package br.com.flexvision.befd.flex4.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.flex4.dao.GroupDAO;
import br.com.flexvision.befd.flex4.dto.Metric;
import br.com.flexvision.befd.flex4.dto.SubItem;

@Service
public class GroupService {

	@Autowired
	private GroupDAO dao;
	
	public List<SubItem> getListByFilter(Metric m){
		return dao.getListByFilter(m.getMet_id(), m.getNdt_id());
	}

}