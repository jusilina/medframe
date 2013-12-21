/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import user.Visit;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julia
 */
public class Storage implements PropertyNames
{

    private final String pdfFont = "tahoma.ttf";
    private final String encoding = "cp1251";

    public void exportFile(File file, Visit visit)
    {
        Map<String, String> elements = visit.getParametersMap();
        OutputStream outputStream;
        XMLStreamWriter out = null;
        try
        {
            outputStream = new FileOutputStream(file);
            System.out.println("exportFile");

            out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));

            out.writeStartDocument();

            for (String key : elements.keySet())
            {
                out.writeStartElement(key);
                out.writeCharacters(elements.get(key));
                out.writeEndElement();
                out.writeCharacters("   ");

            }
//            out.writeStartElement("person");
//
//            out.writeStartElement("name");
//         //   out.writeCharacters(visit.getName());
//            out.writeEndElement();
//            
//            out.writeStartElement("date");
//
//            out.writeEndElement();
            out.writeEndDocument();
            out.close();
            outputStream.close();

        }
        catch (Exception ex)
        {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void savePDF(File file, Visit visit)
    {
        Document document = new Document(PageSize.A4);
        try
        {
            BaseFont times = BaseFont.createFont(pdfFont, encoding, BaseFont.EMBEDDED);
            Font font = new Font(times);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Paragraph titleParagraph = new Paragraph(TITLE, font);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            Paragraph mainPart = new Paragraph();
            mainPart.setFont(font);
            mainPart.setAlignment(Element.ALIGN_LEFT);

            Phrase date = new Phrase(DATE + SPACE + visit.getStringDate());
            mainPart.add(date);

            document.add(mainPart);

            document.close();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
