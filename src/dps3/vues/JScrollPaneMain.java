package dps3.vues;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dps3.utils.ui.GBL;
import dps3.vues.partielles.reutilisables.JPanelRound;

public class JScrollPaneMain extends JScrollPane {
    private JPanelRound jp_centered;
    private JPanel viewportViewPanel;

    public JScrollPaneMain(JPanelRound panel) {
        super(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp_centered = panel;

        viewportViewPanel = new JPanel(new GridBagLayout());
        setViewportView(viewportViewPanel);
        
        viewportViewPanel.setBackground(Color.WHITE);
        
        setBorder(null);

        setOpaque(false);
        
        GridBagConstraints c = GBL.getConstraint(0, 0);
        c.fill = GridBagConstraints.BOTH;
        c.insets = GBL.getInsets(80);
        c.weightx = 1;
        c.weighty = 1;
        
        viewportViewPanel.add(jp_centered, c);
    }

    public void setJPanelCentered(JPanelRound newPanel) {
        GridBagConstraints c;
        c = (GridBagConstraints)((GridBagLayout)viewportViewPanel.getLayout()).getConstraints(jp_centered).clone();
        viewportViewPanel.remove(jp_centered);

        jp_centered = newPanel;
        viewportViewPanel.add(newPanel, c);
        
        // EXTRÊMEMENT IMPORTANT POUR QUE L'INTERFACE SE METTE À JOUR
        revalidate();
        repaint();
    }
}
