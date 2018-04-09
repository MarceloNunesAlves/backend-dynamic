package br.com.flexvision.befd.flex4.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.flexvision.befd.flex4.dto.Metric;

@Repository
public class MetricDAO extends BaseFlex4DAO{

	@SuppressWarnings("unchecked")
	public List<Metric> listAllMetrics() {
		StringBuilder baseSql = new StringBuilder("");
		
		baseSql.append("select m.met_id,concat(ndt.name,' - ',m.name) name,ndt.ndt_id,ifnull(unit.cod,'Volume') unit_type");
		baseSql.append(" from model_metric_formula mmf");
		baseSql.append(" inner join model_metric mm on mm.mmt_id=mmf.mmt_id");
		baseSql.append(" inner join model model on model.mod_id=mm.mod_id");
		baseSql.append(" inner join metric m on m.met_id=mm.met_id");
		baseSql.append(" inner join model_list mml on mml.mod_id=mm.mod_id");
		baseSql.append(" inner join node n on n.mol_id=mml.mol_id");
		baseSql.append(" inner join unit unit on unit.unt_id=m.unt_id");
		baseSql.append(" inner join nodetype ndt on ndt.ndt_id=model.ndt_id");
		baseSql.append(" group by m.met_id,m.name,ndt.ndt_id,ndt.name,unit.cod");
		
		Query query = entityManager.createNativeQuery(baseSql.toString());
		List<Object[]> results = query.getResultList();
		
		List<Metric> listMetric =  new ArrayList<Metric>();
		results.stream().forEach((record) -> {
	        Metric m = new Metric();
	        int i=0;
	        m.setMet_id((Integer) record[i++]);
	        m.setName((String) record[i++]);
	        m.setTituloSerie(m.getName());
	        m.setNdt_id((Integer) record[i++]);
	        m.setUnit_type((String) record[i++]);
	        listMetric.add(m);
		});
		
		return listMetric;
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> listNodesByFilter(int met_id, int ndt_id,
									List<Integer> withSite, List<Integer> withoutSite,
									List<Integer> withGroup, List<Integer> withoutGroup,
									List<Integer> withNode, List<Integer> withoutNode ){
		StringBuilder baseSql = new StringBuilder("");
		
		baseSql.append("select n.nod_id");
		baseSql.append(" from model_metric_formula mmf");
		baseSql.append(" inner join model_metric mm on mm.mmt_id=mmf.mmt_id");
		baseSql.append(" inner join model model on model.mod_id=mm.mod_id");
		baseSql.append(" inner join metric m on m.met_id=mm.met_id");
		baseSql.append(" inner join model_list mml on mml.mod_id=mm.mod_id");
		baseSql.append(" inner join node n on n.mol_id=mml.mol_id");
		baseSql.append(" inner join nodetype ndt on ndt.ndt_id=model.ndt_id");
		baseSql.append(" inner join node_groups ng on ng.nod_id=n.nod_id");
		baseSql.append(" where ndt.ndt_id=:ndt_id and m.met_id=:met_id");
		if(withSite!=null && withSite.size()>0) {
			baseSql.append(" and n.sit_id in (:sit_with_id)");
		}
		if(withoutSite!=null && withoutSite.size()>0) {
			baseSql.append(" and n.sit_id not in (:sit_without_id)");
		}
		if(withGroup!=null && withGroup.size()>0) {
			baseSql.append(" and ng.grp_id in (:grp_with_id)");
		}
		if(withoutGroup!=null && withoutGroup.size()>0) {
			baseSql.append(" and ng.grp_id not in (:grp_without_id)");
		}
		if(withNode!=null && withNode.size()>0) {
			baseSql.append(" and n.nod_id in (:nod_with_id)");
		}
		if(withoutNode!=null && withoutNode.size()>0) {
			baseSql.append(" and n.nod_id not in (:nod_without_id)");
		}
		baseSql.append(" group by n.nod_id");
		System.out.println(baseSql);
		
		Query query = entityManager.createNativeQuery(baseSql.toString());
		query.setParameter("ndt_id", ndt_id);
		query.setParameter("met_id", met_id);

		if(withSite!=null && withSite.size()>0) {
			query.setParameter("sit_with_id", withSite);
		}
		if(withoutSite!=null && withoutSite.size()>0) {
			query.setParameter("sit_without_id", withoutSite);
		}
		if(withGroup!=null && withGroup.size()>0) {
			query.setParameter("grp_with_id", withGroup);
		}
		if(withoutGroup!=null && withoutGroup.size()>0) {
			query.setParameter("grp_without_id", withoutGroup);
		}
		if(withNode!=null && withNode.size()>0) {
			query.setParameter("nod_with_id", withNode);
		}
		if(withoutNode!=null && withoutNode.size()>0) {
			query.setParameter("nod_without_id", withoutNode);
		}
		List<Integer> listNodes = query.getResultList();

		return listNodes;
		
	}
	
}