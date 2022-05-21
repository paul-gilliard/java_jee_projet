package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.*;
import xmlGenerator.generatorCatalogXml;


/**
 * Servlet implementation class NewBottle
 */
@WebServlet("/NewBottle")
public class NewBottle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Catalog catalog;
	private Cave cave;
       
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
		
		System.out.println("ici");

		PrintWriter out = response.getWriter();
		Bottle bottle = new Bottle("a", "a", 0, "a", "a", 0, 0, 0);
		bottle.setBottle_name(request.getParameter("bottle_name"));
		bottle.setCastle(request.getParameter("castle"));
		bottle.setMill(Integer.parseInt(request.getParameter("mill")));
		bottle.setRegion(request.getParameter("region"));
		bottle.setColor(request.getParameter("color"));
		bottle.setAlcool(Integer.parseInt(request.getParameter("alcool")));
		bottle.setGarde(Integer.parseInt(request.getParameter("garde")));
		bottle.setRating(Integer.parseInt(request.getParameter("rating")));
		
		/*int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		
		if(bottle.equals(bottle)==true){
			out.println("Cette bouteille existe d�j� ! ");
		}else {
			catalog.addNewBottle(user_id,bottle);
			
		}
		out.println(bottle.toString());*/
		
		getServletConfig().getServletContext().getRequestDispatcher("/WEB-INF/jsp/Affichage.jsp").forward(request,response);

		generatorCatalogXml gen = new generatorCatalogXml();
		gen.generateFile(bottle);
		
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
