/**/

package FerretArmyChess;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class GameBoard extends JPanel {



    public GameBoard(Game _game) {
        this.setLayout(new GridLayout(8,8));
        char tileColor;
        Tile[][] _tiles = new Tile[8][8];
        //board & tile layout work
        int counter = 0;
        for (int y = 0; y < 8; y++) {
            for (int x = 7; x >= 0; x--) {

                if (counter % 2 == 0) {
                    tileColor = 'b';
                } else {
                    tileColor = 'w';
                }

                _tiles[x][y] = new Tile(tileColor);

                this.add(_tiles[x][y]);
                _tiles[x][y].setVisible(true);

                counter++;
            }
            counter++; //for offset colors per row
        }


        for (int y = 0; y < 8; y++) {   //-------method names are INCORRECT
            for (int x = 7; x >= 0; x--) {
                if(_game.getPiece(x,y) != null) {
                    _tiles[x][y].setLayout(null);
                    _tiles[x][y].add(new PieceTile(_game.getPiece(x, y).getImageText()));
                }
                //for troubleshooting
//                if((_game.getPiece(x,y) == null)){
//                    _tiles[x][y].setBackground(Color.BLUE);
//                }
            }
        }

        this.setSize(400,400);
        this.setVisible(true);

    }


}
