package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import metier.Catalog;
import metier.Users;
import xmlGenerator.GenerateCaveXml;
import xmlGenerator.GenerateUserXml;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void init() throws ServletException {
   		// TODO Auto-generated method stub
   		super.init();
   		
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Users user = new Users();
		System.out.println(user.getId());
		
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setPseudo(request.getParameter("pseudo"));
		user.setPassword(request.getParameter("password"));
		//out.println(user.toString());
		
	    GenerateUserXml gen = new GenerateUserXml();
	    GenerateCaveXml genCave = new GenerateCaveXml();
	
	    genCave.generateFile(user.getId());
	    gen.generateFile(user);
	   // request.setAttribute("user", user);
	    //request.setAttribute("cave", user.getCave());
		//getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		 
	    
	    	 
	     

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
