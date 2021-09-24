package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GameScreenCanvas extends JPanel implements ActionListener{

    public int width=800;
    public int height =800;
    public int unit_size=30;
    public int game_units=(width*height)/(unit_size*unit_size);
    int delay=165;
    int x[] = new int[game_units];
    int y[] = new int[game_units];
    public int parts=6;
    public int mangoesEaten;
    public int mangoeX;
    public int mangoeY;
    public char direction ='R';
    public boolean running = false;
    Timer timer ;
    Random random;
    
    
    GameScreenCanvas(){
        random = new Random();
        this.setPreferredSize(new Dimension(width,height));
        this.setBackground(Color.black);
        this.setVisible(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    
    }

    public void startGame() {
        newMangoe();
        running = true;
        timer = new Timer(delay,this);
        timer.start();
        
  }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){

        if(running) {
         for (int i=0;i<height/unit_size;i++){
              g.drawLine(i*unit_size,0,i*unit_size,height);
              g.drawLine(0, i*unit_size,width,i*unit_size);
        } 
            g.setColor(Color.red);
            g.fillOval(mangoeX, mangoeY, unit_size, unit_size);
        
        for(int i=0;i<parts;i++){
           if(i==0) {
               g.setColor(Color.green);
               g.fillRect(x[i], y[i], unit_size, unit_size);
           }
           else{
               g.setColor(new Color(45,180,0));
               g.fillRect(x[i], y[i], unit_size, unit_size);

           }
        }
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Score: "+mangoesEaten, (width - metrics.stringWidth("Score: "+mangoesEaten))/2, g.getFont().getSize());
    }
    else {
        gameOver(g);
    }
    }

    public void newMangoe(){
        mangoeX = random.nextInt((int)(width/unit_size))*unit_size;
        mangoeY = random.nextInt((int)(height/unit_size))*unit_size;
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


    public void checkMangoes(){
        if((x[0] == mangoeX) && (y[0] == mangoeY)) {
			parts++;
			mangoesEaten++;
		  newMangoe();
        }

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
          
          if(!running) {
              timer.stop();
          }
        }
    }
  
    public void gameOver(Graphics g){
        g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 40));
		FontMetrics metrics1 = getFontMetrics(g.getFont());
		g.drawString("Score: "+mangoesEaten, (width - metrics1.stringWidth("Score: "+mangoesEaten))/2, g.getFont().getSize());
		//Game Over text
		g.setColor(Color.red);
		g.setFont( new Font("Ink Free",Font.BOLD, 75));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		g.drawString("Game Over", (width - metrics2.stringWidth("Game Over"))/2, height/2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(running){
            move();
            checkMangoes();
            checkCollisions();
        } 
        repaint();
     }

     
    public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;
                
			}
    
        }
   
        }
    }








