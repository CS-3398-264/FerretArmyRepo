package FerretArmyChess;

import javax.swing.*;
import java.awt.*;

public class PieceTile extends JPanel {

    Image img;

    public PieceTile(String piece) {

        //white pieces
//        if(pieceIndex >=0 && pieceIndex <= 7) //pawns
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_pawn.png");
//        if (pieceIndex == 8 || pieceIndex == 15) //rooks
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_rook.png");
//        if (pieceIndex == 9 || pieceIndex == 14) //knights
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_knight.png");
//        if (pieceIndex == 10 || pieceIndex == 13) //bishops
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_bishop.png");
//        if (pieceIndex ==11)                    //king
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_king.png");
//        if (pieceIndex ==12)                    //queen
//            img = Toolkit.getDefaultToolkit().createImage("Images/white_queen.png");
//
//        //black pieces
//        if(pieceIndex >=16 && pieceIndex <= 23)
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_pawn.png");
//        if (pieceIndex == 24 || pieceIndex == 29)
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_rook.png");
//        if (pieceIndex == 25 || pieceIndex == 30)
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_knight.png");
//        if (pieceIndex == 26 || pieceIndex == 31)
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_bishop.png");
//        if (pieceIndex ==27)                    //queen?
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_queen.png");
//        if (pieceIndex ==28)                    //king?
//            img = Toolkit.getDefaultToolkit().createImage("Images/black_king.png");

        img = Toolkit.getDefaultToolkit().createImage("Images/"+piece+".png");

        this.setOpaque(false);
        this.setSize(50,50);
        this.setVisible(true);
    }



    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }

}

