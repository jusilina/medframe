/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import com.itextpdf.text.Element;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.w3c.dom.Document;

/**
 *
 * @author Julia
 */
public class Storage
{

    public void exportFile()
    {
        OutputStream outputStream;
        XMLStreamWriter out = null;
        try
        {
            outputStream = new FileOutputStream(new File("C:\\doc.xml"));
            System.out.println("exportFile");

            out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));

            out.writeStartDocument();
            out.writeStartElement("person");

            out.writeStartElement("name");
            out.writeCharacters("TEST NAME");
            out.writeEndElement();

            out.writeEndElement();
            out.writeEndDocument();
            out.close();
            outputStream.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
