package dps3.vues;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.HierarchyEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import dps3.App;
import dps3.controleurs.CDecideur;
import dps3.utils.Layouts.GBL;
import dps3.vues.interfaces.IVue;
import dps3.vues.interfaces.IVueControlee;
import dps3.vues.partielles.sideBar.JPanelQuickNavBar;
import dps3.vues.partielles.sideBar.JScrollPaneLesGroupes;

public class JPanelSideBar extends JPanel implements IVueControlee {
    JPanelQuickNavBar jp_quickNavBar;
    JLabel jl_titre = new JLabel("Groupes de Décision");
    JScrollPaneLesGroupes jsp_lesGroupes;

    CDecideur controleur;

    public JPanelSideBar(CDecideur ctl) {
        super();
        controleur = ctl;
        controleur.ajouterVue(this);
        addHierarchyListener(this);
        
        jp_quickNavBar = new JPanelQuickNavBar(controleur.getModele());
        jsp_lesGroupes = new JScrollPaneLesGroupes(controleur.getModele());
        

        setLayout(new GridBagLayout());
        GridBagConstraints c;
        
        setBackground(App.COLOR_BLUE);

        jl_titre.setFont(App.FONT_H2);
        jl_titre.setForeground(Color.WHITE);

        // ajout de tous les composants
        c = GBL.getConstraint(0, 0);
        c.insets = new Insets(10, 10, 10, 10);
        add(jp_quickNavBar, c);

        c.gridy = 1;
        add(jl_titre, c);

        c.gridy = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        add(jsp_lesGroupes, c);

        // le dernier Panel sert à remplir l'espace restant
        // cela permet de coller tous les composants en haut
        c.gridy = 3;
        c.weighty = 0.25;
        JPanel jp_filler = new JPanel();
        jp_filler.setOpaque(false);
        add(jp_filler, c);
    }

    @Override
    public void update() {
        ((IVue)jp_quickNavBar).update();
        ((IVue)jsp_lesGroupes).update();
    }

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
