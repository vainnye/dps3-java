package dps3.vues;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import dps3.App;
import dps3.controleurs.CDecideur;
import dps3.vues.partielles.main.JPanelAccueil;

public class JFrameApp extends JFrame {
    public static final String WINDOW_TITLE = App.NAME;

    private ArrayList<JComponent> vuesActives = new ArrayList<>();

    public JFrameApp() {
        super(WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Image favIcon = ImageIO.read(new File(App.LOGO_PATH));
            setIconImage(favIcon);
        }
        catch (Exception e) {}
        
        setHalfScreenSize();
        setCentered();
        
        // pour permettre de cacher la sidebar en fonction de la taille de la fenêtre
        // JFrameAppListener est une classe interne à JFrameApp (voir plus bas)
        addComponentListener(new JFrameAppListener()); 
    }

    public List<JComponent> getVuesActives() {
        return vuesActives;
    }


    public void setHalfScreenSize() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension fsize = new Dimension((int)screen.getWidth()/2, (int)screen.getHeight()/2);

        setSize(fsize);
        setMinimumSize(fsize);
        setPreferredSize(fsize);
        setMaximumSize(screen); 
    }

    public void setFullScreen() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void setCentered() {
        setLocationRelativeTo(null); 
    }

    
    public void reset() {
        this.vuesActives.clear();

        // nota : le contentpane est un panel qui est par défaut dans un jframe
        getContentPane().removeAll();

        // si des problèmes dans le futur, décommenter les lignes suivantes :
        getContentPane().revalidate();
        getContentPane().repaint();
    }


    public void afficher() {
        setVisible(true);
    }


    public void afficherConnexion() {
        reset();
        JPanelConnexion jp = new JPanelConnexion();
        vuesActives.add(jp);
        add(jp, BorderLayout.CENTER);
    }

    public void afficherAccueil() {
        reset();
        CDecideur ctl = CDecideur.getOrCreateFrom(App.getDecideur());
        JPanelSideBar jp = new JPanelSideBar(ctl);
        vuesActives.add(jp);
        add(jp, BorderLayout.WEST);

        // Groupe groupe = new Groupe("Un Nouveau groupe de plus qui fait vachement chier le monde j'en ai marre");
        // JScrollPaneMain mainPanel = new JScrollPaneMain(new JPanelGrandGroupe(groupe));
        JScrollPaneMain mainPanel = new JScrollPaneMain(new JPanelAccueil());
        vuesActives.add(mainPanel);
        add(mainPanel, BorderLayout.CENTER);
    }


        
    // j'ai créé une classe interne privée à  AppWindow car les méthodes de ComponentListener sont forcément publiques 
    // et je ne veux pas qu'elles soients accessibles par d'autres classes que AppWindow
    private class JFrameAppListener implements ComponentListener {
        @Override
        public void componentResized(ComponentEvent e) {
            // ------------------------------------------------------------------------------
            // cache la barre latérale quand la largeur de la fenêtre est inférieure à 800px
            // ------------------------------------------------------------------------------

            /* UPDATE:
            * ça fonctione très bien mais on verra le responsive plus tard
            * ne s'attardons pas sur cela
            * (décommentez les lignes suivantes pour tester)
            */

            // Component[] components = frame.getContentPane().getComponents();
            
            // for (Component c : components) {
            //     if(c instanceof JPanelSideBar) {
            //         // afficher la sidebar dans tous les cas en fullscreen
            //         if(frame.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
            //             c.setVisible(true);
            //             return;
            //         }
    
            //         // cacher la sidebar si la largeur de la fenêtre <= 800 (si la fenêtre n'est pas en fullscreen)
            //         if(frame.getSize().width > 800) {
            //             c.setVisible(true);
            //             return;
            //         }
            //         else {
            //             c.setVisible(false);
            //             return;
            //         }
            //     }
            // }
        }
    
        @Override
        public void componentMoved(ComponentEvent e) {
        }
        
        @Override
        public void componentShown(ComponentEvent e) {
        }
        
        @Override
        public void componentHidden(ComponentEvent e) {
        }
    }
}