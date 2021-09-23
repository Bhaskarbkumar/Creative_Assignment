package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.SnakeGame;

public class GameScreenCanvas extends JPanel {

    public int width=600;
    public int height =600;

    private GameScreen screen;

    SnakeGame snake = new SnakeGame();

    Random random;
    public   GameScreenCanvas(GameScreen screen){
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

    }
  
    public void gameOver(Graphics g){

    }

}



