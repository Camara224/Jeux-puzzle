package puzzle;

import java.awt.event.*;
import java.util.Scanner;

public class Controller {

    protected Puzzle model;
    protected View view;

    public Controller(Puzzle model) {
        this.model = model;
        // parameters : puzzle and view object
    }

    public void updateView(){
        // call view class to report change
        System.out.println("call view, there is a change inside board");
    }

    public void consoleInput() {
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("enter command (exit to leave programm) :");
            String input = keyboard.nextLine();
            if(input != null) {
                if("exit".equals(input)){
                    System.out.println("exit programm");
                    exit = true;
                }
                else if ("up".equals(input) || "down".equals(input) || "right".equals(input) || "left".equals(input)){
                    System.out.println("send to puzzle class and report view class");
                    System.out.println("input : " + input);
                    model.movePiece(input);
                    // call class model to send input user
                    updateView();
                    exit = true;
                }
            }
        }
    }

    public void guiKeyboardInput(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            System.out.println("left");
        }
        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("right");
        }
        if (key == KeyEvent.VK_UP) {
            System.out.println("up");
        }
        if (key == KeyEvent.VK_DOWN) {
            System.out.println("down");
        }
    }

    public void guiMouseInput(KeyEvent e) {
        System.out.println("code for caption mouse location and design witch tiles correspond");
    } 
}