/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private String stress;
    private String anamnesis;
    private String emotion;
    private String dream;
    private String sensitivity;
    private String reflexes;
    private String pReflexes;
    private String aReflexes;
    private String gate;
    private String coordination;
    private String nervousSystem;
    private String diagnosis;
    private String recomendations;
    private String therapy;


    public String getEmotion()
    {
        return emotion;
    }

    public void setEmotion(String emotion)
    {
        this.emotion = emotion;
    }

    public String getDream()
    {
        return dream;
    }

    public void setDream(String dream)
    {
        this.dream = dream;
    }

    public String getSensitivity()
    {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity)
    {
        this.sensitivity = sensitivity;
    }

    public String getReflexes()
    {
        return reflexes;
    }

    public void setReflexes(String reflexes)
    {
        this.reflexes = reflexes;
    }

    public String getpReflexes()
    {
        return pReflexes;
    }

    public void setpReflexes(String pReflexes)
    {
        this.pReflexes = pReflexes;
    }

    public String getaReflexes()
    {
        return aReflexes;
    }

    public void setaReflexes(String aReflexes)
    {
        this.aReflexes = aReflexes;
    }

    public String getGate()
    {
        return gate;
    }

    public void setGate(String gate)
    {
        this.gate = gate;
    }

    public String getCoordination()
    {
        return coordination;
    }

    public void setCoordination(String coordination)
    {
        this.coordination = coordination;
    }

    public String getNervousSystem()
    {
        return nervousSystem;
    }

    public void setNervousSystem(String nervousSystem)
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

    public String getRecomendations()
    {
        return recomendations;
    }

    public void setRecomendations(String recomendations)
    {
        this.recomendations = recomendations;
    }

    public String getTherapy()
    {
        return therapy;
    }

    public void setTherapy(String therapy)
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
            return date.toString();
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

    public Map<String, String> getParametersMap()
    {
        Map elements = new HashMap();
        Field fld[] = Visit.class.getDeclaredFields();
        for (int i = 0; i < fld.length; i++)
        {
            Field field = fld[i];
            String fieldName = field.getName();
            String fieldValue = "";
            if (fieldName.equals("date"))
            {
                fieldValue = getStringDate();
            }
            else
            {
                try
                {
                    fieldValue = (String)field.get(this);
                 //   fieldValue = fld[i].get(fieldName).toString();
                }
                catch (IllegalArgumentException ex)
                {
                    Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (IllegalAccessException ex)
                {
                    Logger.getLogger(Visit.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            elements.put(fieldName, fieldValue);
        }

        return elements;
    }
}
