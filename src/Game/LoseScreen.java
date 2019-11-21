package Game;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LoseScreen extends JFrame {

    JLabel youWon, wonBread;
    JButton countinueButton;
    Font pixelMplus, pixelMplus2;

    public LoseScreen() {
        setLayout(null);
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon picwin = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\newGameBackground.jpg");
        setContentPane(new JLabel(picwin));

        //importFont();
        try {pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
        } catch(IOException | FontFormatException e){}

        youWon = new JLabel("Victory Achieved");
        youWon.setForeground(Color.white);
        youWon.setFont(pixelMplus.deriveFont(100f));
        Dimension size = youWon.getPreferredSize();
        youWon.setBounds(200, 100, size.width, size.height);

        wonBread = new JLabel("The minions of the underworld did not best you this day");
        wonBread.setForeground(Color.white);
        wonBread.setFont(pixelMplus.deriveFont(30f));
        Dimension size4 = wonBread.getPreferredSize();
        wonBread.setBounds(200, 300, size4.width, size4.height);

        countinueButton = new JButton("Onwards!");
        countinueButton.setSize(300, 100);
        countinueButton.setLocation(500, 600);
        countinueButton.setForeground(Color.white);
        countinueButton.setBackground(Color.darkGray);
        countinueButton.setBorder(null);
        countinueButton.setFocusPainted(false);

        countinueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                countinueButton.setBackground(Color.gray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                countinueButton.setBackground(Color.darkGray);
            }
        });

        add(youWon);
        add(wonBread);
        add(countinueButton);


        //countinue
        countinueButton.addActionListener(e -> dispose());
        //countinueButton.addActionListener(e -> new ForestFight());

        musicpick.musicStart("gwyn");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
    }

    //ta bort och kalla på metoden i newgame istället?
    public void importFont() {
        try {
            pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf"));
            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("PixelMplus10-Regular.ttf")));

        } catch (IOException | FontFormatException e) {
        }
    }
}