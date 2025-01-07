package dps3.vues;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dps3.utils.Layouts.GBL;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JScrollPaneMain extends JScrollPane {
    private JPanelRound jp_centered;

    public JScrollPaneMain(JPanelRound panel) {
        super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp_centered = panel;

        JPanel vpvPanel = new JPanel(new GridBagLayout());
        setViewportView(vpvPanel);
        
        vpvPanel.setBackground(Color.WHITE);
        
        setBorder(null);

        setOpaque(false);
        
        GridBagConstraints c = GBL.getConstraint(0, 0);
        c.fill = GridBagConstraints.BOTH;
        c.insets = GBL.getInsets(80);
        c.weightx = 1;
        c.weighty = 1;
        
        vpvPanel.add(jp_centered, c);
    }

    // public void setJPanelCentered(JPanelRound panel) {
    //     jp_centered = panel;
    // }
}
