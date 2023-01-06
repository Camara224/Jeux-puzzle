package puzzle;

import java.util.*;
import java.util.Random;

public class Puzzle{
    protected int length, width;
    protected int[][] board;

    public Puzzle(){
        this.length = 4;
        this.width = 4;
    }

    public Puzzle(int length, int width){
        this.length = length;
        this.width = width;
        this.board = new int[this.length][this.width];
    }

    public void createBoard(){
        int m = 1;

        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                this.board[i][j] = m;
                m += 1;
            }
        }
        this.board[this.length - 1][this.width - 1] = 0;
    }

    //Maybe this should be in the view?
    public void showBoard(){
        System.out.println("\n====== Taquin Puzzle ======");
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                System.out.print("|" + this.board[i][j] + "|\t");
            }
            System.out.println("");
        }
    }

    public void shuffleBoard(int iterations){

        for(int i = 0; i < iterations; i++){
            int randomTile1X = new Random().nextInt(this.length);
            int randomTile1Y = new Random().nextInt(this.width);
            
            int randomTile2X = new Random().nextInt(this.length);
            int randomTile2Y = new Random().nextInt(this.width);
    
            int temp = this.board[randomTile1X][randomTile1Y];
            this.board[randomTile1X][randomTile1Y] = this.board[randomTile2X][randomTile2Y];
            this.board[randomTile2X][randomTile2Y] = temp;
        }
    }

    public void resetBoard(){
        ;
    }

    public boolean isSolvable(){
        // - If the grid width is odd, then the number of inversions in a solvable situation is even.
        // - If the grid width is even, and the blank is on an even row counting from the bottom (second-last, fourth-last etc), then the number of inversions in a solvable situation is odd.
        // - If the grid width is even, and the blank is on an odd row counting from the bottom (last, third-last, fifth-last etc) then the number of inversions in a solvable situation is even.

        int inversionCount = 0;
    
        for(int i = 1; i < this.length; i++){
            for(int j = 1; j < this.width; j++){
                if(this.board[i - 1][j - 1] > this.board[i][j]){
                    inversionCount =+ 1;
                }
            }
        }
        return inversionCount % 2 == 0;
    }

    public void newGame(){
        do{
            createBoard();
            shuffleBoard(20);
        } while(!isSolvable());
    }

    public ArrayList<Integer> getEmptyTileCoordinates(){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                if(this.board[i][j] == 0){
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }

    //Moving the empty tile
    public void movePiece(String direction){
        //Coordinates of the empty tile
        ArrayList<Integer> coordinates = new ArrayList<Integer>();
        coordinates = getEmptyTileCoordinates();
        int x = coordinates.get(0);
        int y = coordinates.get(1);

        if(direction.equals("up")){
            int temp = this.board[x + 1][y];
            this.board[x + 1][y] = this.board[x][y];
            this.board[x][y] = temp;
        }

        if(direction.equals("down")){
            int temp = this.board[x - 1][y];
            this.board[x - 1][y] = this.board[x][y];
            this.board[x][y] = temp;
        }

        if(direction.equals("right")){
            int temp = this.board[x][y - 1];
            this.board[x][y - 1] = this.board[x][y];
            this.board[x][y] = temp;
        }

        if(direction.equals("left")){
            int temp = this.board[x][y + 1];
            this.board[x][y + 1] = this.board[x][y];
            this.board[x][y] = temp;
        }
    }

    public boolean isFinished(){
        int m = 1;

        for(int i = 0; i < this.length; i++){
            for(int j = 0; j < this.width; j++){
                if(this.board[i][j] != m){
                    return false;
                }
                m += 1;
            }
        }
        return true;
    }
}