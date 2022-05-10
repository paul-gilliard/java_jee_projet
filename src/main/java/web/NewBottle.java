package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Bottle;
import metier.Catalog;

/**
 * Servlet implementation class NewBottle
 */
@WebServlet("/NewBottle")
public class NewBottle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Catalog catalog;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewBottle() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		catalog = Catalog.getInstance(); 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bottle bottle = new Bottle();
		bottle.setBottle_name(request.getParameter("bottle_name"));
		bottle.setCastle(request.getParameter("castle"));
		bottle.setMill(Integer.parseInt(request.getParameter("mill")));
		bottle.setRegion(request.getParameter("region"));
		bottle.setColor(request.getParameter("color"));
		bottle.setAlcool(Integer.parseInt(request.getParameter("alcool")));
		bottle.setGarde(Integer.parseInt(request.getParameter("garde")));
		bottle.setRating(Integer.parseInt(request.getParameter("rating")));
		
		PrintWriter out = response.getWriter();
		out.println(bottle.toString());
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
