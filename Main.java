package puzzle;

import java.awt.event.*;

public class Main{
    public static void main(String[] args){
        Puzzle board = new Puzzle(4, 4);
        board.newGame();
        board.showBoard();

        Controller control = new Controller(board);

        while(!board.isFinished()){
            control.consoleInput();
            board.showBoard();
        }
    }
}