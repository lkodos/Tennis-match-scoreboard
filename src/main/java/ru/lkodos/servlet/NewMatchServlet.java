package ru.lkodos.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.lkodos.service.CreateNewMatchService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/new-match"}, name = "NewMatchServlet")
public class NewMatchServlet extends HttpServlet {

    private static final CreateNewMatchService service = new CreateNewMatchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/new-match.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String player1Name = req.getParameter("player1");
        String player2Name = req.getParameter("player2");

        Map<String, String> errors = getErrorsMap(player1Name, player2Name);

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("player1", player1Name);
            req.setAttribute("player2", player2Name);
            req.getRequestDispatcher("new-match.jsp").forward(req, resp);
            return;
        }

        service.createNewMatch(player1Name, player2Name);
    }

    private static Map<String, String> getErrorsMap(String player1Name, String player2Name) {
        Map<String, String> errors = new HashMap<>();
        boolean p1Valid = player1Name != null && !player1Name.isBlank();
        boolean p2Valid = player2Name != null && !player2Name.isBlank();

        if (!p1Valid) {
            errors.put("player1", "Введите имя первого игрока");
        }
        if (!p2Valid) {
            errors.put("player2", "Введите имя второго игрока");
        }
        if (p1Valid && p2Valid && player1Name.equals(player2Name)) {
            errors.put("equalsNames", "Имена игроков не должны совпадать");
        }
        if (!service.playerExists(player1Name)) {
            errors.put("player1Exist", "Такой игрок уже существует");
        }
        if (!service.playerExists(player2Name)) {
            errors.put("player2Exist", "Такой игрок уже существует");
        }
        return errors;
    }
}
