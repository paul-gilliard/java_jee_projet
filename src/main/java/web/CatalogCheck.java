package web;

import java.io.IOException;
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
 * Servlet implementation class Catalog
 */
@WebServlet("/Catalog")
public class CatalogCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private generatorCatalogXml catalogxml;
	private GenerateUserXml userxml;
	private Catalog catalog;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogCheck() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
   	public void init() throws ServletException {
    	catalogxml = new generatorCatalogXml();
   		userxml = new GenerateUserXml();
   		catalog = Catalog.getInstance();
   		super.init();
   		
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pseudo = request.getParameter("pseudo");
		Users user = new Users(pseudo);
		user.setId(Integer.parseInt(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(0).toString()));
		user.setName(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(1).toString());
		user.setSurname(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(2).toString());
		user.setPseudo(request.getParameter("pseudo"));
		user.setPassword(userxml.getOneUserFromByPseudo(pseudo).get(pseudo).get(3).toString());
		System.out.println(user.toString());
		System.out.println(catalogxml.getAllBottleFromCatalog().get("b"+user.getId()));
		
		//request.setAttribute("catalog", catalog);
		request.setAttribute("user", user);
		getServletConfig().getServletContext().getRequestDispatcher("/catalog.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
