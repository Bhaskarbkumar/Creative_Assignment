package model;

import java.util.Random;
import java.util.Timer;

import View.GameScreenCanvas;

public class SnakeGame {

    public int width=600;
    public int height =600;
    public int unit_size=25;
    public int game_units=width*height/unit_size;
    int delay=65;

    int x[] = new int[game_units];
    int y[] = new int[game_units];
    int parts=6;
    int mangoesEaten;
    int mangoeX;
    int mangoeY;
    char direction ='R';
    boolean running = false;
    Timer timer;
    Random random;

    public void startGame() {
          newMangoe();
          running=true;
          
    }
    
    public void move() {

    }


    public void newMangoe(){

    }

    public void checkMangoes(){

    }

    public void checkCollisions() {

    }


}

