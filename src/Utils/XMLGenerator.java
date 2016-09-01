package Utils;

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
import org.w3c.dom.Text;

import dto.LogInDTO;


public class XMLGenerator {
	
	 public static void generate(String name, LogInDTO logIn) throws Exception{

	        if(logIn == null){
	            System.out.println("ERROR empty ArrayList");
	            return;
	        }else{

	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            DOMImplementation implementation = builder.getDOMImplementation();
	            Document document = implementation.createDocument(null, name, null);
	            document.setXmlVersion("1.0");

	            //Main Node
	            Element raiz = document.getDocumentElement();
	            //Por cada key creamos un item que contendrá la key y el value	            
	                //Item Node
	                Element LogInDTONode = document.createElement("LogInDTO"); 
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
	                LogInDTONode.appendChild(PuertoNode);
	                LogInDTONode.appendChild(userNode);
	                LogInDTONode.appendChild(passNode);
	                
	                raiz.appendChild(LogInDTONode); //pegamos el elemento a la raiz "Documento"             
	            //Generate XML
	            Source source = new DOMSource(document);
	            //Indicamos donde lo queremos almacenar
	            Result result = new StreamResult(new java.io.File(name+".xml")); //nombre del archivo
	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.transform(source, result);
	        }
	    }

} 