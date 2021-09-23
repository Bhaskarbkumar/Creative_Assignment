import javax.swing.JFrame;

import View.MenuScreen;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] ar){


        JFrame window = new JFrame();

        var menu = new MenuScreen(window);
        menu.init();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);




    }
}