package br.com.flexvision.befd.flex4.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;
import br.com.flexvision.befd.flex4.dto.Metric;

@Repository
public class MetricDAO extends BaseFlex4DAO{

	public List<Metric> listAllMetrics() {
		StringBuilder baseSql = new StringBuilder("");
		
		baseSql.append("select m.met_id,concat(ndt.name,' - ',m.name) name,ndt.ndt_id,unit.cod unit_type");
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
	        m.setNdt_id((Integer) record[i++]);
	        m.setUnit_type((String) record[i++]);
	        listMetric.add(m);
		});
		
		return listMetric;
	}
	
	public List<Integer> listNodes(int met_id, int ndt_id){
		StringBuilder baseSql = new StringBuilder("");
		
		baseSql.append("select n.nod_id");
		baseSql.append(" from model_metric_formula mmf");
		baseSql.append(" inner join model_metric mm on mm.mmt_id=mmf.mmt_id");
		baseSql.append(" inner join model model on model.mod_id=mm.mod_id");
		baseSql.append(" inner join metric m on m.met_id=mm.met_id");
		baseSql.append(" inner join model_list mml on mml.mod_id=mm.mod_id");
		baseSql.append(" inner join node n on n.mol_id=mml.mol_id");
		baseSql.append(" inner join nodetype ndt on ndt.ndt_id=model.ndt_id");
		baseSql.append(" where ndt.ndt_id=:ndt_id and m.met_id=:met_id");
		baseSql.append(" group by n.nod_id");
		
		Query query = entityManager.createNativeQuery(baseSql.toString());
		query.setParameter("ndt_id", ndt_id);
		query.setParameter("met_id", met_id);
		List<Integer> listNodes = query.getResultList();

		return listNodes;
		
	}
	
}
