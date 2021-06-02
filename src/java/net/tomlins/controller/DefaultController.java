/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.controller;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import net.tomlins.beans.GreetingsBean;
import net.tomlins.ejb.GreetingsEJB;
import net.tomlins.ejb.PersonFacade;
import net.tomlins.entities.Person;

/**
 *
 * @author Jason S. Tomlins <jason@auscert.org.au>
 * This bean has JSF scope, see import statements
 *
 */
@Named
@RequestScoped
public class DefaultController {

    /* Inject an EJB */
    @EJB
    GreetingsEJB greetingsEJB;

    /* We can also inject faces scoped bean */
    @Inject
    GreetingsBean greetingsBean;

    @Enumerated(EnumType.STRING)
    private String color;
    
    @EJB
    PersonFacade personFacade;

    public DefaultController() {
        color = "Red";
    }

    public String sayHelloEJB() {
        return "From the DefaultController, " + greetingsEJB.getGreeting();
    }

    public String sayHelloBean() {
        return "From the DefaultController, " + greetingsBean.getGreeting();
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    public void onColorChange() {
        Person person = new Person();
        person.setName(getColor());
        personFacade.create(person);

        System.out.println("event fired. The component is now " + getColor());
    }

}
