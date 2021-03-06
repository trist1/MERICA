/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlanIFTicateur.domaine.activite;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author Alexandre
 */
public class ListeActivites {

    private List<Activite> listeActivites = new ArrayList<>();

    public ListeActivites(List<Activite> listeActivites) {
        this.listeActivites = listeActivites;
    }

    public ListeActivites() {
    }

    public List<Activite> getListeActivites() {
        return listeActivites;
    }

    public int getTailleListeActivites() {
        return listeActivites.size();
    }

    public Activite getActiviteByCode(String code) {
        Activite act = null;
        for (Activite activite : listeActivites) {

            if (activite.getCode().toUpperCase().equals(code.toUpperCase())) {
                act = activite;
            }
        }

        return act;
    }

    public List<Activite> getActivitesByJour(int jour) {
        List<Activite> activites = new ArrayList<>();
        for (Activite activite : listeActivites) {
            if (activite.getJour() == jour) {
                activites.add(activite);
            }
        }
        return activites;
    }

    public List<Activite> getActivitesNonAssignees() {
        return listeActivites.stream().filter(x -> !x.isAssignee()).collect(Collectors.toList());
    }

    public List<Activite> getActivitesAssignees() {
        return listeActivites.stream().filter(x -> x.isAssignee()).collect(Collectors.toList());
    }

    public void modifierStatutSelectionActivite(int x, int y) {
        listeActivites.stream().forEach((activite) -> {
            activite.modifierStatutSelection(x, y);
        });
    }

    public void setCoordonneesActivites(Dimension dimension) {
        for (Activite activite : listeActivites) {
            activite.setDimension(dimension);
            if (activite.isAssignee()) {
                activite.setPoint(dimension);
            }
        }
    }

    public Optional<Activite> getActiviteSelectionnee() {
        return listeActivites.stream().filter(x -> x.isSelected()).findFirst();
    }

    public void setActivitesANonSlectionnee() {
        listeActivites.stream().forEach((activite) -> {
            activite.setIsSelected(false);
        });
    }

    public void ajouterActivite(Activite activite) {
        listeActivites.add(activite);
    }

    public Activite getActiviteFiniPlusTard() {
        Activite activitePlusTard = null;
        double heureFin = 0;
        List<Activite> activiteList = getListeActivites();
        for (Activite activite : activiteList) {
            if (activite.getHeureDebut() != 0.0d && activite.getHeureDebut() + activite.getDuree() > heureFin) {
                activitePlusTard = activite;
                heureFin = activite.getHeureDebut();
            }
        }
        return activitePlusTard;
    }

    public Activite activitePlusTot() {
        Activite activitePlusTot = null;
        double heureDebut = 22;
        List<Activite> activiteList = getListeActivites();
        for (Activite activite : activiteList) {
            if (activite.getHeureDebut() != 0.0d && activite.getHeureDebut() < heureDebut) {
                activitePlusTot = activite;
                heureDebut = activite.getHeureDebut();
            }
        }
        return activitePlusTot;
    }
}
