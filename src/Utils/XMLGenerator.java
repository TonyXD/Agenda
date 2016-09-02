package Utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import dto.LogInDTO;


public class XMLGenerator {
	
	 public static void generate(String name, LogInDTO logIn) throws Exception{

	        if(logIn == null){
	            System.out.println("ERROR empty ArrayList");
	            return;
	        }
	        else
	        {

	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            DOMImplementation implementation = builder.getDOMImplementation();
	            Document document = implementation.createDocument(null, "LogInDTO", null);
	            document.setXmlVersion("1.0");

	            //Main Node
	            Element raiz = document.getDocumentElement();
	            //Por cada key creamos un item que contendrá la key y el value	            
	                //Item Node 
		            Element SchemaNode = document.createElement("Schema"); 
	                Text nodeSchemaValue = document.createTextNode(logIn.getSchema());
	                
	                SchemaNode.appendChild(nodeSchemaValue);  
	                Element IpLocalNode = document.createElement("IpLocal"); 
	                Text nodeIpLocalValue = document.createTextNode(logIn.getIpLocal());
	                IpLocalNode.appendChild(nodeIpLocalValue);  	                
	                Element PuertoNode = document.createElement("puerto"); 
	                Text nodePuertoValue = document.createTextNode(logIn.getPuerto());
	                PuertoNode.appendChild(nodePuertoValue);   
	                Element userNode = document.createElement("user"); 
	                Text nodeUserValue = document.createTextNode(logIn.getUser());                
	                userNode.appendChild(nodeUserValue);	                
	                Element passNode = document.createElement("pass"); 
	                Text nodePassValue = document.createTextNode(logIn.getUser());                
	                passNode.appendChild(nodePassValue);	                
	                //append keyNode and valueNode to itemNode
	                raiz.appendChild(SchemaNode);
	                raiz.appendChild(IpLocalNode);
	                raiz.appendChild(PuertoNode);
	                raiz.appendChild(userNode);
	                raiz.appendChild(passNode);//pegamos el elemento a la raiz "Documento"             
	            //Generate XML
	            Source source = new DOMSource(document);
	            //Indicamos donde lo queremos almacenar
	            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.transform(source, result);
	        }
	    }
	 
	 public static LogInDTO ParseXmlToLogIn()
	 {		
		 LogInDTO log = new LogInDTO();
		 try
		 {
			 DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
				Document document = docBuilder.parse(new File("conexion.xml"));

				NodeList nodeList = document.getElementsByTagName("*");
				
				
				log.setPuerto(nodeList.item(3).getTextContent());
				log.setUser(nodeList.item(4).getTextContent());
				log.setPass(nodeList.item(5).getTextContent());
				return log;
		 }
		 catch(Exception ex)
		 {
		 }
		return log;
		
	 }
	 

} 