/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import java.util.Date;

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

    public String getComplaine() {
        return complaine;
    }

    public void setComplaine(String complaine) {
        this.complaine = complaine;
    }

    public String getSocialAnamnesis() {
        return socialAnamnesis;
    }

    public void setSocialAnamnesis(String socialAnamnesis) {
        this.socialAnamnesis = socialAnamnesis;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getStringDate()
    {
        return date.toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
