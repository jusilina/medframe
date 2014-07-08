/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medframe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import medframe.view.CreateFrame;
import org.xml.sax.SAXException;
import user.Category;

/**
 * @author Julia
 */
public class ProjectProperties implements PropertyNames {
    private static ProjectProperties properties;

    private ArrayList<String> partOfBody;
    private ArrayList<String> joints;
    private ArrayList<Category> categories;
    private ArrayList disturbed_sleepList;
    private ArrayList<String> emotionViolations;
    private ArrayList<String> cranicalNerveViolations;
    private ArrayList<String> nervousSystemList;
    private ArrayList<String> rombergList;
    private ArrayList<String> sensitivityDisbalanceList;
    private ArrayList<String> limbReflexesList;
    private ArrayList<String> nervousTensionList;
    private ArrayList<String> pReflexesHand;
    private ArrayList<String> pReflexesLeg;
    private ArrayList<String> aReflexesList;
    private ArrayList<String> muscleToneList;
    private ArrayList<String> motionList;
    private ArrayList<String> recommendationList;
    private ArrayList<String> therapy;
    private ArrayList coordinationTest;
    private ArrayList pelvicOrganList;
    private ArrayList complaints;

    public ArrayList<String> getTherapy() {
        return therapy;
    }


    public ArrayList<String> getaReflexesList() {
        return aReflexesList;
    }

    public ArrayList<String> getMuscleToneList() {
        return muscleToneList;
    }

    public ArrayList<String> getMotionList() {
        return motionList;
    }


    public ArrayList<String> getpReflexesHand() {
        return pReflexesHand;
    }

    public ArrayList<String> getpReflexesLeg() {
        return pReflexesLeg;
    }

    public ArrayList<String> getCranicalNerveViolations() {
        return cranicalNerveViolations;
    }

    public ArrayList<String> getNervousTensionList() {
        return nervousTensionList;
    }

    public ArrayList<String> getLimbReflexesList() {
        return limbReflexesList;
    }

    public void setLimbReflexesList(ArrayList<String> limbReflexesList) {
        this.limbReflexesList = limbReflexesList;
    }

    public ArrayList<String> getSensitivityDisbalanceList() {
        return sensitivityDisbalanceList;
    }


    public ArrayList<String> getNervousSystemList() {
        return nervousSystemList;
    }

    public ArrayList<String> getRombergList() {
        return rombergList;
    }

    public ArrayList<String> getRecommendationList() {
        return recommendationList;
    }


    public ArrayList<String> getEmotionViolations() {
        return emotionViolations;
    }

    public void setEmotionViolations(ArrayList emotionViolations) {
        this.emotionViolations = emotionViolations;
    }


    public ArrayList<String> getDisturbed_sleepList() {
        return disturbed_sleepList;
    }

    public void setDisturbed_sleepList(ArrayList disturbed_sleepList) {
        this.disturbed_sleepList = disturbed_sleepList;
    }

    public ArrayList<String> getPartOfBody() {
        return partOfBody;
    }

    public ArrayList<String> getJoints() {
        return joints;
    }

    public ArrayList getCoordinationTest() {
        return coordinationTest;
    }

    public ArrayList getPelvicOrganList() {
        return pelvicOrganList;
    }

    public ArrayList getComplaints() {
        return complaints;
    }

    public ArrayList<String> getCategoriesNames() {
        ArrayList categoriesNames = new ArrayList();
        for (Category cat : categories) {
            categoriesNames.add(cat.getName());
        }
        return categoriesNames;
    }

    public ArrayList<Category> getCategories() {

        return categories;
    }

    private ProjectProperties() {
        importProperties();
    }

    public static ProjectProperties getProperties() {
        if (properties == null) {
            properties = new ProjectProperties();
        }
        return properties;
    }


    private void importProperties() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();
            parser.parse(new File("properties.xml"), handler);

            partOfBody = handler.getPartOfBodys();
//            System.out.println(partOfBody.toString());
            joints = handler.getJoints();

            categories = handler.getCategories();//new ArrayList<>();
//            for (Category cat : handler.getCategories()) {
//                categories.add(cat.getName());
//            }

            disturbed_sleepList = handler.getDisturbed_sleepList();
            emotionViolations = handler.getEmotionViolations();
            cranicalNerveViolations = handler.getCranicalNerveViolations();
            cranicalNerveViolations.add(0, CRANICAL_NERVE_N);
            nervousSystemList = handler.getNervousSystemList();
            rombergList = handler.getRombergList();
            sensitivityDisbalanceList = handler.getSensitivityDisbalanceList();
            nervousTensionList = handler.getNervousTensionList();
            limbReflexesList = handler.getLimbReflexesList();
            pReflexesHand = handler.getpReflexesHand();
            pReflexesLeg = handler.getpReflexesLeg();
            aReflexesList = handler.getaReflexesList();
            muscleToneList = handler.getMuscleToneList();
            muscleToneList.add(0, N);
            motionList = handler.getMotionList();
            recommendationList = handler.getRecommendationList();
            therapy = handler.getTherapyList();
            coordinationTest = handler.getCoordinationTest();
            pelvicOrganList = handler.getPelvicOrganList();
            complaints = handler.getComplaints();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
