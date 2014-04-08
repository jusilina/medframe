/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import medframe.view.CreateFrame;

/**
 *
 * @author Julia
 */
public class Visit
{

    private String name;
    private Date date;
    private String complaine;
    private String socialAnamnesis;
    private String profission;
    private String stress;
    private String anamnesis;
    private String conscious;
    private String consciousAdd;
    private String epileptic;
    private List<String> emotion = new ArrayList<String>();
    private LinkedList<String> dream = new LinkedList<String>();
    private List<String> cranicalNerve;
    private List<String> sensitivity = new ArrayList<String>();
    private List<String> nervousTension = new ArrayList<String>();
    private List<String> reflexes = new ArrayList<String>();
    private List<String> pReflexes = new ArrayList<String>();
    private List<String> aReflexes = new ArrayList<String>();
    private String gaite;
    private List<String> motion = new ArrayList<String>();
    private String motionType;
    private List<String> muscle = new ArrayList<String>();
    private String coordination;
    private List coordinationTest = new ArrayList();
    private List<String> romberg = new ArrayList<String>();
    private List<String> nervousSystem = new ArrayList<String>();
    private String diagnosis;
    private String pelvicOrgan;
    private List<String> recommendations = new ArrayList<String>();
    private String recommendationsAdd;
    private List<String> therapy = new ArrayList<String>();
    private static Logger log = Logger.getLogger(Visit.class.getName());

    public List<String> getEmotion()
    {
        return emotion;
    }

    public List<ArrayList> getCoordinationTest()
    {
        return coordinationTest;
    }

    public void setCoordinationTest(List coordinationTest)
    {
        this.coordinationTest = coordinationTest;
    }

    public String getMotionType()
    {
        return motionType;
    }

    public void setMotionType(String motionType)
    {
        this.motionType = motionType;
    }

    public void setEmotion(List emotion)
    {
        this.emotion = emotion;
    }

    public List<String> getDream()
    {
        return dream;
    }

    public void setDream(LinkedList dream)
    {
        this.dream = dream;
    }

    public List<String> getSensitivity()
    {
        return sensitivity;
    }

    public void addSensitivity(String sensitivity)
    {
        this.sensitivity.add(0, sensitivity);
    }

    public void setSensitivity(List sensitivity)
    {
        this.sensitivity = sensitivity;
    }

    public List getReflexes()
    {
        return reflexes;
    }

    public void setReflexes(List reflexes)
    {
        this.reflexes = reflexes;
    }

    public List getpReflexes()
    {
        return pReflexes;
    }

    public void setpReflexes(List pReflexes)
    {
        this.pReflexes = pReflexes;
    }

    public List getaReflexes()
    {
        return aReflexes;
    }

    public void setaReflexes(List aReflexes)
    {
        this.aReflexes = aReflexes;
    }

    public String getGaite()
    {
        return gaite;
    }

    public void setGaite(String gaite)
    {
        this.gaite = gaite;
    }

    public String getCoordination()
    {
        return coordination;
    }

    public void setCoordination(String coordination)
    {
        this.coordination = coordination;
    }

    public List getNervousSystem()
    {
        return nervousSystem;
    }

    public void setNervousSystem(List nervousSystem)
    {
        this.nervousSystem = nervousSystem;
    }

    public String getDiagnosis()
    {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis)
    {
        this.diagnosis = diagnosis;
    }

    public List getTherapy()
    {
        return therapy;
    }

    public void setTherapy(List therapy)
    {
        this.therapy = therapy;
    }

    public String getComplaine()
    {
        return complaine;
    }

    public void setComplaine(String complaine)
    {
        this.complaine = complaine;
    }

    public String getSocialAnamnesis()
    {
        return socialAnamnesis;
    }

    public void setSocialAnamnesis(String socialAnamnesis)
    {
        this.socialAnamnesis = socialAnamnesis;
    }

    public String getStress()
    {
        return stress;
    }

    public void setStress(String stress)
    {
        this.stress = stress;
    }

    public String getAnamnesis()
    {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis)
    {
        this.anamnesis = anamnesis;
    }

    public String getName()
    {
        return name;
    }

    public Date getDate()
    {
        return date;
    }

