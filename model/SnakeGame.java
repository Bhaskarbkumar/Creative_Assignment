package model;

import java.util.Random;
import java.util.Timer;

import View.GameScreenCanvas;

public class SnakeGame {

    public int width=600;
    public int height =600;
    public int unit_size=50;
    public int game_units=width*height/unit_size;
    int delay=65;

    int x[] = new int[game_units];
    int y[] = new int[game_units];
    public int parts=6;
    int mangoesEaten;
    public int mangoeX;
    public int mangoeY;
    char direction ='R';
    public boolean running = true;
    Timer timer;
    Random random = new Random();

    public void startGame() {
          newMangoe();
          running=true;    
    }
    
    public void move() {
        for(int i = parts;i>0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
          }
        switch(direction) {
            case 'U':
            y[0] =y[0] - unit_size;
            break;
            case 'D':
            y[0] = y[0] + unit_size;
            break;
            case 'L':
            x[0] = x[0] - unit_size;
            break;
            case 'R':
            x[0] = x[0] + unit_size;

        }
    }


    public void newMangoe(){
        mangoeX = random.nextInt((int)(width/unit_size))*unit_size;
        mangoeY = random.nextInt((int)(height/unit_size))*unit_size;


    }

    public void checkMangoes(){

    }

    public void checkCollisions() {
          for (int i = parts;i>0;i--) {
              if((x[0]== x[i]) && (y[0] == y[i])){
                    running=false;
              }
          if(x[0] <0){
              running=false;
          }
          if(x[0]>width){
              running=false;
          }
          if(y[0] <0){
              running=false;
          }
          if(y[0]>height){
              running=false;
          }
          }
        }


}

