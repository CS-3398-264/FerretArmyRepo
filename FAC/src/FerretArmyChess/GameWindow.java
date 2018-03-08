package FerretArmyChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static FerretArmyChess.Color.BLACK;
import static FerretArmyChess.Color.WHITE;

public class GameWindow {

    GameBoard GB;

    public GameWindow(Game _game) {


        moveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String SourceX = SourceTextX.getText();
                SourceTextX.setText(null);
                String SourceY = SourceTextY.getText();
                SourceTextY.setText(null);
                String DestX = DestTextX.getText();
                DestTextX.setText(null);
                String DestY = DestTextY.getText();
                DestTextY.setText(null);

                int sx = (int) SourceX.charAt(0) - 48;
                int sy = (int) SourceY.charAt(0) - 48;
                int dx = (int) DestX.charAt(0) - 48;
                int dy = (int) DestY.charAt(0) - 48;
                //for troubleshooting
//                System.out.print(sx + " , ");
//                System.out.println(sy);
//                System.out.print(dx + " , ");
//                System.out.println(dy);


                boolean validInput = true;
                if (sx < 0 || sx > 8 || sy < 0 || sy > 8 || dx < 0 || dx > 8 || dy < 0 || dy > 8) {
                    validInput = false;
                    MessageBox.setText("Invalid Input");
                }
                //coordinate conversion
                sx = 8 - sx;
                sy = 8 - sy;
                dx = 8 - dx;
                dy = 8 - dy;

                //for troubleshooting
//                System.out.print(sx + " , ");
//                System.out.println(sy);
//                System.out.print(dx + " , ");
//                System.out.println(dy);

                if (validInput) {
                    Piece sourcePiece = _game.getPiece(sx, sy);
                    if (sourcePiece != null && _game.turn() == BLACK && sourcePiece.getColor() == WHITE) {
                        blackTurnButton.doClick();
                    }
                    if (sourcePiece != null && sourcePiece.canMakeValidMove(dx, dy)) {
                        if (_game.inCheck(_game.turn())) {
                            MessageBox.setText(_game.turn().text() + " Checkmate");
                            JOptionPane.showMessageDialog(new JFrame(), "GAME IS OVER. Please exit.");
                        } else {

                            MessageBox.setText("Moved!");
                        }
                        setGameBoard(new GameBoard(_game));
                    } else {
                        MessageBox.setText("Invalid Move, try again.");
                        if (_game.turn() == BLACK)
                            blackTurnButton.doClick();
                    }
                    //sourcePiece = null;
                }


//
            }

        });

        blackTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (_game.turn() == BLACK) {
                    AIE(_game);
                }
                GWPanel.repaint();
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GWPanel.repaint();
            }
        });
    }

    public static GameWindow main(Game _game) {
        GameWindow GW = new GameWindow(_game);
        JFrame frame = new JFrame("GameWindow");
        frame.setContentPane(GW.GWPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(550, 442);
        frame.setResizable(false);
        frame.setLocation(450, 275);
        frame.pack();
        frame.setVisible(true);

        return GW;
    }

    public void GWdispose() {

    }


    public JPanel GWPanel;
    private JTextField SourceTextX;
    private JTextField DestTextX;
    private JTextField SourceTextY;
    private JTextField DestTextY;
    private JButton moveButton;
    private JTextArea MessageBox;
    private JPanel GameBoardPanel;
    private JButton blackTurnButton;
    private JButton refreshButton;

    private void AIE(Game _game) {

        Random rand = new Random();
        Integer x;
        Integer y;
        boolean validS = false;
        do {
            x = rand.nextInt(8) + 1;
            y = rand.nextInt(8) + 1;
            if (_game.getPiece(8 - x, 8 - y) != null && _game.getPiece(8 - x, 8 - y).getColor() == BLACK) {
                validS = true;
            }
        } while (validS == false);

        Integer _x;
        Integer _y;
        boolean validD = false;
        do {
            _x = rand.nextInt(8) + 1;
            _y = rand.nextInt(8) + 1;
            if (_game.getPiece(8 - _x, 8 - _y) == null || _game.getPiece(8 - _x, 8 - _y).getColor() != BLACK) {
                validD = true;
            }
        } while (validD == false);


        SourceTextX.setText(x.toString());
        SourceTextY.setText(y.toString());
        DestTextX.setText(_x.toString());
        DestTextY.setText(_y.toString());
        moveButton.doClick();
    }

    public void setGameBoard(GameBoard GB) {
        GameBoardPanel.removeAll();
        GameBoardPanel.add(GB);
//        GameBoardPanel.revalidate();
//        GameBoardPanel.repaint();
//        GWPanel.repaint();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        GWPanel = new JPanel();
        GWPanel.setLayout(new GridBagLayout());
        GWPanel.setBackground(new java.awt.Color(-6644321));
        GWPanel.setMinimumSize(new Dimension(685, 570));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        GWPanel.add(panel1, gbc);
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("ScriptC", Font.BOLD, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setHorizontalAlignment(0);
        label1.setHorizontalTextPosition(0);
        label1.setText("Ferret Army");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        panel1.add(label1, gbc);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(panel2, gbc);
        final JLabel label2 = new JLabel();
        label2.setText("Source");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label2, gbc);
        final JLabel label3 = new JLabel();
        label3.setText("Destination");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label3, gbc);
        SourceTextX = new JTextField();
        SourceTextX.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(SourceTextX, gbc);
        DestTextX = new JTextField();
        DestTextX.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(DestTextX, gbc);
        SourceTextY = new JTextField();
        SourceTextY.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(SourceTextY, gbc);
        DestTextY = new JTextField();
        DestTextY.setAutoscrolls(false);
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(DestTextY, gbc);
        final JLabel label4 = new JLabel();
        label4.setText("Y");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label4, gbc);
        final JLabel label5 = new JLabel();
        label5.setText("X");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        panel2.add(label5, gbc);
        MessageBox = new JTextArea();
        MessageBox.setBackground(new java.awt.Color(-917761));
        MessageBox.setDisabledTextColor(new java.awt.Color(-16777216));
        MessageBox.setEditable(false);
        MessageBox.setText("Defaut Text!");
        MessageBox.setWrapStyleWord(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        panel1.add(MessageBox, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weighty = 2.5;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel1.add(spacer1, gbc);
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Complex", Font.BOLD, 20, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setHorizontalAlignment(0);
        label6.setHorizontalTextPosition(0);
        label6.setText("CHESS");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(label6, gbc);
        blackTurnButton = new JButton();
        blackTurnButton.setLabel("Black Turn");
        blackTurnButton.setText("Black Turn");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(blackTurnButton, gbc);
        final JTextArea textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setText("Instructions:\nInput X,Y of desired move.\nClick \"Move\" to submit\nClick \"Black Turn\"\n-wait for processing to finish-\n-its thinking of how to beat you-\nClick \"Refresh\" to draw pieces.");
        textArea1.setWrapStyleWord(true);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        panel1.add(textArea1, gbc);
        refreshButton = new JButton();
        refreshButton.setLabel("Refresh");
        refreshButton.setText("Refresh");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(refreshButton, gbc);
        GameBoardPanel = new JPanel();
        GameBoardPanel.setLayout(new BorderLayout(0, 0));
        GameBoardPanel.setMaximumSize(new Dimension(-1, -1));
        GameBoardPanel.setMinimumSize(new Dimension(-1, -1));
        GameBoardPanel.setPreferredSize(new Dimension(400, 400));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        GWPanel.add(GameBoardPanel, gbc);
        GameBoardPanel.setBorder(BorderFactory.createTitledBorder("1"));
        moveButton = new JButton();
        moveButton.setText("Move");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        GWPanel.add(moveButton, gbc);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        GWPanel.add(panel3, gbc);
        final JLabel label7 = new JLabel();
        label7.setText("(1)A");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label7, gbc);
        final JLabel label8 = new JLabel();
        label8.setText("(8)H");
        gbc = new GridBagConstraints();
        gbc.gridx = 7;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label8, gbc);
        final JLabel label9 = new JLabel();
        label9.setText("(7)G");
        gbc = new GridBagConstraints();
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label9, gbc);
        final JLabel label10 = new JLabel();
        label10.setText("(2)B");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label10, gbc);
        final JLabel label11 = new JLabel();
        label11.setText("(3)C");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label11, gbc);
        final JLabel label12 = new JLabel();
        label12.setText("(4)D");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label12, gbc);
        final JLabel label13 = new JLabel();
        label13.setText("(5)E");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label13, gbc);
        final JLabel label14 = new JLabel();
        label14.setText("(6)F");
        gbc = new GridBagConstraints();
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        panel3.add(label14, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridBagLayout());
        panel4.setMinimumSize(new Dimension(25, 24));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        GWPanel.add(panel4, gbc);
        final JLabel label15 = new JLabel();
        label15.setHorizontalTextPosition(4);
        label15.setText("1");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label15, gbc);
        final JLabel label16 = new JLabel();
        label16.setHorizontalTextPosition(4);
        label16.setText("8");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label16, gbc);
        final JLabel label17 = new JLabel();
        label17.setHorizontalTextPosition(4);
        label17.setText("7");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label17, gbc);
        final JLabel label18 = new JLabel();
        label18.setHorizontalTextPosition(4);
        label18.setText("6");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label18, gbc);
        final JLabel label19 = new JLabel();
        label19.setHorizontalTextPosition(4);
        label19.setText("5");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label19, gbc);
        final JLabel label20 = new JLabel();
        label20.setHorizontalTextPosition(4);
        label20.setText("4");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label20, gbc);
        final JLabel label21 = new JLabel();
        label21.setHorizontalTextPosition(4);
        label21.setText("2");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label21, gbc);
        final JLabel label22 = new JLabel();
        label22.setHorizontalTextPosition(4);
        label22.setText("3");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.EAST;
        panel4.add(label22, gbc);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return GWPanel;
    }

    //    public void redrawGWPanel() {
//        GWPanel.revalidate();
//        GWPanel.repaint();
//    }

}
