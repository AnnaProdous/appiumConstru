package com.utils;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestUtils {
    public static final long WAIT = 30;

    public static HashMap<String, String> parseStringXML(InputStream file) throws Exception {
        // Create a map to store the parsed string resources
        HashMap<String, String> stringMap = new HashMap<>();

        // Create a DocumentBuilderFactory to create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML input stream into a Document
        Document document = builder.parse(file);

        //Normalize the XML Structure; It's just too important !!
        document.getDocumentElement().normalize();

        //Here comes the root node
        Element root = document.getDocumentElement();

        // Get a list of all <string> elements in the XML document
        NodeList nList = document.getElementsByTagName("string");

        // Iterate through each <string> element and extract its attributes
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element sElement = (Element) node;
                // Store each element key value in map
                stringMap.put(sElement.getAttribute("name"), sElement.getTextContent());
            }
        }
        // Return the map containing the parsed string resources
        return stringMap;
    }

    }






