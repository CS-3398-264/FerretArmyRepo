package FerretArmyChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog {

        public static void main(GameWindow GW) {

            JFrame frame = new JFrame("START GAME!");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JButton button = new JButton("START");

            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    GW.GWPanel.repaint();
                    frame.dispose();
                }
            };
            button.addActionListener(actionListener);
            Container contentPane = frame.getContentPane();
            contentPane.add(button, BorderLayout.SOUTH);
            frame.setSize(300, 200);
            frame.setVisible(true);
        }

}
