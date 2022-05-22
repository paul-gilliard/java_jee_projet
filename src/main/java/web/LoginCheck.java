package web;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Catalog;
import metier.Users;
import xmlGenerator.GenerateUserXml;
import xmlGenerator.generatorCatalogXml;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GenerateUserXml userxml;
	private generatorCatalogXml catalogxml;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
   	public void init() throws ServletException {
    	//catalog = new generatorCatalogXml();
   		userxml = new GenerateUserXml();
   		catalogxml = new generatorCatalogXml();
   		super.init();
   		
   	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String pseudo = request.getParameter("pseudo");
		String password=request.getParameter("password");
		if(!GenerateUserXml.isMatchedPseudoPassword(pseudo,password)) {
			out.println("Try again");
		}
		Users user = new Users(pseudo);
		user.setId(Integer.parseInt(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(0).toString()));
		user.setName(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(1).toString());
		user.setSurname(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(2).toString());
		user.setPseudo(request.getParameter("pseudo"));
		user.setPassword(request.getParameter("password"));
		
		System.out.println(user.toString());
		//request.setAttribute("catalog", catalog);
		ServletContext application = request.getSession().getServletContext();
		System.out.println(catalogxml.getAllBottleFromCatalog().get("b1"));
		System.out.println(catalogxml.getAllBottleFromCatalog().get("b1").get(0));
		System.out.println(catalogxml.getAllBottleFromCatalog().get("b1").get(1));
		int i =1;
		System.out.println(catalogxml.getAllBottleFromCatalog().get("b"+i));
		
		//request.setAttribute("catalog", catalogxml);
		application.setAttribute("user", user)	;
		application.setAttribute("catalog", catalogxml.getAllBottleFromCatalog())	;
		request.setAttribute("user", user);
		getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	
	}

}
