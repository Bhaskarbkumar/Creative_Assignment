package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;


import java.awt.Container;
import java.awt.BorderLayout;

public class MenuScreen extends JFrame {
 
    private JFrame  window;
    private MenuScreenCanvas canvas;
    private JTextField display = new JTextField("Snake Game ");
    private JButton New = new JButton("New");


public MenuScreen (JFrame window) {
    this.window=window;
}

public void init() {
       Container cp =window.getContentPane();

        canvas = new MenuScreenCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

      JPanel southPanel = new JPanel();
      southPanel.setLayout(new GridLayout(1,1));

      southPanel.add(New);
      cp.add(BorderLayout.SOUTH,southPanel);
    
      New.addActionListener(event -> {
          window.getContentPane().removeAll();
          var panel1 = new RealGameScreen(window);
          panel1.init();
          window.pack();
          window.setVisible(true);
      });

}
}
