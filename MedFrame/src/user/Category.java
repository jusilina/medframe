/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import java.util.Set;

/**
 *
 * @author Julia
 */
public class Category
{
    Map drugs = new HashMap();
    String name;

    public Category(String name)
    {
        this.name = name;
//        drugs = new HashSet<Drug>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Category()
    {
//        drugs = new ArrayList<>();

    }



    public Map getDrugs()
    {
        return drugs;
    }

    public void setDrugs(Map drugs)
    {
        this.drugs = drugs;
    }
    
    public void addDrug(Drug drug)
    {
        drugs.put(drug.name, drug);
    }
    
    public void addDrug(String drugName)
    {
        
        drugs.put(drugName, new Drug(drugName));
    }

    public void addMarkForDrug(String thisDrug, String mark)
    {
       Drug drug = (Drug) drugs.get(thisDrug);
       drug.getMark().add(mark);
       
    }
    
}
