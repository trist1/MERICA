/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanIFTicateur.domaine.activite;

import java.awt.Color;

/**
 *
 * @author Alexandre
 */
public class CoursHorsDep extends Activite {

    private Color couleur = new Color(50, 255, 0, 50);
    private String type;

    public CoursHorsDep(String code, String section, String titre, String professeur, String type, double duree, double heureDebutMin, double heureFinMax, int jour, double heureDebut) {
        super(code, section, titre, professeur, type, duree, heureDebutMin, heureFinMax, jour, heureDebut);
        this.type = "Hors département";
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

      @Override
    public void setCouleurSelectionner() {
        this.couleur = new Color(192, 192, 192, 180); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reinitCouleur() {
        this.couleur = new Color(50, 255, 0, 50);    
    }

}
