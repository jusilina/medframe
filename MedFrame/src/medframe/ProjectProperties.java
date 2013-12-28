/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medframe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import medframe.view.CreateFrame;
import org.xml.sax.SAXException;

/**
 *
 * @author Julia
 */
public class ProjectProperties
{
    private static ProjectProperties properties;

    public ArrayList<String> getPartOfBody()
    {
        return partOfBody;
    }

    public ArrayList<String> getJoints()
    {
        return joints;
    }
    
   private ArrayList<String> partOfBody;
   private ArrayList<String> joints;
    private ArrayList <String> categories;

    public ArrayList<String> getCategories()
    {
        return categories;
    }
    
   private ProjectProperties(){
       importProperties();
   }
   
   public static ProjectProperties getProperties()
   {
       if(properties == null)
       {
           properties = new ProjectProperties();
       }
       return properties;
   }
    
    
    
    
    private void importProperties()
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(new File("properties.xml"), handler);

            partOfBody = handler.getPartOfBodys();
            System.out.println(partOfBody.toString());
            joints = handler.getJoints();
            
            categories = handler.getCategories();

        }
        catch (ParserConfigurationException ex)
        {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SAXException ex)
        {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
