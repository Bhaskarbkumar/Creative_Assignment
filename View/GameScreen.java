package View;

import javax.swing.JFrame;

import Controller.GameKeyListener;
import java.awt.Container;
import java.awt.BorderLayout;

public class GameScreen extends JFrame {
 
    private JFrame window;
    private GameScreenCanvas canvas;

    public GameScreen (JFrame window) {
        this.window=window;
    }
    
    public void init() {
        Container cp =window.getContentPane();
        
        canvas = new GameScreenCanvas(this);

        cp.add(BorderLayout.CENTER, canvas);
        
    }
}
