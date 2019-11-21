package Gametest.Davidtest.hubworld;

import Gametest.Davidtest.hubworld.gfx.Colours;
import Gametest.Davidtest.hubworld.gfx.Screen;
import Gametest.Davidtest.hubworld.gfx.SpriteSheet;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 160;
    public static final int HEIGHT = WIDTH/12 * 9;
    public static final int SCALE = 3;
    public static final String NAME = "Game";

    private JFrame frame;

    public boolean running = false;
    public int tickCount = 0;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private int[] colours = new int[6*6*6];
    private Screen screen;
    public InputHandler input;

    public Game() {
        setMinimumSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));
        setMaximumSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));
        setPreferredSize(new Dimension(WIDTH* SCALE, HEIGHT * SCALE));

        frame = new JFrame(NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);//Center Canvas within the JFrame
        frame.pack(); //Sets frames above or at preferred size

        frame.setResizable(false);//Not resizable
        frame.setLocationRelativeTo(null);//center the frame
        frame.setVisible(true);
    }
    public void init() {
        int index = 0;
        //red
        for (int r = 0; r<6; r++) {
            //green
            for (int g=0; g<6; g++) {
                //blue
                for (int b = 0; b < 6; b++) {
                    //transparent colors
                    int rr = (r*255/5);
                    int gg = (g*255/5);
                    int bb= (b*255/5);

                    colours[index++] = rr << 16 | gg << 8 | bb;
                }
            }
        }
        screen = new Screen(WIDTH,HEIGHT, new SpriteSheet("/Gametest/Davidtest/hubworld/resources/Sprite_sheet.png"));
        input = new InputHandler(this);
    }
    private synchronized void start() {
        running = true;
        new Thread(this).start();
    }
    private synchronized void stop() {
        running = false;
    }

    public void run()//Method that will run as long as the program is on
     {
        long lastTime = System.nanoTime(); //returns the current value of nanoseconds
        double nsPerTick = 1000000000D/60D; //how many nanoseconds are within one tick

        int ticks = 0; //a variable for how many updates
        int frames = 0; //a variable for the current fps

        long lastTimer = System.currentTimeMillis(); //a variable for when to reset the data
        double delta = 0; //a variable of how many nano-seconds have gone by so far. Once it has hit 1 second, 1 will be subtracted

         init(); //calls the screen-render before the game-loop starts

        while (running) {
            long now = System.nanoTime(); //The current time that will be checked against lastTime
            delta += (now - lastTime) / nsPerTick; //subtract the current time with the last time and then divide the result with how many nanoseconds there are within a tick
            lastTime = now; //repeats the method by giving 'lastTime' the same value as 'now'
            boolean shouldRender = true;

            while (delta >= 1) {
                ticks++; //adds 1 to the ticks-value
                tick(); //calls the tick function
                delta -= 1; // subtract the value of delta by 1 and repeats the update-loop
                shouldRender = true;
            }

            try {
                //A 'sleep' method that pauses the current thread to keep it from overloading the system. in this case the frames are lowered based on the assigned sleep-value
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
                          }

            if (shouldRender) {
                frames++; //Adds to the frames by one
                render(); //calls render method
            }

            if (System.currentTimeMillis() - lastTimer > 1000) //If current time in milliseconds minus the time for the last update is greater than a thousand (one second): update.
            {
                lastTimer += 1000; //gives lastTimer the value of one second
                System.out.println(ticks + " ticks, " + frames + " frames");
                frames = 0; //reset value of frames
                ticks = 0; //reset value of updates
                //the variables will now be reset once every second instead of it all being presented rapidly
            }
        }
    }
    public void tick() //Updates the logic of the game
     {
         tickCount++;

         if (input.up.isPressed()) {
             screen.yOffset--;
         }
         if (input.down.isPressed()) {
             screen.yOffset++;
         }
         if (input.left.isPressed()) {
             screen.xOffset--;
         }
         if (input.right.isPressed()) {
             screen.xOffset++;
         }
     }

    public void render() //prints out what the logic in the tick-function has stated should be printed out
    {
        BufferStrategy bs = getBufferStrategy(); //an Object to organize the data in the canvas
        if (bs == null) {
            createBufferStrategy(3); //reducing tearing in the image. Higher value would require higher processing-power
            return;
        }
        for (int y = 0; y < 32; y++) {
            for (int x = 0; x < 32; x++) {
                screen.render(x<<3, y<<3, 0, Colours.get(555, 500, 050, 005));
            }
        }
        for (int y = 0; y< screen.height; y++) {
            for (int x = 0; x < screen.width; x++) {
                int colourCode = screen.pixels[x + y * screen.width];
                if (colourCode < 255) pixels[x + y * WIDTH] = colours[colourCode];
            }
        }
        Graphics g = bs.getDrawGraphics(); //a graphic-object
        g.drawRect(0,0,getWidth(),getHeight());
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        g.dispose(); //free up space
        bs.show();
    }
    public static void main(String[]args) {
        new Game().start();
    }
}
