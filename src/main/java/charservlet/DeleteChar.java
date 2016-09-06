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
 * Servlet implementation class DeleteFromDB
 */
@WebServlet("/DeleteFromDB")
public class DeleteChar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteChar() {
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
		// TODO Auto-generated method stub
		
//		Player deleteDB = new Player();
		
//		String charID = request.getParameter("char_id");
		
		
//		deleteDB.setCharID(charID);
		
//		com.weekfivetwo.Dew.deleteFromDB(deleteDB);
		
//		request.getRequestDispatcher("delete.html").forward(request,response);
		
Player delete = new Player();
        
        delete.setCharID(Integer.parseInt(request.getParameter("delete")));
        
        Dew.deleteFromDB(delete);
        
        request.getRequestDispatcher("index.html").forward(request, response);
		
	}
	
	
}