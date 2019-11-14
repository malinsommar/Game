package HealthbarTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class healthBar {
    JFrame window;
    JPanel healthBarPanel, buttonPanel;
    Container con;
    JProgressBar healthBar;
    JButton attackButton;
    int hp;
    DamageHandler damageHandler = new DamageHandler();



    public static void main(String[] args) {
        new healthBar();
    }
    public healthBar() {
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(250, 180, 300, 35);
        healthBarPanel.setBackground(Color.black);
        healthBar = new JProgressBar(0,100);
        healthBar.setPreferredSize(new Dimension(300,30));
        healthBar.setValue(100);
        healthBar.setBackground(Color.decode("#B51B1B"));
        healthBar.setForeground(Color.green);
        healthBarPanel.add(healthBar);
        con.add(healthBarPanel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(250,300,300,40);
        buttonPanel.setBackground(Color.black);
        con.add(buttonPanel);
        attackButton = new JButton("Attack");
        attackButton.setBackground(Color.black);
        attackButton.setForeground(Color.white);
        attackButton.setFocusPainted(false);
        attackButton.addActionListener(damageHandler);
        buttonPanel.add(attackButton);

        hp = 100;

        window.setVisible(true);
    }
    public void damageTaken() {
        hp -= 10;
        healthBar.setValue(hp);
    }
    public class DamageHandler implements ActionListener {
        public void actionPerformed (ActionEvent event) {
            damageTaken();
        }
    }
}
