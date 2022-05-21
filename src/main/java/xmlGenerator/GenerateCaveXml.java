package xmlGenerator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import metier.Bottle;
import metier.Users;

public class GenerateCaveXml {
	
	 public void generateFile(int userId) throws  IOException{
         
		 System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		
		 String path = System.getProperty("user.dir");
		 path = path+"/git/projet_jee_pal/src/main/webapp/XML/cave.xml"; // POtentiellement à adapter pour taffer Lisa, comportement chelou
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
			   
		  
		        String id_user_string = String.valueOf(userId);
		        Element id_cave = document.createElement("c"+id_user_string);
		        racine.appendChild(id_cave);
		        

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
			        Element rootElement = doc.createElement("caves");
			        doc.appendChild(rootElement);
			  
			        String id_user_string = String.valueOf(userId);
			        Element id_cave = doc.createElement("c"+id_user_string);
			        rootElement.appendChild(id_cave);
			        
			  
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
		  
	      
	   // return "Compte cr�ee avec succ�s !";
	    }

	 public void addBottle(int userId, Bottle bottle) {
	
	System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
		
	 String path = System.getProperty("user.dir");
	 path = path+"/src/main/webapp/XML/cave.xml"; // POtentiellement à adapter pour taffer Lisa, comportement chelou
	 System.out.println("path" + path);
	 File f = new File(path);
	 if(f.exists() && !f.isDirectory()) {
		 
		 try 
		 {
		   final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		   final DocumentBuilder builder = factory.newDocumentBuilder();
		   final Document document= builder.parse(path);
		   
		   final Element racine = document.getDocumentElement();
		   //System.out.println(racine.getNodeName());
		   final NodeList racineNoeuds = racine.getChildNodes();
		   
		   
		   final int nbRacineNoeuds = racineNoeuds.getLength();
		   System.out.println("nbracineNoeauds "+nbRacineNoeuds);
		   
		   for (int i = 0; i<nbRacineNoeuds; i++) 
		   {
		     //System.out.println(racineNoeuds.item(i).getNodeName());
		    	 
		    	 final Element cave = (Element) racineNoeuds.item(i);
		    	    //System.out.println(user.getNodeName());
		    	    Node caveNode =  (Node) cave.getChildNodes();
		    	    String id_user_string = String.valueOf(userId);
		    	    System.out.println("comparaison : " + caveNode.getNodeName() + "/" + "c"+id_user_string);
		    	    if((caveNode.getNodeName()).equalsIgnoreCase("c"+id_user_string)) {
		    	    	System.out.println("correspondance");
		    	    	String id_bottle_string = String.valueOf(bottle.getId());
		    	    	Node id_bottle = document.createElement("b"+id_bottle_string);
		    	    	caveNode.appendChild(id_bottle);
		    	    	
		    	    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
				        Transformer transformer = transformerFactory.newTransformer();
				        DOMSource source = new DOMSource(document);
				        StreamResult result = new StreamResult(path);
				  
				        transformer.transform(source, result);
		    	    	/*NodeList elementCave =  caveNode.getChildNodes();
			    	    final int nbElementCave = elementCave.getLength();
			    	    for (int j = 0; j<nbElementCave; j++) 
						   {
			    	    	final Node bottleElem = (Node) elementCaveitem(j);
			    	    	listElement.add(bottleElem.getTextContent());
						   }*/
		    	    }
		    	    
		    	    //System.out.println("password : " + userNode.getLastChild());
		    	    
		    	    
		    	  
		    	    
		    	    //System.out.println(password.getTextContent() + "____" + inputPassword);
		    	   
		     
		   }
		 } 
		      catch (ParserConfigurationException pce) {
		        pce.printStackTrace();
		      } catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	  
      
   // return "Compte cr�ee avec succ�s !";
    }
	 
	 
	 public void removeBottle(int userId, String idBootle) {
			
			System.out.println("Present Project Directory : "+ System.getProperty("user.dir"));
				
			 String path = System.getProperty("user.dir");
			 path = path+"/src/main/webapp/XML/cave.xml"; // POtentiellement à adapter pour taffer Lisa, comportement chelou
			 System.out.println("path" + path);
			 File f = new File(path);
			 if(f.exists() && !f.isDirectory()) {
				 
				 try 
				 {
				   final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				   final DocumentBuilder builder = factory.newDocumentBuilder();
				   final Document document= builder.parse(path);
				   
				   final Element racine = document.getDocumentElement();
				   //System.out.println(racine.getNodeName());
				   final NodeList racineNoeuds = racine.getChildNodes();
				   
				   
		    	    
		    	    
				   final int nbRacineNoeuds = racineNoeuds.getLength();
				   System.out.println("nbracineNoeauds "+nbRacineNoeuds);
				   
				   for (int i = 0; i<nbRacineNoeuds; i++) 
				   {
				     //System.out.println(racineNoeuds.item(i).getNodeName());
				    	 
				    	 final Element cave = (Element) racineNoeuds.item(i);
				    	    //System.out.println(user.getNodeName());
				    	    Node caveNode =  (Node) cave.getChildNodes();
				    	    NodeList caveNodeList =  cave.getChildNodes();
				    	    String id_user_string = String.valueOf(userId);
				    	    System.out.println("comparaison : " + caveNode.getNodeName() + "/" + "c"+id_user_string);
				    	    if((caveNode.getNodeName()).equalsIgnoreCase("c"+id_user_string)) {
				    	    	System.out.println("correspondance");
				    	    	final Node bottleElem = (Node) caveNodeList.item(i);
				    	    	System.out.println("Node" + bottleElem.getNodeName());
				    	    	//System.out.println("Node" + caveNode.getNodeName());
				    	    	if(bottleElem.getNodeName().equalsIgnoreCase(idBootle)) {
				    	    		System.out.println("Delete...");
				    	    		caveNode.removeChild(bottleElem);
				    	    	}
				    	    	
				    	    	TransformerFactory transformerFactory = TransformerFactory.newInstance();
						        Transformer transformer = transformerFactory.newTransformer();
						        DOMSource source = new DOMSource(document);
						        StreamResult result = new StreamResult(path);
						  
						        transformer.transform(source, result);
				    	    	/*NodeList elementCave =  caveNode.getChildNodes();
					    	    final int nbElementCave = elementCave.getLength();
					    	    for (int j = 0; j<nbElementCave; j++) 
								   {
					    	    	final Node bottleElem = (Node) elementCaveitem(j);
					    	    	listElement.add(bottleElem.getTextContent());
								   }*/
				    	    }
				    	    
				    	    //System.out.println("password : " + userNode.getLastChild());
				    	    
				    	    
				    	  
				    	    
				    	    //System.out.println(password.getTextContent() + "____" + inputPassword);
				    	   
				     
				   }
				 } 
				      catch (ParserConfigurationException pce) {
				        pce.printStackTrace();
				      } catch (SAXException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (TransformerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			 }
			  
		      
		   // return "Compte cr�ee avec succ�s !";
		    }
}
	 

