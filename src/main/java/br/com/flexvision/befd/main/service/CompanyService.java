package br.com.flexvision.befd.main.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.flexvision.befd.main.dao.CompanyDAO;
import br.com.flexvision.befd.main.model.Company;

@Service
public class CompanyService {

	@Autowired
	private CompanyDAO dao;
	
	public Company save(Company company) {
		return dao.save(company);
	}
	
	public Iterable<Company> listAll() {
		return dao.findAll();
	}
	
	public Optional<Company> findById(Integer id) {
		return dao.findById(id);
	}
}
