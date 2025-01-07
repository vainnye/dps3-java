package dps3.utils.debug;

import java.awt.Component;

public class ComponentDebug {
    private ComponentDebug() {} 
    
    public static void printSizes(Component c, String paramName) {
        System.out.println("Les dimensions de "+paramName+" sont :");
        System.out.println("Size: "+c.getSize());
        System.out.println("MinSize: "+c.getMinimumSize());
        System.out.println("PrefSize: "+c.getPreferredSize());
        System.out.println("MaxSize: "+c.getMaximumSize());
        System.out.println();
    }
}
