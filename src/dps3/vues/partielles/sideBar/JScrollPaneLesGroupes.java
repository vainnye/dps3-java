package dps3.vues.partielles.sideBar;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dps3.controleurs.Controleur;
import dps3.modeles.Decideur;
import dps3.modeles.Groupe;
import dps3.utils.ui.GBL;
import dps3.vues.interfaces.IVue;

public class JScrollPaneLesGroupes extends JScrollPane implements IVue {
    JPanel jp_lesGroupes = new JPanel(new GridBagLayout());
    
    Decideur modele;

    public JScrollPaneLesGroupes(Decideur modele) {
        super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        this.modele = modele;
        
        setViewportView(jp_lesGroupes);
        
        setBorder(null);
    
        setOpaque(false);
        getViewport().setOpaque(false);
        jp_lesGroupes.setOpaque(false);
        
        // ----------------------------
        // ajout de tous les composants
        // ----------------------------
        setListeGroupes();

    }

    private void setListeGroupes() {
        ArrayList<Groupe> groupes = modele.getGroupesDeDecision();
        
        // Pour débugger, décommentez les lignes suivantes
        // --------------------------------------------
        // groupes = new ArrayList<Groupe>();
        // groupes.add(new Groupe("groupe x"));
        // groupes.add(new Groupe("groupe y"));
        // groupes.add(new Groupe("groupe z"));
        // groupes.add(new Groupe("groupe z"));
        // groupes.add(new Groupe("groupe z"));
        // groupes.add(new Groupe("groupe z"));
        // groupes.add(new Groupe("groupe z"));
        // groupes.add(new Groupe("groupe z"));


        GridBagConstraints c;
        c = GBL.getConstraint(0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 0, 5, 0);
        c.weightx = 1;
        
        for (int i=0; i<groupes.size(); i++) {
            c.gridy = i;
            
            JPanelPetitGroupe jp_groupe = new JPanelPetitGroupe(
                Controleur.getOrCreateFrom(groupes.get(i))
                );
            
            jp_lesGroupes.add(jp_groupe, c);
        }

        c.insets = new Insets(0, 0, 0, 0);
        c.gridy++; 
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        JPanel jp_filler = new JPanel();
        jp_filler.setOpaque(false);
        jp_lesGroupes.add(jp_filler, c);
    }

    @Override
    public void update() {
        setListeGroupes();
    }
}
