import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<Film> films = FilmsDatabase.select();
            request.setAttribute("films", films);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
