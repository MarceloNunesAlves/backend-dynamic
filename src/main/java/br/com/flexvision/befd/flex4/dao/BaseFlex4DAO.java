package br.com.flexvision.befd.flex4.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseFlex4DAO {

	@Autowired
	protected EntityManager entityManager;

}
