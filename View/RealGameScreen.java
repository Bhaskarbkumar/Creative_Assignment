package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;


import Controller.GameKeyListener;
import java.awt.Container;
import java.awt.BorderLayout;

public class RealGameScreen extends JFrame {
    private JFrame window;
    private GameScreenCanvas canvas;
    private JButton New = new JButton("START");

    public RealGameScreen (JFrame window) {
        this.window=window;
    }
    
    public void init() {
        Container cp =window.getContentPane();
        
        canvas = new GameScreenCanvas(this);

        cp.add(BorderLayout.CENTER, canvas);
        
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,2));

        GameKeyListener keyListener = new GameKeyListener(this);

        southPanel.add(New);
        cp.add(BorderLayout.SOUTH,southPanel);

        
        New.addActionListener(keyListener);

    
}
    public GameScreenCanvas getCanvas(){
        return canvas;
    }
}

