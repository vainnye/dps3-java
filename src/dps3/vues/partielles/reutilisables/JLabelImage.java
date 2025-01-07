package dps3.vues.partielles.reutilisables;

import java.awt.Dimension;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelImage extends JLabel{
    private ImageIcon img = null; // the orginial image

    public JLabelImage() {
        super();
        img = null;
    }

    public JLabelImage(String filename) {
        setIcon(filename);
    }

    public JLabelImage(URI location) {
        setIcon(location);
    }

    public JLabelImage(URL location) {
        setIcon(location);
    }

    public void setIcon(String filename) {
        img = new ImageIcon(filename);
        setIcon(img);
    }

    public void setIcon(URI location) {
        if(location == null)
            throw new NullPointerException("l'url de l'image à télécharger ne peux pas être null");
        try {
            setIcon(location.toURL());
        }
        catch (MalformedURLException e) {
            System.err.println("L'url de l'image n'a pas pu être utilisée : "+e.getMessage());
        }
    }

    public void setIcon(URL location) {
        if(location == null)
            throw new NullPointerException("l'url de l'image à télécharger ne peux pas être null");
        img = new ImageIcon(location);
        setIcon(img);
    }

    public void setImageSize(Dimension dimension) {
        setImageSize((int)dimension.getWidth(), (int)dimension.getHeight());
    }

    public void setImageSize(int width, int height) {
        setIcon(scaleSmooth(width, height));
    }

    private ImageIcon scaleSmooth(int width, int height) {
        return new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    @SuppressWarnings("unused")
    private ImageIcon scaleFast(int width, int height) {
        return new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_FAST));
    }
}
