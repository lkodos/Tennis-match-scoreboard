package ru.lkodos.servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.dao.PlayerRepository;
import ru.lkodos.entity.Player;
import ru.lkodos.config.JpaUtil;

import java.io.IOException;

@WebServlet("/new-match")
public class NewPlayerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1 = req.getParameter("player1");
        String player2 = req.getParameter("player2");

        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        try (EntityManager em = emf.createEntityManager()) {

                em.getTransaction().begin();

                PlayerRepository playerRepository = new PlayerRepository(em);

                Player p1 = Player.builder()
                        .name(player1)
                        .build();
                Player p2 = Player.builder()
                        .name(player2)
                        .build();

                playerRepository.save(p1);
                playerRepository.save(p2);

                em.getTransaction().commit();
        }
    }
}