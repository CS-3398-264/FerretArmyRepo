package FerretArmyChess;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class Tile extends JPanel {

    private boolean _isOccupied = false;  //might be redundant. just call pieceOnTile and check for null *************
    private Piece pieceOnTile = null;  //playing with fire returning null
    char tileColor; //just for the GUI

    public Tile(char tileColor) {
        this.tileColor = tileColor;
        this.setSize(50,50);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        if(tileColor == 'w') {this.setBackground(java.awt.Color.LIGHT_GRAY);}
        if(tileColor == 'b') {this.setBackground(java.awt.Color.DARK_GRAY);}
    }

    public char getTileColor() {
        return tileColor;
    }

    public void setTileColor(char tileColor) {

        this.tileColor = tileColor;
    }

    public Piece getPieceOnTile(){
        return pieceOnTile;
    }

    public void setPieceOnTile(Piece pieceReceived) {
        this.pieceOnTile = pieceReceived;
    }  //double check me ****************
}
