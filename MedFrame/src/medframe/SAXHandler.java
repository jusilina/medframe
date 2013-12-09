/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medframe;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Julia
 */
public class SAXHandler extends DefaultHandler
{
    private ArrayList <String> partOfBody;
     private ArrayList <String> joints;
   // private boolean isPartOfBody = false;
    String thisElement = ""; 
    
    public ArrayList getPartOfBodys()
    {
        return partOfBody;
    }
    
    public ArrayList<String> getJoints()
    {
        return joints;
    }
    
      @Override
  public void startDocument() throws SAXException
  {
    partOfBody = new ArrayList<>();
    joints = new ArrayList<>();
  }
  
    @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
  {
    thisElement = qName; 
  }
  @Override
  public void characters(char[] ch, int start, int length) throws SAXException
  {
    switch(thisElement){
    case "partOfBody":{
         partOfBody.add(new String(ch, start, length));
         break;
    }
    case "joint":{
        joints.add(new String(ch, start, length));
        break;       
    
    }
    
    }
        
     
  }
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException
  {
       thisElement = ""; 
  }
  @Override
  public void endDocument() throws SAXException
  {
  }
    
    
}
