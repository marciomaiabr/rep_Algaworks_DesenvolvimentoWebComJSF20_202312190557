package com.algaworks.cursojsf2.financeiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;

	static {
		System.out.println("JPAUtil.enclosing_method()");
		try {
			ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("myPU");
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
		System.out.println("/JPAUtil.enclosing_method()");
	}

	public static EntityManager getEntityManager() {
		System.out.println("JPAUtil.getEntityManager()");
		return ENTITY_MANAGER_FACTORY.createEntityManager();
	}

	/*
	public static EntityManager getEntityManager() {
		System.out.println("JPAUtil.getEntityManager()");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
		return entityManagerFactory.createEntityManager();
	}

*/

}