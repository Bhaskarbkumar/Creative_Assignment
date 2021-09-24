package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;


import java.awt.Container;
import java.awt.BorderLayout;

public class RealGameScreen extends JFrame {
    private JFrame window;
    private GameScreenCanvas canvas;


    public RealGameScreen (JFrame window) {
        this.window=window;
    }
    
    public void init() {
        Container cp =window.getContentPane();
        
        canvas = new GameScreenCanvas();

        cp.add(BorderLayout.CENTER, canvas);

    
}
    public GameScreenCanvas getCanvas(){
        return canvas;
    }
}

