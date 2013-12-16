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
public class Person
{
    private String name;
    private Date date;
    private String complaine;
    private String socialAnamnesis;

    public Person()
    {
    }
    
    public Person(String name, Date date)
    {
        this.name = name;
        this.date = date;
    }
    
}
