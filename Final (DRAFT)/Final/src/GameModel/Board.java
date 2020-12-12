package GameModel;

import GameController.Controller;
import GameController.Observer;
import GameModel.Tiles.Tile;

import java.util.List;

public class Board extends Observer{
    Tile[][] board;

    public Board(List<Tile> tiles){
        for(Tile t: tiles){

        }
    }

    public boolean checkSpace(int x, int y){
        return board[x][y].canTraverse();
    }

    public Tile getTile(int x, int y){
        return board[x][y];
    }

    public Tile[][] getBoard(){return board;}

    public void update(){}
}
