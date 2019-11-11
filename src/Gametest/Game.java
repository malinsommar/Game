package Gametest;

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

        while (running) {
            long now = System.nanoTime(); //The current time that will be checked against lastTime
            delta +=(now - lastTime) / nsPerTick; //subtract the current time with the last time and then divide the result with how many nanoseconds there are within a tick
            lastTime = now; //repeats the method by giving 'lastTime' the same value as 'now'
            boolean shouldRender = true;

            while (delta >= 1) {
                ticks++; //adds 1 to the ticks-value
                tick(); //calls the tick function
                delta -= 1; // subtract the value of delta by 1 and repeats the update-loop
                shouldRender = true;
            }

            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
                //A 'sleep' method that pauses the current thread to keep it from overloading the system. in this case the frames are lowered based on the assigned sleep-value
            }

            if (shouldRender) {
                frames++; //Adds to the frames by one
                render(); //calls render method
            }

            if (System.currentTimeMillis() - lastTimer > 1000) //If current time in milliseconds minus the time for the last update is greater than a thousand (one second): update.
            {
                lastTimer += 1000; //gives lastTimer the value of one second
                System.out.println(frames + " frames, " + ticks + " ticks");
                frames = 0; //reset value of frames
                ticks = 0; //reset value of updates
                //the variables will now be reset once every second instead of it all being presented rapidly
            }
        }
    }
    public void tick() //Updates the logic of the game
     {
         tickCount++;

         for (int i = 0; i<pixels.length; i++) {
             pixels[i] = i + tickCount;
     }
    }
    public void render() //prints out what the logic in the tick-function has stated should be printed out
    {
        BufferStrategy bs = getBufferStrategy(); //an Object to organize the data in the canvas
        if (bs == null) {
            createBufferStrategy(3); //reducing tearing in the image. Higher value would require higher processing-power
            return;
        }
        Graphics g = bs.getDrawGraphics(); //a graphic-object

        g.drawImage(image,0,0,getWidth(),getHeight(),null);

        g.dispose(); //free up space
        bs.show();
    }
    public static void main(String[]args) {
        new Game().start();
    }
}
