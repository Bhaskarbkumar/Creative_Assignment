package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.SnakeGame;

public class GameScreenCanvas extends JPanel {
    SnakeGame snake = new SnakeGame();

    public int width=600;
    public int height =600;
    public int game_units=width*height/snake.unit_size;

    int x[] = new int[game_units];
    int y[] = new int[game_units];

    private RealGameScreen screen;

    

    Random random;

    public   GameScreenCanvas(RealGameScreen screen){
        this.screen=screen;
        random = new Random();
        setPreferredSize(new Dimension(width,height));
        setBackground(Color.black);
        setVisible(true);
        snake.startGame();
    }
     
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){

        for (int i=0;i<height/snake.unit_size;i++){
              g.drawLine(i*snake.unit_size,0,i*snake.unit_size,height);
              g.drawLine(0, i*snake.unit_size,width,i*snake.unit_size);
        }
            g.setColor(Color.red);
            g.fillOval(snake.mangoeX, snake.mangoeY, snake.unit_size, snake.unit_size);
        
        for(int i=0;i<snake.parts;i++){
           if(i==0) {
               g.setColor(Color.green);
               g.fillRect(x[i], y[i], snake.unit_size, snake.unit_size);
           }
           else{
               g.setColor(new Color(45,180,0));
               g.fillRect(x[i], y[i], snake.unit_size, snake.unit_size);

           }
        }
    }
  
    public void gameOver(Graphics g){

    }

}



