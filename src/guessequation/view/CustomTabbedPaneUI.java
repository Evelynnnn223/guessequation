package guessequation.view;

import javax.swing.*;  
import javax.swing.plaf.basic.BasicTabbedPaneUI;  
import java.awt.*;  
  
public class CustomTabbedPaneUI extends BasicTabbedPaneUI {  

    @Override  
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {  
        // �����Ʊ߿�  

    }  
    @Override  
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {  
        
    } 
    @Override  
    protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects, int tabIndex,  
                                         Rectangle iconRect, Rectangle textRect, boolean isSelected) {  
        // ��ִ���κλ��Ʋ������Ӷ��Ƴ����߷���  
    }  
    @Override  
    protected void paintTabArea(Graphics g, int tabPlacement, int selectedIndex) {  
    	g.setColor(Color.WHITE);  
        g.fillRect(0, 0, tabPane.getWidth(), tabPane.getHeight());  
        super.paintTabArea(g, tabPlacement, selectedIndex);  
        // ��������Խ�һ���Զ���ѡ�б�ǩ�����  
    }
    
    @Override  
    protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {    
        g.setColor(Color.WHITE);  
        g.fillRect(x, y, w, h);  
    }  
}  
