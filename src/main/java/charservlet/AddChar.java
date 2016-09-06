package charservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weekfivetwo.Player;
import com.weekfivetwo.Dew;

/**
 * Servlet implementation class AddChar
 */
@WebServlet("/AddChar")
public class AddChar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddChar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int charAttack = Integer.parseInt(request.getParameter("attack"));
        int charDefense = Integer.parseInt(request.getParameter("defense"));
        int charHitPoints = Integer.parseInt(request.getParameter("hitpoints"));
		
		
		Player addToDB = new Player();
		addToDB.setCharName(request.getParameter("char_name"));
		addToDB.setCharRace(request.getParameter("race"));
		addToDB.setCharProfession(request.getParameter("profession"));
		addToDB.setAttack(charAttack);
		addToDB.setDefense(charDefense);
		addToDB.setHitPoints(charHitPoints);
		
		Dew.writeToDatabase(addToDB);
		
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
