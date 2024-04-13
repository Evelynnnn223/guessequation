package guessequation.view;

import javax.imageio.ImageIO;
import javax.swing.*;  
import javax.swing.plaf.basic.BasicTabbedPaneUI;  
import java.awt.*;
import java.io.File;
import java.io.IOException;  

//Set the display effect of tabs
public class CustomTabbedPaneUI extends BasicTabbedPaneUI {  

    @Override  
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {  
        // Do not draw borders

    }  
    @Override  
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {  
        
    } 
    @Override  
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,  
                                         Rectangle iconRect, Rectangle textRect, boolean isSelected) {  
        // Remove dashed boxes without performing any drawing operations  
    }  
    @Override  
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {  
    	g.setColor(Color.WHITE);  
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());  
        super.paintTabArea(g, tabPlacement, selectedIndex);  
        try {  
            // Set image in the upper right corner 
        	Image image = ImageIO.read(new File("src/resource/head.png"));  
        	g.drawImage(image, 600, 0, null);  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
    @Override  
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {    
        g.setColor(Color.WHITE);  
        g.fillRect(x, y, w, h);  
    }  
}  
