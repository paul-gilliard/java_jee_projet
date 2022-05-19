package xmlGenerator;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import metier.Users;

public class GenerateUserXml {
	
	 public void generateFile(Users user){
         
		 
		  
	      try {
	  
	        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	  
	        Document doc = docBuilder.newDocument();
	        Element rootElement = doc.createElement("user");
	        doc.appendChild(rootElement);
	  
	        Element pseudo = doc.createElement("pseudo");
	        pseudo.setTextContent(user.getPseudo());
	        rootElement.appendChild(pseudo);
	  
	        Element name = doc.createElement("name");
	        name.setTextContent(user.getName());
	        rootElement.appendChild(name);
	  
	        Element surname = doc.createElement("surname");
	        surname.setTextContent(user.getSurname());
	        rootElement.appendChild(surname);
	  
	        Element password = doc.createElement("password");
	        password.setTextContent(user.getPassword());
	        rootElement.appendChild(password);
	  
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        Transformer transformer = transformerFactory.newTransformer();
	        DOMSource source = new DOMSource(doc);
	        StreamResult result = new StreamResult(new File("D:\\MIAGE\\M1 MIAGE\\S8\\Web\\projet\\"+ user.getPseudo()+".xml"));
	  
	        transformer.transform(source, result);
	  
	        System.out.println("File saved!");
	  
	      }
	      catch (ParserConfigurationException pce) {
	        pce.printStackTrace();
	      }
	      catch (TransformerException tfe) {
	        tfe.printStackTrace();
	      }
	   // return "Compte crée avec succès !";
	    }

}
