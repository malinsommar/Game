package Gametest.Simontest;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class simontest extends JFrame {

    Scanner sc = new Scanner(System.in);
    JFrame testFrame = new JFrame();
    private JButton testButton;
    private JButton testButton2;
    private JButton takedamagebutton;
    private JButton magespellbutton;
    int[] enemies = new int[4];
    int level = 5;

    public int cloudx = 100;
    public int cloudy = 200;
    public int startpostitionwarriorx = cloudx;
    public int startpostitionwarriory = cloudx;
    int phase = 0;
    int timepast = 0;
    int sizex = 200;
    int sizey = 200;
    int flamey = -400;
    int arrowx = 300;

    Warrior warrpizza = new Warrior();
    Mage magepizza = new Mage();
    Healer healerpizza = new Healer();
    Ranger rangerpizza = new Ranger();
    JLabel firestorm = new JLabel(new ImageIcon("bigfire.gif"));
    JLabel flame = new JLabel(new ImageIcon("flame.gif"));
    JLabel arrow = new JLabel(new ImageIcon("arrow.png"));

    JLabel pizza = new JLabel(new ImageIcon("ranger.gif"));
    int[] partypizza = new int[4];

    public simontest() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon picShop = new ImageIcon("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\Gametest\\Simontest\\shopk.jpg");
        setContentPane(new JLabel(picShop)); //assign background
        //Icon mage = new ImageIcon("mage.gif");
        //add(new JLabel(mage));

        /*
        ImageIcon warrior = new ImageIcon("warrior.gif");
        ImageIcon ranger = new ImageIcon("ranger.gif");
        ImageIcon mage = new ImageIcon("mage.gif");
        ImageIcon healer = new ImageIcon("healer.gif");
        add(new JLabel(warrior));
        add(new JLabel(ranger));
        add(new JLabel(mage));
        add(new JLabel(healer));
        */
        Dimension warriorSize = pizza.getPreferredSize();
        pizza.setSize(warriorSize.width, warriorSize.height);
        pizza.setLocation(cloudx, cloudy);
        add(pizza);

        testButton = new JButton("arrow");
        testButton.setSize(150, 40);
        testButton.setLocation(800, 100);
        testButton.setBackground(Color.white);

        testButton2 = new JButton("move");
        testButton2.setSize(150, 40);
        testButton2.setLocation(800, 150);
        testButton2.setBackground(Color.white);

        add(testButton);
        add(testButton2);
        testButton.addActionListener(e -> shoot.start());
        testButton2.addActionListener(e -> {
            timer.start();
        });

        takedamagebutton = new JButton("takedamage");
        takedamagebutton.setSize(150, 40);
        takedamagebutton.setLocation(800, 200);
        takedamagebutton.setBackground(Color.white);
        add(takedamagebutton);
        takedamagebutton.addActionListener(e -> {
            takedamage.start();
        });


        magespellbutton = new JButton("magespell");
        magespellbutton.setSize(150, 40);
        magespellbutton.setLocation(800, 250);
        magespellbutton.setBackground(Color.white);
        add(magespellbutton);
        magespellbutton.addActionListener(e -> {
            musicpick.musicStart("magespell", "");
            magespell.start();
        });
        magespell.setRepeats(true);
        magespell.setCoalesce(true);
        magespell.setInitialDelay(10);

        //testButton.addActionListener(e -> musicpick.musicStart("theme"));

        //musicpick.musicStart("theme");

        //////////////////////////////////////////////////////////////////

        timer.setRepeats(true);
        timer.setCoalesce(true);
        timer.setInitialDelay(10);
        takedamage.setRepeats(true);
        takedamage.setCoalesce(true);
        takedamage.setInitialDelay(10);

        Dimension fireSize = firestorm.getPreferredSize();
        firestorm.setSize(fireSize.width, fireSize.height);
        firestorm.setLocation(700, 200);
        add(firestorm);
        firestorm.setVisible(false);

        Dimension flameSize = flame.getPreferredSize();
        flame.setSize(flameSize.width, flameSize.height);
        flame.setLocation(800, flamey);
        add(flame);
        flame.setVisible(true);

        Dimension arrowSize = arrow.getPreferredSize();
        arrow.setSize(arrowSize.width, arrowSize.height);
        arrow.setLocation(-100, arrowx);
        add(arrow);



        setLayout(null); //Default layout
        setSize(1900, 500);

        setVisible(true);
        sethp();

    }

    public void sethp() {
        enemies[0] = 100;
        enemies[1] = 100;
        enemies[2] = 100;
        enemies[3] = 100;
    }

    public void spelltest(String spell, int level) {
        //int health = Warrior.hp;
        //dmg = weapon damage + buffdmg + debuffdmg
        //mage
        //ta bort level å hämta direkt
        if (spell.equals("firestorm")) {
            for (int i = 0; i < 4; i++) {
                enemies[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + enemies[i]);
            }
        } else if (spell.equals("fireball")) {
            enemies[0] -= (10 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("pyroblast")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("arcane explosion")) {
            for (int i = 0; i < 4; i++) {
                enemies[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + enemies[i]);
            }
        }
        //warrior
        else if (spell.equals("concussive blow")) {
            enemies[0] -= (3 * level);
            //stunned 0 true
            System.out.println("stunned the enemy, skipping it's next turn");
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("battlecry")) {
            //buffdmg = 5
            System.out.println("shouts loudly, inspireing their allies");
        } else if (spell.equals("demoralizing shout")) {
            //debuffdmg = 5
            System.out.println("shouts loudly, striking fear in the hearths of their enemies");
        } else if (spell.equals("taunt")) {
            //taunted = true
            System.out.println("insults the enemy, it is sure to attack them");
        }
        //ranger
        else if (spell.equals("arrow shootshoot blast boomboom")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("poison arrow")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        } else if (spell.equals("stealth")) {
            enemies[0] -= (20 * level);
            System.out.println("hides, their next normal attack will be a backstab");
            //normal attack blir backstab
        } else if (spell.equals("disengaged shot")) {
            enemies[0] -= (20 * level);
            System.out.println("enemy nr " + 0 + " has " + enemies[0]);
        }
        //healer
        else if (spell.equals("heal")) {
            //glöm inte Warrior warrpizza =new Warrior();
            warrpizza.hp += (40 * level);
            if (warrpizza.hp > 150) {
                warrpizza.hp = 150;
            }
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        } else if (spell.equals("overheal")) {
            warrpizza.hp += (30 * level);
            if (warrpizza.hp > 180) {
                warrpizza.hp = 180;
            }
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        } else if (spell.equals("group heal")) {
            //glöm inte party
            warrpizza.hp += (30 * level);
            for (int i = 0; i < 4; i++) {
                partypizza[i] -= (5 * level);
                System.out.println("enemy nr " + i + " has " + partypizza[i]);
            }
            if (warrpizza.hp > 180) {
                warrpizza.hp = 180;
            }
            System.out.println("the warrior nr " + 0 + " has " + warrpizza.hp);
        }
    }


    //BufferedImage mage2 = ImageIO.read(new File("mage.gif"));//funkar inte
    //mage2.getGraphics().drawImage(mage2 ,500, 500, null);//funkar inte

 /*
        BufferedImage mage2 = ImageIO.read((getClass().getResource("C:\\Users\\96simben\\Documents\\GitHub\\Game\\src\\cave.jpg")));
        Graphics g = mage2.getGraphics();
        g.drawImage(mage2, 0, 0, null);
        */

        /* lägger in en bild utan collision som kan flyttas
        JLabel warrior = new JLabel();
        warrior.setIcon(new ImageIcon("warrior.gif"));
        add(warrior);
        Dimension warriorsize = warrior.getPreferredSize();
        warrior.setBounds(100, 100, warriorsize.width, warriorsize.height);
         */


    Timer timer = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*rush past
                cloudx += 30;
                pizza.setLocation(cloudx, 100);

            if (cloudx > 1000) {
                pizza.setVisible(false);
            }
            if (cloudx > 2000) {
                cloudx = 100;
                pizza.setLocation(cloudx,100);
                pizza.setVisible(true);
                timer.stop();
            }
             */
            if (phase == 0) {
                if (cloudx == 100) musicpick.musicStart("warriorattack", "");
                cloudx += 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx > 200) {
                    phase = 1;
                }
            } else if (phase == 1) {
                cloudx -= 30;
                pizza.setLocation(cloudx, 100);
                if (cloudx < 100) {
                    phase = 0;
                    timer.stop();
                }
            }
        }
    });

    Timer takedamage = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (phase == 0) {
                musicpick.musicStart("warriorattacked", "");
                phase = 1;
            } else if (phase == 1) {
                timepast++;
                if (timepast > 100) {
                    timepast = 0;
                    phase = 2;
                }
            } else if (phase == 2) {
                pizza.setVisible(false);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 3;
                }
            } else if (phase == 3) {
                pizza.setVisible(true);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 4;
                }
            } else if (phase == 4) {
                pizza.setVisible(false);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 5;
                }
            } else if (phase == 5) {
                pizza.setVisible(true);
                takedamage.stop();
                phase = 0;

            }
        }
    });

    Timer magespell = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (phase == 0) {
                cloudy -= 3;
                pizza.setLocation(100, cloudy);
                if (cloudy < 50) {
                    phase = 1;
                }
            } else if (phase == 1) {
                if (cloudy < 50) {
                    cloudy = 50;
                    cloudx -= 3;
                }

                timepast++;
                if (timepast < 100) {
                    if (timepast % 2 == 1) {
                        cloudx += 6;
                        pizza.setLocation(cloudx, cloudy);
                        flamey += 10;
                        flame.setLocation(700, flamey);
                    } else {
                        cloudx -= 6;
                        pizza.setLocation(cloudx, cloudy);
                    }
                }

                if (timepast == 102) {
                    pizza.setLocation(cloudx - 10, cloudy);
                    firestorm.setVisible(true);
                    flamey = -400;
                    flame.setLocation(700, flamey);
                }
                if (timepast > 130) {
                    timepast = 0;
                    phase = 2;
                }
            } else if (phase == 2) {
                cloudy += 3;
                pizza.setLocation(100, cloudy);
                if (cloudy > 200) {
                    startpostitionwarriorx = cloudx;
                    startpostitionwarriory = cloudy;
                    phase = 3;
                }
            } else if (phase == 3) {
                timepast++;
                if (timepast > 30) {
                    timepast = 0;
                    firestorm.setVisible(false);
                    magespell.stop();
                    phase = 0;
                }
            }
        }
    });

    Timer rangerattack = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (phase == 0) {
                musicpick.musicStart("warriorattacked", "");
                phase = 1;
            } else if (phase == 1) {
                timepast++;
                if (timepast > 100) {
                    timepast = 0;
                    phase = 2;
                }
            } else if (phase == 2) {
                pizza.setVisible(false);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 3;
                }
            } else if (phase == 3) {
                pizza.setVisible(true);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 4;
                }
            } else if (phase == 4) {
                pizza.setVisible(false);
                timepast++;
                if (timepast > 10) {
                    timepast = 0;
                    phase = 5;
                }
            } else if (phase == 5) {
                pizza.setVisible(true);
                takedamage.stop();
                phase = 0;

            }
        }
    });

    Timer shoot = new Timer(10, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            /*rush past
                cloudx += 30;
                pizza.setLocation(cloudx, 100);

            if (cloudx > 1000) {
                pizza.setVisible(false);
            }
            if (cloudx > 2000) {
                cloudx = 100;
                pizza.setLocation(cloudx,100);
                pizza.setVisible(true);
                timer.stop();
            }
             */

            if (phase == 0) {
                arrow.setVisible(true);
                if (arrowx == 300) {
                    musicpick.musicStart("ding", "");
                    //arrow.setVisible(true);
                }
                arrowx += 10;
                arrow.setLocation(arrowx, 270);
                if (arrowx > 800) {
                    phase = 1;
                }
            } else if (phase == 1) {
                arrow.setVisible(false);
                arrowx = 300;
                arrow.setLocation(arrowx, 270);
                    phase = 0;
                    shoot.stop();
                }
            }
    });
}

