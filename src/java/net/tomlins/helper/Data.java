/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.helper;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import net.tomlins.model.Colors;

/**
 *
 * @author Jason S. Tomlins <jason@auscert.org.au>
 */
@Named
@ApplicationScoped
public class Data {
    
    public Data() {}

    public Colors[] getColors() {
        return Colors.values();
    }
    
}
