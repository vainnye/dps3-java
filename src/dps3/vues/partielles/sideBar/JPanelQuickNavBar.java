package dps3.vues.partielles.sideBar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;

import dps3.App;
import dps3.modeles.Decideur;
import dps3.vues.interfaces.IVue;
import dps3.vues.partielles.reutilisables.JLabelImage;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JPanelQuickNavBar extends JPanelRound implements IVue {
    private static final Dimension IMG_SIZE = new Dimension(100, 100);
    private JLabelImage jli_logo = new JLabelImage(App.LOGO_PATH);
    private JLabelImage jli_profil = new JLabelImage(Decideur.DFT_PFP_PATH);

    private Decideur modele;

    public JPanelQuickNavBar(Decideur modele) {
        super();
        this.modele = modele;

        setRounds(40, 40, 40, 40);
        setBackground(Color.WHITE);

        
        
        setJli_profil();
        jli_logo.setImageSize(IMG_SIZE);
        
        // TODO : faire un masque autour de la photo de profil pour qu'elle soit toujours ronde

        add(jli_logo);
        add(jli_profil);
    }

    private void setJli_profil() {
        try {
            // TODO: attendre le chargement complet de la photo de profil avec java.awt.MediaTracker

            ImageIcon pfpReelle = new ImageIcon(modele.getLienPhotoProfil());

            // ImageIcon pfpReelle = new ImageIcon(modele.getLienPhotoProfil());
            // si pfpReelle a été créée avec succès, elle remplace la photo de profil par défaut
            jli_profil.setIcon(pfpReelle);
        }catch(Exception e) {
            jli_profil = new JLabelImage(Decideur.DFT_PFP_PATH);
        }
        
        jli_profil.setImageSize(IMG_SIZE);
    }

    @Override
    public void update() {
        setJli_profil();
    }

}
