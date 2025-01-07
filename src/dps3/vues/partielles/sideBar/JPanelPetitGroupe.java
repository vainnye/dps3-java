package dps3.vues.partielles.sideBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.HierarchyEvent;

import javax.swing.SwingConstants;

import dps3.App;
import dps3.controleurs.CApp;
import dps3.controleurs.CGroupe;
import dps3.vues.interfaces.IVueControlee;
import dps3.vues.partielles.main.JPanelGrandGroupe;
import dps3.vues.partielles.reutilisables.JButtonRound;
import dps3.vues.partielles.reutilisables.JPanelRound;

// cette classe étend la classe JPanel
// dans l'objectif d'un ajouter plus de composant plus tard :
// - icone du groupe
// - label avec nombre de membres
// - icone à côté de ce label 
//
// il faudra alors changer la comportement de cette classe
// pour que ce ne soit pas le bouton jb_nomGroupe qui génère l'événement


// TODO: ajouter un actionlistener au bouton pour qu'il interragisse avec les contrôleurs
public class JPanelPetitGroupe extends JPanelRound implements IVueControlee{
    private JButtonRound jb_nomGroupe = new JButtonRound();

    private CGroupe controleur;

    // TODO: modifier le contructeur en accord avec le design patern MVC (implémenter IVueControlee)
    public JPanelPetitGroupe(CGroupe controleur) {
        // implémentation de  IVueControlee
        this.controleur = controleur;
        controleur.ajouterVue(this);
        addHierarchyListener(this);

        jb_nomGroupe.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CApp.changerVue(JPanelGrandGroupe.class, controleur);
            }
            
        });

        

        // création de l'UI
        setLayout(new BorderLayout());
        setBackground(new Color(0,0,0,0));
        setOpaque(false);

        update();
        jb_nomGroupe.setFont(App.FONT_BUTTON);
        jb_nomGroupe.setRounds(20);
        jb_nomGroupe.setBackgroundColor(Color.WHITE);
        jb_nomGroupe.setActiveColor(Color.LIGHT_GRAY);
        jb_nomGroupe.setHorizontalAlignment(SwingConstants.LEFT);

        add(jb_nomGroupe, BorderLayout.CENTER);
    }

    
    // implémentation de IVueControlee
    @Override
    public void update() {
        this.jb_nomGroupe.setText(controleur.getModele().getNomGroupe());
    }

    // implémentation de IVueControlee
    @Override
    public void hierarchyChanged(HierarchyEvent e) {
        if(e.getChangeFlags() == HierarchyEvent.PARENT_CHANGED) {
            if(this.getParent() == null)
                this.controleur.retirerVue(this);
            else
                this.controleur.ajouterVue(this);
        }
    }
    
}
