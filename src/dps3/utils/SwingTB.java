package dps3.utils;

import javax.swing.JComponent;

// TB pour ToolBox
public class SwingTB {
    public static void setFontSize(int size, JComponent ... comps) {
        setFontSize((float)size, comps);
    }
    
    public static void setFontSize(float size, JComponent ... comps) {
        for (JComponent c : comps) {
            c.setFont(c.getFont().deriveFont(size));
        }
    }
}
