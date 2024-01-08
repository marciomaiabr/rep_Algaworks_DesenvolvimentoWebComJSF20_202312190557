package com.algaworks.cursojsf2.financeiro.util;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(servletNames = { "Faces Servlet" })
public class JPAFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("JPAFilter.doFilter()");
		EntityManager entityManager = JPAUtil.getEntityManager();
		EntityTransaction etx = null;

		try {
			etx = entityManager.getTransaction();
			etx.begin();

			request.setAttribute("entityManager", entityManager);

			chain.doFilter(request, response);

			etx.commit();
		} catch (Exception e) {
			if (etx != null) {
				etx.rollback();
			}
		} finally {
			entityManager.close();
		}
	}

	@Override
	public void destroy() {
		System.out.println("JPAFilter.destroy()");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("JPAFilter.init()");
	}

}
