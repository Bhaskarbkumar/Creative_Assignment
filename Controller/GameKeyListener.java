package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



import javax.swing.JPanel;

import View.RealGameScreen;
import model.SnakeGame;


public class GameKeyListener  implements ActionListener{

    
    private RealGameScreen screen;

    public GameKeyListener(RealGameScreen screen) {
         this.screen=screen;
     }
  

    @Override
    public void actionPerformed(ActionEvent e) {
        SnakeGame snake = new SnakeGame();
        if(snake.running) {
               snake.move();
           }
           screen.getCanvas().repaint();
             
    }
    public class  MykeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){

        }
    }
  
}