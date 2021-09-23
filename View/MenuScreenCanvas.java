package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;

public class MenuScreenCanvas extends JPanel {
    public static int WIDTH = 600;
    public static int HEIGHT = 600;
    
    private MenuScreen pane;

    public MenuScreenCanvas(MenuScreen pane){
              this.pane = pane;
              setPreferredSize(new Dimension(WIDTH,HEIGHT));
              setBackground(Color.white);
              
    }

@Override

public void paintComponent(Graphics g) {
       super.paintComponent(g);

       Graphics2D g2 = (Graphics2D) g;

           g2.setColor(Color.BLUE);
           g2.setFont(new Font("Courier", Font.ITALIC,30));
           g2.drawString("Press <NEW> to Start",100,150);
}
}