    public String getStringDate()
    {
        if (null != date)
        {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(date);
//            int year = cal.get(Calendar.YEAR);
//            int month = cal.get(Calendar.MONTH);
//            int day = cal.get(Calendar.DAY_OF_MONTH);
            return f.format(date);
        }
        else
        {
            return "";
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getConscious()
    {
        return conscious;
    }

    public void setConscious(String conscious)
    {
        this.conscious = conscious;
    }

    public String getEpileptic()
    {
        return epileptic;
    }

    public void setEpileptic(String epileptic)
    {
        this.epileptic = epileptic;
    }

    public String getConsciousAdd()
    {
        return consciousAdd;
    }

    public void setConsciousAdd(String consciousAdd)
    {
        this.consciousAdd = consciousAdd;
    }

    public String getProfission()
    {
        return profission;
    }

    public void setProfission(String profission)
    {
        this.profission = profission;
    }

    public List getCranicalNerve()
    {
        return cranicalNerve;
    }

    public void setCranicalNerve(List cranicalNerve)
    {
        this.cranicalNerve = cranicalNerve;
    }

    public List getNervousTension()
    {
        return nervousTension;
    }

    public void setNervousTension(List nervousTension)
    {
        this.nervousTension = nervousTension;
    }

    public List getMotion()
    {
        return motion;
    }

    public void setMotion(List motion)
    {
        this.motion = motion;
    }

    public List getMuscle()
    {
        return muscle;
    }

    public void setMuscle(List muscle)
    {
        this.muscle = muscle;
    }

    public List getRomberg()
    {
        return romberg;
    }

    public void setRomberg(List romberg)
    {
        this.romberg = romberg;
    }

    public String getPelvicOrgan()
    {
        return pelvicOrgan;
    }

    public void setPelvicOrgan(String pelvicOrgan)
    {
        this.pelvicOrgan = pelvicOrgan;
    }

    public List getRecommendations()
    {
        return recommendations;
    }

    public void setRecommendations(List recommendations)
    {
        this.recommendations = recommendations;
    }

    public String getRecommendationsAdd()
    {
        return recommendationsAdd;
    }

    public void setRecommendationsAdd(String recommendationsAdd)
    {
        this.recommendationsAdd = recommendationsAdd;
    }

    public Map<String, String> getParametersMap()
    {
        Map elements = new HashMap();
        Field fld[] = Visit.class.getDeclaredFields();

        for (Field field : fld)
        {
            String fieldName = field.getName();
            String fieldValue = "";
            ArrayList<String> fieldValueArray = new ArrayList();
            LinkedList<String> fieldValueList = new LinkedList();
            try
            {
                String typeName = field.getType().getName();
                if (typeName.equals(Logger.class.getName()))
                {
                    continue;
                }
                else
                    if (fieldName.equals("date"))
                    {
                        fieldValue = getStringDate();
                    }
                else if (fieldName.equals("coordinationTest"))
                {
                    log.info("coordinationTest");
                }
                 else if (typeName.equals(List.class.getName()))
                {
                                System.out.println("name=" + fieldName);
                                fieldValueArray = (ArrayList) field.get(this);
                }
                    else if (typeName.equals(LinkedList.class.getName()))
                    {
                        fieldValueList = (LinkedList) field.get(this);
                    }                        
                    else
                    {

                        fieldValue = (String) field.get(this);
                        //   fieldValue = fld[i].get(fieldName).toString();
                    }
                
            }
            catch (IllegalArgumentException ex)
            {
                Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IllegalAccessException ex)
            {
                Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (fieldValueArray.size() > 0)
            {
                for (String value : fieldValueArray)
                {
                    elements.put(fieldName, value);
                }
            }
            else if (fieldValueList.size() > 0)
            {
                for (String value : fieldValueList)
                {
                    elements.put(fieldName, value);
                }
            }
            else
            {
                elements.put(fieldName, fieldValue);
            }
        }

        return elements;
    }

    public void addDream(String dream)
    {
        this.dream.addFirst(dream);
    }

    public void addEmotion(String emotion)
    {
        this.emotion.add(0, emotion);
    }

    public void addNervousTension(String tension)
    {
        this.nervousTension.add(tension);
    }

    public void addPReflexes(String pReflex)
    {
        this.pReflexes.add(pReflex);
    }

    public void addAReflexes(String aReflex)
    {
        this.aReflexes.add(aReflex);
    }

//    public void addCoordination(String coordination)
//    {
//        this.coordination.add(coordination);
//    }
}
