import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            String director = request.getParameter("director");
            int year = Integer.parseInt(request.getParameter("year"));
            int rating = Integer.parseInt(request.getParameter("rating"));
            Film film = new Film(title, genre, director, year, rating);
            FilmsDatabase.insert(film);
            PushUpdates.sendAll("updateTable");
            response.sendRedirect(request.getContextPath() + "/index");
        } catch(Exception ex) {
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
