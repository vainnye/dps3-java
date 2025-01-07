package dps3;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import dps3.config.Myfonts;
import dps3.controleurs.CApp;
import dps3.modeles.Decideur;
import dps3.modeles.Groupe;

public class App {
    public static final String NAME = "DPS3 Décideur";
    public static final String LOGO_PATH = "media/logo.png";
    public static final String DFT_PFP_PATH = "media/profilepic.png";
    
    public static final Color COLOR_BLUE = new Color(93, 145, 188); 
    public static final Color COLOR_GREEN = new Color(52, 95, 41);

    public static final Font FONT_H1 = new Font("Josefin Sans Bold", Font.PLAIN, 40);
    public static final Font FONT_H2 = new Font("Josefin Sans Bold", Font.PLAIN, 30);
    public static final Font FONT_BUTTON =  new Font("Istok Web Bold", Font.PLAIN, 20);
    public static final Font FONT_PARAGRAPH = new Font("Istok Web Bold", Font.PLAIN, 15);
    public static final Font FONT_SPAN = new Font("Istok Web Bold", Font.PLAIN, 15);
    
    private static Decideur decideur = null; // l'utilisateur courant

    public static void setDecideur(Decideur decideur) {
        App.decideur = decideur;
    }

    public static Decideur getDecideur() {
        return decideur;
    }

    public static void main(String[] args) throws Exception {
        // permet d'utiliser les fonts ajoutées dans le fichier
        Myfonts.initialize();

        ArrayList<Groupe> groupes = new ArrayList<Groupe>();
        groupes.add(new Groupe("groupe x"));
        groupes.add(new Groupe("groupe y"));
        groupes.add(new Groupe("groupe z"));
        groupes.add(new Groupe("groupe z"));
        groupes.add(new Groupe("groupe z"));
        groupes.add(new Groupe("groupe z"));
        groupes.add(new Groupe("groupe z"));
        groupes.add(new Groupe("groupe z"));

        App.setDecideur(new Decideur("https://chat-gpt.org/assets/img/chatgpt.png", groupes));

        // ajuster tous les composants au Look & Feel du système d'exloitation actuel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }

        // parce que JFrame n'est pas thread safe, 
        // il faut utiliser le tricks suivant pour tout run dans le même thread
        // (pour que tout s'affiche en même temps)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CApp.lancerApp();
                
            }
        });
    }
    
}
