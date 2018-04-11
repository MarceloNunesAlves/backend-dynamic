package br.com.flexvision.befd.main.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.flexvision.befd.main.model.RowView;

@Repository
public interface RowViewDAO extends CrudRepository<RowView, Integer>{

}
