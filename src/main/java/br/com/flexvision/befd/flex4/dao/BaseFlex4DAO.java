package br.com.flexvision.befd.flex4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class BaseFlex4DAO {

	@Qualifier("flex4EntityManagerFactory")
	@Autowired
	protected EntityManager entityManager;

}
