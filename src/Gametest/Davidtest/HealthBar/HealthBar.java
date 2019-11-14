package Gametest.Davidtest.HealthBar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthBar {
    JFrame window;
    JLabel currentHealth;
    JPanel healthBarPanel, buttonPanel;
    Container con;
    JProgressBar healthBar;
    JButton attackButton, healButton;
    int hp;
    DamageHandler damageHandler = new DamageHandler();
    HealingHandler healingHandler = new HealingHandler();



    public static void main(String[] args) {
        new HealthBar();
    }

    public HealthBar() {

        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        healthBarPanel = new JPanel();
        healthBarPanel.setBounds(250, 200, 250, 25);
        healthBarPanel.setBackground(Color.black);

        healthBar = new JProgressBar(0,100);
        healthBar.setBorder(new EmptyBorder(0,0,0,0));

        healthBar.setPreferredSize(new Dimension(250,25));
        healthBar.setValue(100);
        healthBar.setBackground(Color.decode("#B51B1B"));
        healthBar.setForeground(Color.green);
        healthBarPanel.add(healthBar);
        con.add(healthBarPanel);

        currentHealth = new JLabel("Hello");
        currentHealth.setLocation(250,200);
        currentHealth.setVisible(true);
        healthBarPanel.add(currentHealth);

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

        healButton = new JButton("Heal");
        healButton.setBackground(Color.black);
        healButton.setForeground(Color.white);
        healButton.setFocusPainted(false);
        healButton.addActionListener(healingHandler);
        buttonPanel.add(healButton);

        hp = 100;

        window.setVisible(true);
    }
    public void damageTaken() {
        hp -= 2;
        healthBar.setValue(hp);
    }
    public void healedHealth() {
        hp += 2;
        healthBar.setValue(hp);
    }
    public class DamageHandler implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent event) {
            damageTaken();
        }
    }
    public class HealingHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            healedHealth();
        }
    }
}
