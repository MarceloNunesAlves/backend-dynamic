package br.com.flexvision.befd.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.flexvision.befd.main.model.Dashboard;

@Repository
public interface DashboardDAO extends CrudRepository<Dashboard, Integer>{

}
