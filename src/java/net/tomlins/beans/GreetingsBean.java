/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.beans;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;



/**
 *
 * @author Jason S. Tomlins <jason@auscert.org.au>
 * This bean has scope in JSF pages - see import statement
 */
@Named
@RequestScoped
public class GreetingsBean {

    private String greeting;
    
    public GreetingsBean() {
        greeting = "GreetingsBeans says, Hello world";
    }
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    
}
