package ru.lkodos.filter;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import ru.lkodos.config.EntityManagerHolder;
import ru.lkodos.config.JpaUtil;

import java.io.IOException;

@WebFilter("/*")
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            EntityManagerHolder.set(em);
            tr.begin();
            filterChain.doFilter(servletRequest, servletResponse);
            tr.commit();
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            throw e;
        } finally {
            em.close();
            EntityManagerHolder.clear();
        }
    }
}
