package dps3.config;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;



/*
 * exemple d'utilisations :
 * jl_titre.setFont(new Font("Josefin Sans Bold", Font.PLAIN, 40));
 * jl_userId.setFont(new Font("Istok Web Bold", Font.PLAIN, 15));
 */


public class Myfonts{
    private static final File[] fontDirectories = 
    {
        new File("font\\Josefin_Sans\\static"),
        new File("font\\Istok_Web\\static")
    };
    private static Boolean isInitialized = false;
    
    public static void initialize() {
        if (isInitialized) return;

        for (File fontFolder : fontDirectories) {
            for (File fontFile : fontFolder.listFiles()) {
                if(fontFile.isDirectory()) continue;
                
                registerFont(fontFile);
            }
        }

        isInitialized = true;
    }

    private static void registerFont(File fontFile) {
        int filetype;
        String extension = "";
        int i = fontFile.getName().lastIndexOf('.');
        if (i > 0) {
            extension = fontFile.getName().substring(i+1);
        }

        if("ttf".equals(extension) || "tte".equals(extension) || "dfont".equals(extension))
            filetype = Font.TRUETYPE_FONT;
        else
            filetype = Font.TYPE1_FONT;

        try {
            Font font = Font.createFont(filetype, fontFile);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        }
        catch (Exception e) {}
    }
}
