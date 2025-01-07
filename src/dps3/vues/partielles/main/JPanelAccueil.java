package dps3.vues.partielles.main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import dps3.App;
import dps3.utils.SwingTB;
import dps3.utils.Layouts.GBL;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JPanelAccueil extends JPanelRound {
    private static final String TITRE_PAGE = "Bienvenue sur la plateforme de décision de DPS3";
    private static final String MESSAGE_TUTO = "Vous trouverez ci contre les groupes dont vous êtes nommé décideur, si un groupe pour lequel vous prenez des decisions n’apparait pas, nous vous invitons a contacter l’administrateur de ce dernier";
    
    // TODO : peut-être changer pour JTextPane plutôt que JTextArea, pour des raisons de mise en forme de texte, de liens, d'affichage, etc
    // update : j'ai essayé, ça ne fait à chqua fois qu'à moitié les choses, soit ça affiche correctement le texte centré mais sans la bonne police, soit ça affiche le texte avec la bonne police mais pas centré et sans retour à la ligne
    private JTextArea jta_titrePage = new JTextArea(TITRE_PAGE);
    private JTextArea jta_messageTuto = new JTextArea(MESSAGE_TUTO);

    public JPanelAccueil() {
        setLayout(new GridBagLayout());
        GridBagConstraints c;

        setRounds(40);
        setBackground(App.COLOR_GREEN);
        
        // TODO: essayer de centrer le texte (text-align: center;)
        jta_titrePage.setForeground(Color.WHITE);
        jta_titrePage.setFont(App.FONT_H1);
        jta_titrePage.setOpaque(false);
        jta_titrePage.setLineWrap(true);
        jta_titrePage.setWrapStyleWord(true);

        // rendre jta_titrePage, non sélectionnable
        jta_titrePage.setEditable(false);
        jta_titrePage.getCaret().deinstall(jta_titrePage);
        jta_titrePage.setHighlighter(null);


        jta_messageTuto.setForeground(Color.WHITE);
        jta_messageTuto.setFont(App.FONT_PARAGRAPH);
        SwingTB.setFontSize(30, jta_messageTuto);
        jta_messageTuto.setOpaque(false);
        jta_messageTuto.setLineWrap(true);
        jta_messageTuto.setWrapStyleWord(true);

        // rendre jta_messageTuto, non sélectionnable
        jta_messageTuto.setEditable(false);
        jta_messageTuto.getCaret().deinstall(jta_messageTuto);
        jta_messageTuto.setHighlighter(null);
        

        c = GBL.getConstraint(0, 0);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.insets = GBL.getInsets(20);
        add(jta_titrePage, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 1;
        c.weighty = 1;
        c.insets = GBL.getInsets(200);
        add(jta_messageTuto, c);
    }
}
