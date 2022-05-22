package xmlGenerator;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
import metier.Bottle;

public class generatorCatalogXml {
	
	 public void generateFile(Bottle bottle) throws  IOException{
         
		 System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		
		 String path = System.getProperty("user.dir");
		 path = path+"/XML/catalog.xml"; // Potentiellement à adapter pour taffer Lisa, comportement chelou
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
			   int id_bouteille = racineNoeuds.getLength();
			   
			   String bottle_id_string = String.valueOf(id_bouteille);
			   
		        Element bottleId = document.createElement("b"+bottle_id_string);
		        racine.appendChild(bottleId);
			   System.out.println(bottleId);
			   
			   Element bottle_name = document.createElement("bottle_name");
			   bottle_name.setTextContent(bottle.getBottle_name());;
		        bottleId.appendChild(bottle_name);
		        
			   Element castle = document.createElement("castle");
			   castle.setTextContent(bottle.getCastle());
		        bottleId.appendChild(castle);
		  
			   Element mill = document.createElement("mill");
			   String bottle_mill_string = String.valueOf(bottle.getMill());
			   mill.setTextContent(bottle_mill_string);
		       bottleId.appendChild(mill);
		  
		       Element region = document.createElement("region");
		       region.setTextContent(bottle.getRegion());
		       bottleId.appendChild(region);

		        Element color = document.createElement("color");
		        color.setTextContent(bottle.getColor());
			    bottleId.appendChild(color);
			        
			    Element alcool = document.createElement("alcool");
			    String bottle_alcool_string = String.valueOf(bottle.getAlcool());
				alcool.setTextContent(bottle_alcool_string);
				bottleId.appendChild(alcool);

				Element garde = document.createElement("garde");
				String bottle_garde_string = String.valueOf(bottle.getGarde());
				garde.setTextContent(bottle_garde_string);
				bottleId.appendChild(garde);

				Element rating = document.createElement("rating");
				String bottle_rating_string = String.valueOf(bottle.getRating());
				rating.setTextContent(bottle_rating_string);
				bottleId.appendChild(rating);
			   
			   TransformerFactory transformerFactory = TransformerFactory.newInstance();
		        Transformer transformer = transformerFactory.newTransformer();
		        DOMSource source = new DOMSource(document);
		        StreamResult result = new StreamResult(path);
		  
		        transformer.transform(source, result);
	            
		        System.out.println("File modified!");
			  

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
			  
			        Document document = docBuilder.newDocument();
			        Element rootElement = document.createElement("bottles");
			        document.appendChild(rootElement);
			        System.out.println(bottle.getId());
			        String bottle_id_string = String.valueOf(bottle.getId());
			        bottle_id_string = bottle_id_string.replaceAll("\\s+", "");
			        Element bottleId = document.createElement("b"+ "1");
			        rootElement.appendChild(bottleId);
			        
			  
			        Element bottle_name = document.createElement("bottle_name");
					   bottle_name.setTextContent(bottle.getBottle_name());;
				        bottleId.appendChild(bottle_name);
				        
					   Element castle = document.createElement("castle");
					   castle.setTextContent(bottle.getCastle());
				        bottleId.appendChild(castle);
				  
					   Element mill = document.createElement("mill");
					   String bottle_mill_string = String.valueOf(bottle.getMill());
					   mill.setTextContent(bottle_mill_string);
				       bottleId.appendChild(mill);
				  
				       Element region = document.createElement("region");
				       region.setTextContent(bottle.getRegion());
				       bottleId.appendChild(region);

				        Element color = document.createElement("color");
				        color.setTextContent(bottle.getColor());
					    bottleId.appendChild(color);
					        
					    Element alcool = document.createElement("alcool");
					    String bottle_alcool_string = String.valueOf(bottle.getAlcool());
						alcool.setTextContent(bottle_alcool_string);
						bottleId.appendChild(alcool);

						Element garde = document.createElement("garde");
						String bottle_garde_string = String.valueOf(bottle.getGarde());
						garde.setTextContent(bottle_garde_string);
						bottleId.appendChild(garde);

						Element rating = document.createElement("rating");
						String bottle_rating_string = String.valueOf(bottle.getRating());
						rating.setTextContent(bottle_rating_string);
						bottleId.appendChild(rating);
			  
			        TransformerFactory transformerFactory = TransformerFactory.newInstance();
			        Transformer transformer = transformerFactory.newTransformer();
			        DOMSource source = new DOMSource(document);
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

	 public HashMap<String, List> getAllBottleFromCatalog() { // Renvoie une hashmap <b+id_bouteille,list<attributs_bouteille>> de toutes les bouteilles du catalogue
		 boolean match = false;
		 //System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
			
		 String path = System.getProperty("user.dir");
		 path = path+"/XML/catalog.xml";  // POtentiellement à adapter pour taffer Lisa, comportement chelou
			 
			 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 Node nodeToExplore = null;
			 HashMap<String, List> allBottle = new HashMap<String, List>();
			 
			 try 
			 {
				 
			   final DocumentBuilder builder = factory.newDocumentBuilder();
			   final Document document= builder.parse(path);
			   
			   final Element racine = document.getDocumentElement();
			   //System.out.println(racine.getNodeName());
			   final NodeList racineNoeuds = racine.getChildNodes();
			   
			   
			   final int nbRacineNoeuds = racineNoeuds.getLength();
			   //System.out.println(nbRacineNoeuds);
			   
			   for (int i = 0; i<nbRacineNoeuds; i++) 
			   {
			     //System.out.println(racineNoeuds.item(i).getNodeName());
			     List listElement = new ArrayList<String>();
			    	 
			    	 final Element bottle = (Element) racineNoeuds.item(i);
			    	    //System.out.println(user.getNodeName());
			    	    Node bottleNode =  (Node) bottle.getChildNodes();
			    	    
			    	    
			    	    //System.out.println("password : " + userNode.getLastChild());
			    	    NodeList elementBottle =  bottleNode.getChildNodes();
			    	    final int nbElementBottle = elementBottle.getLength();
			    	    for (int j = 0; j<nbElementBottle; j++) 
						   {
			    	    	final Node bottleElem = (Node) elementBottle.item(j);
			    	    	listElement.add(bottleElem.getTextContent());
						   }
			    	    
			    	    allBottle.put(bottleNode.getNodeName(), listElement);
			    	    //System.out.println(password.getTextContent() + "____" + inputPassword);
			    	   
			     
			   }
			 } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
			 return allBottle;
			 
}

	
	public HashMap<String, List> getOneBottleFromCatalogById(String idBouteille) { // renvoie une hashmap <b+id_bouteille,list<attributs_bouteille>> de l'idBOuteille en paramètre (sous la form b+id_bouteille)
		 boolean match = false;
		 System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		
		
		 
		 String path = System.getProperty("user.dir");
		 path = path+"/XML/catalog.xml";  // POtentiellement à adapter pour taffer Lisa, comportement chelou
			 
			 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			 Node nodeToExplore = null;
			 HashMap<String, List> allBottle = new HashMap<String, List>();
			 
			 try 
			 {
				 
			   final DocumentBuilder builder = factory.newDocumentBuilder();
			   final Document document= builder.parse(path);
			   
			   final Element racine = document.getDocumentElement();
			   //System.out.println(racine.getNodeName());
			   final NodeList racineNoeuds = racine.getChildNodes();
			   
			   
			   final int nbRacineNoeuds = racineNoeuds.getLength();
			   //System.out.println(nbRacineNoeuds);
			   
			   for (int i = 0; i<nbRacineNoeuds; i++) 
			   {
			     //System.out.println(racineNoeuds.item(i).getNodeName());
			     List listElement = new ArrayList<String>();
			    	 
			    	 final Element bottle = (Element) racineNoeuds.item(i);
			    	    //System.out.println(user.getNodeName());
			    	    Node bottleNode =  (Node) bottle.getChildNodes();
			    	    
			    	    
			    	    //System.out.println("password : " + userNode.getLastChild());
			    	    NodeList elementBottle =  bottleNode.getChildNodes();
			    	    final int nbElementBottle = elementBottle.getLength();
			    	    for (int j = 0; j<nbElementBottle; j++) 
						   {
			    	    	final Node bottleElem = (Node) elementBottle.item(j);
			    	    	listElement.add(bottleElem.getTextContent());
						   }
			    	    if(bottleNode.getNodeName().equalsIgnoreCase(idBouteille)) {
			    	    allBottle.put(bottleNode.getNodeName(), listElement);
			    	    }
			    	    
			    	    
			    	    //System.out.println(password.getTextContent() + "____" + inputPassword);
			    	   
			     
			   }
			 } catch (Exception e) {
				System.out.println(e.getMessage());
			}
	
			 return allBottle;
			 
	}
	
	
	@SuppressWarnings("finally")
	public Integer idIncrementedBottle(){
		
		System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		 Integer id_bouteille = 0;
		 String path = System.getProperty("user.dir");
		 path = path+"/XML/catalog.xml";
		 final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			final Document document= builder.parse(path);
			final Element racine = document.getDocumentElement();
			System.out.println(racine.getNodeName());
			final NodeList racineNoeuds = racine.getChildNodes();
			 id_bouteille = racineNoeuds.getLength();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return id_bouteille;
		}
		   
		
		  
		
	}

}
	 

