package charservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.weekfivetwo.Dew;
import com.weekfivetwo.Player;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int charAttack = Integer.parseInt(request.getParameter("attack"));
		int charDefense = Integer.parseInt(request.getParameter("defense"));
		int charHitPoints = Integer.parseInt(request.getParameter("hitpoints"));
		
	
		Player charToUpdate = new Player();

		
		charToUpdate.setCharRace(request.getParameter("race"));
		charToUpdate.setCharProfession(request.getParameter("profession"));
		charToUpdate.setAttack(charAttack);
		charToUpdate.setDefense(charDefense);
		charToUpdate.setHitPoints(charHitPoints);

		Dew.updateDB(charToUpdate);

		request.getRequestDispatcher("index.html").forward(request, response);

	}

}
