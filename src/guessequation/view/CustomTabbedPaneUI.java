package guessequation.view;

import javax.swing.*;  
import javax.swing.plaf.basic.BasicTabbedPaneUI;  
import java.awt.*;  
  
public class CustomTabbedPaneUI extends BasicTabbedPaneUI {  

    @Override  
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {  
        // 不绘制边框  

    }  
    @Override  
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {  
        
    } 
    @Override  
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,  
                                         Rectangle iconRect, Rectangle textRect, boolean isSelected) {  
        // 不执行任何绘制操作，从而移除虚线方框  
    }  
    @Override  
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {  
    	g.setColor(Color.WHITE);  
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());  
        super.paintTabArea(g, tabPlacement, selectedIndex);  
        // 在这里可以进一步自定义选中标签的外观  
    }
    
    @Override  
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {    
        g.setColor(Color.WHITE);  
        g.fillRect(x, y, w, h);  
    }  
}  
