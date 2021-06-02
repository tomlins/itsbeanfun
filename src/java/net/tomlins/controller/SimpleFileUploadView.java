/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tomlins.controller;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class SimpleFileUploadView implements Serializable {

    private UploadedFile file;
    private StreamedContent uploadedImage;

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public StreamedContent getUploadedImage() {
        if (file == null) {
            return null;
        }
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
            return new DefaultStreamedContent();
        }
        return uploadedImage;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage("messages", message);
            uploadedImage = new DefaultStreamedContent(new ByteArrayInputStream(file.getContents()), file.getContentType());
        }
    }

}
