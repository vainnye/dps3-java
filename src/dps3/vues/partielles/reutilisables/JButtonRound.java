package dps3.vues.partielles.reutilisables;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import dps3.App;
import dps3.vues.interfaces.RoundCorners;

public class JButtonRound extends JButton implements ChangeListener, RoundCorners{
    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;
    
    private Color backgroundColor = getBackground();
    private Color activeColor = getBackground().darker();
    private Color hoverColor = getBackground();

    // ----------
    // contructor
    // ----------
    
    public JButtonRound() {        
        initialize();
    }
    
    public JButtonRound(String text) {
        super(text);
        initialize();
    }

    private void initialize() {
        setFont(App.FONT_BUTTON);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addChangeListener(this);
    }

    // -------
    // getters
    // -------

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }
    
    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }
    
    // renvoie la couleur de bg par défaut
    // alors que getBackground() renvoie la couleur de bg actuelle
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public Color getHoverColor() {
        return hoverColor;
    }

    // -------
    // setters
    // -------
    
    public void setBackgroundColor(Color c) {
        backgroundColor = c;
        setBackground(c);
    }

    public void setActiveColor(Color c) {
        activeColor = c;
    }

    public void setHoverColor(Color c) {
        hoverColor = c;
    }

    public void setColors(Color bg, Color active) {
        setBackground(bg);
        activeColor = active;
    }

    public void setColors(Color bg, Color active, Color hover) {
        setBackground(bg);
        activeColor = active;
        hoverColor = hover;
    }

    public void setRounds(int roundCorner) {
        setRoundTopLeft(roundCorner);
        setRoundTopRight(roundCorner);
        setRoundBottomLeft(roundCorner);
        setRoundBottomRight(roundCorner);
    }

    public void setRounds(int topLeft, int topRight, int bottomRight, int bottomLeft) {
        setRoundTopLeft(topLeft);
        setRoundTopRight(topRight);
        setRoundBottomLeft(bottomLeft);
        setRoundBottomRight(bottomRight);
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        repaint();
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        repaint();
    }
    
    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        repaint();
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        repaint();
    }

    // ------------------------
    // ChangeListener overrides
    // ------------------------

    @Override
    public void stateChanged(ChangeEvent e) {
        if(model.isPressed())
            setBackground(activeColor);
        else
            setBackground(backgroundColor);
    }

    // -----------------
    // JButton overrides
    // -----------------

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        Area area = new Area(createRoundTopLeft());
        if (roundTopRight > 0) {
            area.intersect(new Area(createRoundTopRight()));
        }
        if (roundBottomLeft > 0) {
            area.intersect(new Area(createRoundBottomLeft()));
        }
        if (roundBottomRight > 0) {
            area.intersect(new Area(createRoundBottomRight()));
        }
        g2.fill(area);
        g2.dispose();
        super.paintComponent(grphcs);
    }

    // ---------------
    // private methods
    // ---------------

    private Shape createRoundTopLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = getWidth();
        int height = getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }
}