/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanIFTicateur.domaine.cheminement;

import PlanIFTicateur.domaine.activite.Activite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tristandhumieres
 */
public class ListeGrillesCheminement {

    List<GrilleCheminement> grillesCheminement = new ArrayList<>();

    public ListeGrillesCheminement(List<GrilleCheminement> grilleCheminements) {
        this.grillesCheminement = grilleCheminements;
    }

    public ListeGrillesCheminement() {
    }

    public List<GrilleCheminement> getGrillesCheminement() {
        return grillesCheminement;
    }

    public List<Activite> activitesAuMemeHoraire(Activite activite) {
        List<Activite> activitesAuMemeHoraire = new ArrayList();
        grillesCheminement.stream().forEach((grilleCheminement) -> {
            activitesAuMemeHoraire.addAll(grilleCheminement.activitesAuMemeHoraire(activite));
        });
        return activitesAuMemeHoraire;
    }

    public List<Activite> activitesCheminementsDejaALHoraire(Activite activite) {
        List<Activite> activitesCheminement = new ArrayList<>();
        for (GrilleCheminement grilleCheminement : grillesCheminement) {
            activitesCheminement.addAll(grilleCheminement.activitesCheminementDejaAlHoraire(activite));
        }
        return activitesCheminement;
    }
}
