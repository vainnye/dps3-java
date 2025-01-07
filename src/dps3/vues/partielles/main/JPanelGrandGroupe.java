package dps3.vues.partielles.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import dps3.App;
import dps3.modeles.Groupe;
import dps3.utils.Layouts.GBL;
import dps3.vues.partielles.reutilisables.JButtonRound;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JPanelGrandGroupe extends JPanelRound {
    // TODO : peut-être changer pour JTextPane plutôt que JTextArea, pour des raisons de mise en forme de texte, de liens, d'affichage, etc
    private JTextArea jta_nomGroupe;
    private JPanelRound jp_vue;

    public JPanelGrandGroupe(Groupe groupe) {
        setLayout(new GridBagLayout());
        GridBagConstraints c;

        setBackground(App.COLOR_GREEN);
        setRounds(40);

        jta_nomGroupe = new JTextArea(groupe.getNomGroupe());
        jta_nomGroupe.setOpaque(false);
        jta_nomGroupe.setLineWrap(true);
        jta_nomGroupe.setWrapStyleWord(true);
        jta_nomGroupe.setFont(App.FONT_H1);
        jta_nomGroupe.setForeground(Color.WHITE);
        
        // rendre jta_nomGroupe, non sélectionnable
        jta_nomGroupe.setEditable(false);
        jta_nomGroupe.getCaret().deinstall(jta_nomGroupe);
        jta_nomGroupe.setHighlighter(null);
        
        
        
        c = GBL.getConstraint(0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = new Insets(20, 20, 20, 20);
        add(jta_nomGroupe, c);

        
        JPanel jp_actionBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jp_actionBar.setOpaque(false);
        JButtonRound jb_estimer = new JButtonRound("Estimer");
        JButtonRound jb_decider = new JButtonRound("Décider");
        
        jb_estimer.setRounds(40, 0, 0, 40);
        jb_decider.setRounds(0, 40, 40, 0);
        // jb_estimer.setColors(, getBackground());
        jp_actionBar.add(jb_estimer);
        jp_actionBar.add(jb_decider);
        c = GBL.getConstraint(0, 1);
        c.fill = GridBagConstraints.BOTH;
        c.insets = GBL.getInsets(20, 0);
        c.weightx = 1;
        add(jp_actionBar, c);

        c = GBL.getConstraint(0, 2);
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        JButtonRound btn = new JButtonRound("tttttttt");
        btn.setRounds(20);
        c.insets = new Insets(0, 20, 20,20);
        add(btn, c);
        
        jp_vue = new JPanelRound();
        jp_vue.setRounds(getRoundTopLeft());
        jp_vue.setBackground(Color.LIGHT_GRAY);
        c = GBL.getConstraint(0, 1, 1, 2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        add(jp_vue, c);
    }
}
