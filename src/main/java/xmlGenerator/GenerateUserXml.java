package xmlGenerator;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import metier.Users;

public class GenerateUserXml {
	
	 public void generateFile(Users user) throws  IOException{
         
		 System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		
		 String path = System.getProperty("user.dir");
		 path = path+"/git/projet_jee_pal/src/main/webapp/XML/user.xml"; // POtentiellement à adapter pour taffer Lisa, comportement chelou
		 File f = new File(path);
		 if(f.exists() && !f.isDirectory()) {
			 
			 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 
			 try 
			 {
			   final DocumentBuilder builder = factory.newDocumentBuilder();
			   final Document document= builder.parse(path);
			   final Element racine = document.getDocumentElement();
			   System.out.println(racine.getNodeName());
			   final NodeList racineNoeuds = racine.getChildNodes();
			   
			   
			   Element pseudo = document.createElement(user.getPseudo());
			   final Node usernode = racine.appendChild(pseudo);
			   
			   int id_user = racineNoeuds.getLength();
			   String id_user_string = String.valueOf(id_user);
			   Element userId = document.createElement("id_user");
		        userId.setTextContent(id_user_string);;
		        pseudo.appendChild(userId);
		        
			   Element name = document.createElement("name");
		        name.setTextContent(user.getName());
		        pseudo.appendChild(name);
		  
			   Element surname = document.createElement("surname");
		        surname.setTextContent(user.getSurname());
		        pseudo.appendChild(surname);
		  
			   Element password = document.createElement("password");
		        password.setTextContent(user.getPassword());
		        pseudo.appendChild(password);
		        

			    
			   
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(document);
		        StreamResult result = new StreamResult(path);
		  
		        transformer.transform(source, result);
	            
			  

			 }
			 catch (final ParserConfigurationException e) 
			 {
			   e.printStackTrace();
			 } catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 
		 } else {
			 
			 try {
				  
			        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			  
			        Document doc = docBuilder.newDocument();
			        Element rootElement = doc.createElement("user");
			        doc.appendChild(rootElement);
			  
			        Element pseudo = doc.createElement(user.getPseudo());
			        rootElement.appendChild(pseudo);
			        
			  
				    Element userId = doc.createElement("id_user");
				    userId.setTextContent("1");
				    pseudo.appendChild(userId);
				  
			        Element name = doc.createElement("name");
			        name.setTextContent(user.getName());
			        pseudo.appendChild(name);
			  
			        Element surname = doc.createElement("surname");
			        surname.setTextContent(user.getSurname());
			        pseudo.appendChild(surname);
			  
			        Element password = doc.createElement("password");
			        password.setTextContent(user.getPassword());
			        pseudo.appendChild(password);
			  
			        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			        Transformer transformer = transformerFactory.newTransformer();
			        DOMSource source = new DOMSource(doc);
			        StreamResult result = new StreamResult(new File(path));
			  
			        transformer.transform(source, result);
			  
			        System.out.println("File saved!");
			  
			      }
			      catch (ParserConfigurationException pce) {
			        pce.printStackTrace();
			      }
			      catch (TransformerException tfe) {
			        tfe.printStackTrace();
			      }
			 
		 }
		  
	      
	   // return "Compte cr�e avec succ�s !";
	    }

	 public boolean isMatchedPseudoPassword(String pseudo,String inputPassword) { // test si un password est relier à un pseudo, renvoie true si oui, false sinon
		 boolean match = false;
		 System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
			
		 String path = System.getProperty("user.dir");
		 path = path+"/src/main/webapp/XML/user.xml"; // POtentiellement à adapter pour taffer Lisa, comportement chelou
			 
			 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 Node nodeToExplore = null;
			 try 
			 {
				 
			   final DocumentBuilder builder = factory.newDocumentBuilder();
			   final Document document= builder.parse(path);
			   final Node pseudoNode = document.getElementById(pseudo);
			   
			   final Element racine = document.getDocumentElement();
			   //System.out.println(racine.getNodeName());
			   final NodeList racineNoeuds = racine.getChildNodes();
			   
			   
			   final int nbRacineNoeuds = racineNoeuds.getLength();
			   //System.out.println(nbRacineNoeuds);
			   
			   for (int i = 0; i<nbRacineNoeuds; i++) 
			   {
			     //System.out.println(racineNoeuds.item(i).getNodeName());
			     if (racineNoeuds.item(i).getNodeName() == pseudo) {
			    	 
			    	 final Element user = (Element) racineNoeuds.item(i);
			    	    //System.out.println(user.getNodeName());
			    	    Node userNode =  (Node) user.getChildNodes();
			    	    //System.out.println("password : " + userNode.getLastChild());
			    	    Node password = userNode.getLastChild();
			    	    //System.out.println(password.getTextContent() + "____" + inputPassword);
			    	    if (password.getTextContent().equalsIgnoreCase(inputPassword)) {
			    	    	match = true;
			    	    }
			     }
			   }

			//System.out.println("here" + nodeToExplore);
			   
			 } catch (Exception e) {
				System.out.println(e.getMessage());
			}
			 
			 return match;
	 }
}
	 

