/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Jason S. Tomlins <jason@auscert.org.au>
 */
@Named(value = "imagesView")
@Dependent
public class ImagesView {

    /**
     * Creates a new instance of ImagesView
     */
private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add("image_" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
    public String onClick() {
        System.out.println("Image clicked");
        return "welcomePrimeFaces";
    }
}
