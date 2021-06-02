/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.ejb;


import javax.ejb.Stateless;


/**
 *
 * @author Jason S. Tomlins <jason@auscert.org.au>
 * This bean DOES NOT HAVE JSF scope, just other CDI beans
 */
@Stateless
public class GreetingsEJB {

    private String greeting;
    
    public GreetingsEJB() {
        greeting = "GreetingsEJB says, hello ya'll";
    }
    
    public String getGreeting() {
        return greeting;
    }
    
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    
    
}
