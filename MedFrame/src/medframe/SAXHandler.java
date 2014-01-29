/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import user.Category;

/**
 *
 * @author Julia
 */
public class SAXHandler extends DefaultHandler
{

    private ArrayList<String> partOfBody;
    private ArrayList<String> joints;
    private ArrayList<Category> categories;
    private ArrayList disturbed_sleepList;
    private ArrayList emotionViolations;
    private ArrayList cranicalNerveViolations;
    private ArrayList nervousSystemList;
    private ArrayList rombergList;
    private Category category;
    private ArrayList drugs;
//     private ArrayList catList;
    private boolean isDrug;
    private String thisDrug;
    private ArrayList sensitivityDisbalanceList;
    private ArrayList nervousTensionList;
    private ArrayList<String> pReflexesHand;
    private ArrayList<String> pReflexesLeg;
    private ArrayList aReflexesList;

    public ArrayList getaReflexesList()
    {
        return aReflexesList;
    }

    
    public ArrayList<String> getpReflexesHand()
    {
        return pReflexesHand;
    }

    public ArrayList<String> getpReflexesLeg()
    {
        return pReflexesLeg;
    }

    public ArrayList getSensitivityDisbalanceList()
    {
        return sensitivityDisbalanceList;
    }

    public ArrayList getNervousTensionList()
    {
        return nervousTensionList;
    }

    public ArrayList getCranicalNerveViolations()
    {
        return cranicalNerveViolations;
    }

    public ArrayList getEmotionViolations()
    {
        return emotionViolations;
    }

    public ArrayList getDisturbed_sleepList()
    {
        return disturbed_sleepList;
    }

    public void setDisturbed_sleepList(ArrayList disturbed_sleepList)
    {
        this.disturbed_sleepList = disturbed_sleepList;
    }

    public ArrayList<Category> getCategories()
    {
        return categories;
    }
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

    public ArrayList getNervousSystemList()
    {
        return nervousSystemList;
    }

    public ArrayList getRombergList()
    {
        return rombergList;
    }

    @Override
    public void startDocument() throws SAXException
    {
        partOfBody = new ArrayList<String>();
        joints = new ArrayList<String>();
        categories = new ArrayList();
        disturbed_sleepList = new ArrayList();
        emotionViolations = new ArrayList();
        cranicalNerveViolations = new ArrayList();
        nervousSystemList = new ArrayList();
        rombergList = new ArrayList();
        sensitivityDisbalanceList = new ArrayList();
        nervousTensionList = new ArrayList();
        pReflexesHand = new ArrayList<>();
        pReflexesLeg = new ArrayList<>();
        aReflexesList = new ArrayList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        thisElement = qName;
        isDrug = false;
        if (qName.equals("category"))
        {

            drugs = new ArrayList();
            String name = attributes.getValue("name");
            category = new Category(name);
        }
        if (qName.equals("drug"))
        {
            isDrug = true;
            thisDrug = attributes.getValue("id");

        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {

        switch (thisElement)
        {
            case "partOfBody":
            {
                partOfBody.add(new String(ch, start, length));
                break;
            }
            case "joint":
            {
                joints.add(new String(ch, start, length));
                break;
            }
            case "drug":
            {
//        category.addDrug(new String(ch, start, length));
                category.addDrug(thisDrug);
                break;
            }
            case "mark":
            {
                category.addMarkForDrug(thisDrug, new String(ch, start, length));
                break;
            }
            case "disturbed_sleep":
            {
                disturbed_sleepList.add(new String(ch, start, length));
                break;
            }
            case "emotion":
            {
                emotionViolations.add(new String(ch, start, length));
                break;
            }
            case "cranicalNerve":
            {
                cranicalNerveViolations.add(new String(ch, start, length));
                break;
            }
            case "nervousSystem":
            {
                nervousSystemList.add(new String(ch, start, length));
                break;
            }
            case "rombergManeuver":
            {
                rombergList.add(new String(ch, start, length));
                break;
            }
            case "sensitivityDisbalance":
            {
                sensitivityDisbalanceList.add(new String(ch, start, length));
                break;
            }
            case "nervousTension":
            {
                nervousTensionList.add(new String(ch, start, length));
                break;
            }
            case "pReflexesHand":
            {
                pReflexesHand.add(new String(ch, start, length));
                break;
            }
            case "pReflexesLeg":
            {
                pReflexesLeg.add(new String(ch, start, length));
                break;
            }
            case "aReflexes":
            {
                aReflexesList.add(new String(ch, start, length));
                break;
            }
//    case "category":{
//        categories.add(new String(ch, start, length));
//        break;
//    }

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        thisElement = "";
        if (qName.equals("category"))
        {
            categories.add(category);

        }
    }

    @Override
    public void endDocument() throws SAXException
    {
    }

}
