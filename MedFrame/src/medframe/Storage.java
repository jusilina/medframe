/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medframe;

import com.google.common.collect.Multimap;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.xml.sax.SAXException;
import user.Visit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.*;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import medframe.view.CreateFrame;

/**
 * @author Julia
 */
public class Storage implements PropertyNames {

    private final String pdfFont = "tahoma.ttf";
    private final String encoding = "cp1251";
    private final float fontSize = 10;

    private static Logger log = Logger.getLogger(Storage.class.getName());

    public void exportFile(File file, Visit visit) {
        Multimap<String, String> elements = visit.getParametersMap();
        OutputStream outputStream;
        XMLStreamWriter out = null;
        try {
            outputStream = new FileOutputStream(file);
            System.out.println("exportFile");

            out = XMLOutputFactory.newInstance().createXMLStreamWriter(
                    new OutputStreamWriter(outputStream, "utf-8"));

            out.writeStartDocument();

            out.writeStartElement("parameters");
            for (String key : elements.keySet()) {
                for (String value : elements.get(key)) {
                    out.writeStartElement(key);
                    out.writeCharacters(value);
                    out.writeEndElement();
                    out.writeCharacters("   ");
                }

            }
            out.writeEndElement();

            out.writeEndDocument();
            out.close();
            outputStream.close();

        } catch (Exception ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Visit importFile(File file) {
        Visit visit = new Visit();

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXImportHandler handler = new SAXImportHandler(visit);
            parser.parse(file, handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return visit;

    }

    public boolean savePDF(File file, Visit visit) {
        Document document = new Document(PageSize.A4);
        try {
            BaseFont times = BaseFont.createFont(pdfFont, encoding, BaseFont.EMBEDDED);
            Font font = new Font(times);
            font.setSize(fontSize);
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            Paragraph titleParagraph = new Paragraph(TITLE, font);
            titleParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(titleParagraph);

            Paragraph mainPart = new Paragraph();
            mainPart.setFont(font);
            mainPart.setAlignment(Element.ALIGN_LEFT);

            Chunk date = new Chunk(DATE + SPACE + visit.getStringDate(visit.getDate()) + "   ");
//            Chunk date = new Chunk(DATE + SPACE + visit.getDate().toString() + "   ");
            Chunk name = new Chunk(NAME + SPACE + visit.getName());
            Phrase dateAndName = new Phrase();
            dateAndName.add(date);
            dateAndName.add(name);

            mainPart.add(dateAndName);
            document.add(mainPart);

            Paragraph complaint = new Paragraph();
            complaint.setFont(font);
            //   Phrase complaine = new Phrase();
            Phrase complaintCh = new Phrase(COMPLAINTS + SPACE);
            //    complaineCh.getFont().setStyle(Font.BOLD);
            Phrase complaintVal = new Phrase(visit.getComplaintList().toString() + SPACE+ visit.getComplaint());

            complaint.add(complaintCh);
            complaint.add(complaintVal);

            document.add(complaint);

            Paragraph socialAnamnesis = new Paragraph();
            socialAnamnesis.setFont(font);
            Phrase job = new Phrase(SOCIAL_ANAMNESIS + SPACE);
            socialAnamnesis.add(job);
            if (visit.getSocialAnamnesis().equals(WORKING)) {
                Phrase jobValue = new Phrase(visit.getSocialAnamnesis() + SPACE + visit.getProfission() + SPACE);
                Phrase stress = new Phrase(visit.getStress() + SPACE);
                socialAnamnesis.add(jobValue);
                socialAnamnesis.add(stress);
            } else {
                Phrase jobValue = new Phrase(visit.getSocialAnamnesis() + SPACE);
                socialAnamnesis.add(jobValue);
            }

            document.add(socialAnamnesis);

            Paragraph anamnesis = new Paragraph();
            anamnesis.setFont(font);

            Phrase anamnesisText = new Phrase(ANAMNESIS + SPACE);
            Phrase anamnesisTextVal = new Phrase(visit.getAnamnesis());
            anamnesis.add(anamnesisText);
            anamnesis.add(anamnesisTextVal);

            document.add(anamnesis);

            Paragraph conscious = new Paragraph();
            conscious.setFont(font);

            Phrase consciousLabel = new Phrase(CONSCIOUS + SPACE);
            Phrase consciousValue = new Phrase(visit.getConscious() + SPACE);
            Phrase consciousAdd = new Phrase(visit.getConsciousAdd() + SPACE);
            Phrase epilepticLabel = new Phrase(EPILEPTIC_SEIZURE + SPACE);
            Phrase epileptic = new Phrase(visit.getEpileptic());

            conscious.add(consciousLabel);
            conscious.add(consciousValue);
            conscious.add(consciousAdd);
            conscious.add(epilepticLabel);
            conscious.add(epileptic);

            document.add(conscious);

            Paragraph emotion = new Paragraph();
            emotion.setFont(font);

            Phrase emotionLabel = new Phrase(EMOTION + SPACE);
            Phrase emotionVal = new Phrase(visit.getEmotion().toString());
            emotion.add(emotionLabel);
            emotion.add(emotionVal);

            document.add(emotion);

            Paragraph dream = new Paragraph();
            dream.setFont(font);

            Phrase dreamLabel = new Phrase(DREAM + SPACE);
            Phrase dreamVal;
            dreamVal = new Phrase(visit.getDream().toString());
            dream.add(dreamLabel);
            dream.add(dreamVal);

            document.add(dream);

            Paragraph cranicalNerve = new Paragraph();
            cranicalNerve.setFont(font);

            Phrase cranicalNerveLabel = new Phrase(CRANIAL_NERVE + SPACE);
            Phrase cranicalNerveVal;
            cranicalNerveVal = new Phrase(visit.getCranicalNerve().toString());
            cranicalNerve.add(cranicalNerveLabel);
            cranicalNerve.add(cranicalNerveVal);

            document.add(cranicalNerve);

            Paragraph sensitivity = new Paragraph();
            sensitivity.setFont(font);

            Phrase sensitivityLabel = new Phrase(SENSITIVITY + SPACE);
            Phrase sensitivityVal;
            sensitivityVal = new Phrase(visit.getSensitivity().toString());
            sensitivity.add(sensitivityLabel);
            sensitivity.add(sensitivityVal);

            document.add(sensitivity);

            Paragraph nervousTension = new Paragraph();
            nervousTension.setFont(font);

            Phrase nervousTensionLabel = new Phrase(NERVOUS_TENSION + SPACE);
            Phrase nervousTensionVal;
            nervousTensionVal = new Phrase(visit.getNervousTension().toString());
            nervousTension.add(nervousTensionLabel);
            nervousTension.add(nervousTensionVal);

            document.add(nervousTension);

            Paragraph reflexes = new Paragraph();
            reflexes.setFont(font);

            Phrase reflexesLabel = new Phrase(REFLEXES + SPACE);

            //    Phrase reflexesVal;
//            java.util.List reflexesVal = visit.getReflexes();
            String reflexesU = "D " + visit.getUpperDSLimb() + " S ";
            String reflexesL = "D " + visit.getLowerDSLimb() + " S ";

            Phrase reflexesLabelU = new Phrase(UPPER + SPACE + LIMBS + SPACE + visit.getUpperLimbReflexes() + SPACE + reflexesU);
            Phrase reflexesLabelL = new Phrase(LOWER + SPACE + LIMBS + SPACE + visit.getDownLimbReflexes() + SPACE + reflexesL);

            reflexes.add(reflexesLabel);
            reflexes.add(reflexesLabelU);
            reflexes.add(reflexesLabelL);

            document.add(reflexes);

            Paragraph pReflexes = new Paragraph();
            pReflexes.setFont(font);

            Phrase pReflexesLabel = new Phrase(P_REFLEXES + SPACE);
            Phrase pReflexesVal;
            if (visit.getpReflexes().equals(NO)) {
                pReflexesVal = new Phrase(visit.getpReflexes().toString());
            } else {
                pReflexesVal = new Phrase(HAND + SPACE + visit.getpReflexesHand().toString() + SPACE + LEG + SPACE + visit.getpReflexesLeg().toString());
            }

            pReflexes.add(pReflexesLabel);
            pReflexes.add(pReflexesVal);

            document.add(pReflexes);

            Paragraph aReflexes = new Paragraph();
            aReflexes.setFont(font);

            Phrase aReflexesLabel = new Phrase(A_REFLEXES + SPACE);
            Phrase aReflexesVal;
            aReflexesVal = new Phrase(visit.getaReflexes().toString());
            aReflexes.add(aReflexesLabel);
            aReflexes.add(aReflexesVal);

            document.add(aReflexes);

            log.info("Print gait to PDF");

            Paragraph gaitAndMotion = new Paragraph();
            gaitAndMotion.setFont(font);

            Phrase gaiteLabel = new Phrase(GAIT + SPACE);
            Phrase gaiteVal;
            gaiteVal = new Phrase(visit.getGait());
            gaitAndMotion.add(gaiteLabel);
            gaitAndMotion.add(gaiteVal);
            gaitAndMotion.add(SPACE);


            log.info("Print motion to PDF");
//            Paragraph motion = new Paragraph();
//            motion.setFont(font);

            Phrase motionTypeValue = new Phrase(visit.getMotionType() + SPACE);
            Phrase motionLabel = new Phrase(MOTION + SPACE);
            Phrase motionVal;
            motionVal = new Phrase(visit.getMotion().toString());

            gaitAndMotion.add(motionTypeValue);
            gaitAndMotion.add(motionLabel);
            gaitAndMotion.add(motionVal);

//            document.add(motion);

            document.add(gaitAndMotion);

            log.info("Print muscle to PDF");
            Paragraph muscle = new Paragraph();
            muscle.setFont(font);

            Phrase muscleLabel = new Phrase(MUSCLE_TONE + SPACE);
            Phrase muscleVal;
            muscleVal = new Phrase(visit.getMuscle().toString());
            muscle.add(muscleLabel);
            muscle.add(muscleVal);

            document.add(muscle);

            log.info("Print coordination to PDF");
            Paragraph coordination = new Paragraph();
            coordination.setFont(font);

            Phrase coordinationLabel = new Phrase(COORDINATION + SPACE);
            Phrase coordinationVal = new Phrase(visit.getCoordination() + SPACE);

            coordination.add(coordinationLabel);
            coordination.add(coordinationVal);

            if (!visit.getCoordination().equals(NORM)) {
                Phrase coordinationRombergLabel = new Phrase(ROMBERG_MANEUVER + SPACE);
                Phrase coordinationRombergVal = new Phrase(visit.getRomberg().toString() + SPACE);

                Phrase coordinationTestLabel = new Phrase(COORDINATION_TESTS + SPACE);
                String coordinationTestDSN = "D" + visit.getCoordinationTestDS() + "S" + visit.getCoordinationTestSN() + "N" + SPACE;
                Phrase coordinationTestVal = new Phrase(coordinationTestDSN + visit.getCoordinationTest());


                coordination.add(coordinationRombergLabel);
                coordination.add(coordinationRombergVal);
                coordination.add(coordinationTestLabel);

                coordination.add(coordinationTestVal);
            }


            document.add(coordination);

            log.info("print nervousSystem to PDF");
            Paragraph nervousSystem = new Paragraph();
            nervousSystem.setFont(font);

            Phrase nervousSystemValue = new Phrase(visit.getNervousSystem().toString() + SPACE);
            Phrase nervousSystemLabel = new Phrase(NERVOUS_SYSTEM + SPACE);

            nervousSystem.add(nervousSystemLabel);
            nervousSystem.add(nervousSystemValue);

            document.add(nervousSystem);

            Paragraph pelvicOrgan = new Paragraph();
            pelvicOrgan.setFont(font);

            Phrase pelvicOrganLabel = new Phrase(PELVIC_ORGAN + SPACE);
            Phrase pelvicOrganValue = new Phrase(visit.getPelvicOrganList().toString() + SPACE + visit.getPelvicOrgan());

            pelvicOrgan.add(pelvicOrganLabel);
            pelvicOrgan.add(pelvicOrganValue);

            document.add(pelvicOrgan);

            log.info("Print diagnosis to PDF");

            Paragraph diagnosis = new Paragraph();
            diagnosis.setFont(font);

            Phrase diagnosisLabel = new Phrase(DIAGNOSIS + SPACE);
            Phrase diagnosisValue = new Phrase(visit.getDiagnosis());

            diagnosis.add(diagnosisLabel);
            diagnosis.add(diagnosisValue);

            document.add(diagnosis);

            log.info("Print recommendations to PDF");
            Paragraph recommendations = new Paragraph();
            recommendations.setFont(font);

            Phrase recommendationsLabel = new Phrase(RECOMMENDATIONS + SPACE);
            Phrase recommendationsValue = new Phrase(visit.getRecommendations().toString() + SPACE + visit.getRecommendationsAdd());

            recommendations.add(recommendationsLabel);
            recommendations.add(recommendationsValue);

            document.add(recommendations);

            Paragraph therapy = new Paragraph();
            therapy.setFont(font);

            Phrase therapyLabel = new Phrase(THERAPY + SPACE);
            Phrase therapyValue = new Phrase(visit.getTherapy().toString());

            therapy.add(therapyLabel);
            therapy.add(therapyValue);

            document.add(therapy);

            Paragraph workCapacity = new Paragraph();
            workCapacity.setFont(font);

            workCapacity.add(new Phrase(visit.getWorkCapacity()+SPACE));
            Paragraph workCapacityList = new Paragraph();
            workCapacityList.setFont(font);
            workCapacityList.add(new Phrase(WORK_CAPACITY_LIST + SPACE + FROM + SPACE+visit.getStringDate(visit.getWorkCapacityListDateFrom()) + SPACE + TO + SPACE+visit.getStringDate(visit.getWorkCapacityListDateTo()) + SPACE));

            workCapacityList.add(new Phrase(APPEARANCE+SPACE+visit.getStringDate(visit.getAppearanceDate())));
            document.add(workCapacity);
            document.add(workCapacityList);


            document.close();
        } catch (Exception ex) {
            Logger.getLogger(Storage.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
