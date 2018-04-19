package br.com.flexvision.befd.main.service;

import org.apache.commons.codec.binary.Base64;
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
		String imgUrl = company.getLogoStr();
		if(imgUrl!=null){
			imgUrl = imgUrl.replaceAll("^data\\:.*base64,", "");
			company.setLogo(Base64.decodeBase64(imgUrl));	
		}
		return dao.save(company);
	}
	
	public Iterable<Company> listAll() {
		return dao.findAll();
	}
	
	public Optional<Company> findById(Integer id) {
		return dao.findById(id);
	}
}
