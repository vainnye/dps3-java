package dps3.utils.ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBL {
    public static GridBagConstraints getConstraint(int gridx, int gridy) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;

        return c;
    }

    public static GridBagConstraints getConstraint(int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints c = getConstraint(gridx, gridy);
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        return c;
    }

    public static GridBagConstraints getConstraint(int gridx, int gridy, int gridwidth, int gridheight, int ipadx, int ipady) {
        GridBagConstraints c = getConstraint(gridx, gridy, gridwidth, gridheight);
        c.ipadx = ipadx;
        c.ipady = ipady;
        return c;
    }

    public static GridBagConstraints getConstraint(GridBagConstraints c, int fill, int anchor) {
        c.fill = fill;
        c.anchor = anchor;
        return c;
    }

    public static GridBagConstraints getConstraint(GridBagConstraints c, Insets insets) {
        c.insets = insets;
        return c;
    }

    public static GridBagConstraints getConstraint(GridBagConstraints c, int fill, int anchor, Insets insets) {
        c.fill = fill;
        c.anchor = anchor;
        c.insets = insets;
        return c;
    }

    public static Insets getInsets(int vertical, int horizontal) {
        return new Insets(vertical, horizontal, vertical, horizontal);
    }

    public static Insets getInsets(int i) {
        return new Insets(i, i, i, i);
    }
}
