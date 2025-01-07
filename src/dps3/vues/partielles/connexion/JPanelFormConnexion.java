package dps3.vues.partielles.connexion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dps3.App;
import dps3.config.Connexion;
import dps3.controleurs.CApp;
import dps3.utils.Layouts.GBL;
import dps3.vues.partielles.reutilisables.JButtonRound;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JPanelFormConnexion extends JPanelRound {
    private JButtonRound jb_valider = new JButtonRound("Se connecter");
    private JTextField jtf_userId = new JTextField(15);
    private JPasswordField jpf_userPsw = new JPasswordField(15);

    private JLabel jl_titre = new JLabel("Connexion");
    private JLabel jl_userId = new JLabel("Email ou Nom d'utilisateur");
    private JLabel jl_userPsw = new JLabel("Mot de passe");

    public JPanelFormConnexion() {
        jb_valider.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String login = jtf_userId.getText();
                String pass = new String(jpf_userPsw.getPassword());
                if(login.length()>0 && pass.length()>0) {
                    jtf_userId.setText("");
                    jpf_userPsw.setText("");
                    if(Connexion.connecterDecideur(login, pass)) {
                        CApp.afficherAccueil();
                    }
                }
            }
            
        });



        setLayout(new GridBagLayout());
        GridBagConstraints c;

        setRounds(40, 40, 40, 40);
        
        setBackground(Color.GRAY);
        
        setMaximumSize(new Dimension(400, 500));

        jl_titre.setFont(App.FONT_H1);

        jl_userId.setFont(App.FONT_SPAN);

        jl_userPsw.setFont(App.FONT_SPAN);
        
        jb_valider.setFont(App.FONT_BUTTON);
        jb_valider.setBackgroundColor(Color.WHITE);
        jb_valider.setActiveColor(Color.LIGHT_GRAY);
        jb_valider.setRounds(40, 40, 40, 40);
        // ---------------------
        // tout ajouter au panel
        // ---------------------
        c = GBL.getConstraint(0, 0, 2, 1);
        c.insets = new Insets(0, 0, 10, 0);
        c.anchor = GridBagConstraints.LINE_START;
        add(jl_titre, c);

        c = GBL.getConstraint(0, 1);
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.LINE_START;
        add(jl_userId, c);

        c = GBL.getConstraint(1, 1);
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        add(jtf_userId, c);

        c = GBL.getConstraint(0, 2);
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.LINE_START;
        add(jl_userPsw, c);

        c = GBL.getConstraint(1, 2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        add(jpf_userPsw, c);
        
        c = GBL.getConstraint(0, 3, 2, 1);
        c.insets = new Insets(10, 0, 0, 0);
        add(jb_valider, c);
    }
}