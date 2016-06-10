package graphics;

import main.GameStatics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


/**
 * Created with IntelliJ IDEA.
 * User: Bjoern
 * Date: 08.04.13
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
public class GamePanel extends Canvas implements Runnable {

  private final String TITLE = "myGame";
  private int[] pixels;
  private Double multiplicator = 1.0;
  private int width;
  private int height;
  private Thread animator;
  private JFrame frame;
  private boolean running = false;
  private BufferedImage image;
  private PixelDrawer pixelDrawer;

  public GamePanel(KeyListener keyInput, PixelDrawer pixelDrawer) {

    this.pixelDrawer = pixelDrawer;
    width = GameStatics.WIDTH;
    height = GameStatics.HEIGHT;
    Dimension size = GameStatics.DIMENSION;
    setPreferredSize(size);

    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    frame = new JFrame();
    frame.setResizable(false);
    frame.setTitle(TITLE);
    frame.add(this);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setFocusable(true);
    frame.requestFocus();
    frame.addKeyListener(keyInput);
  }


  public void start() {
    animator = new Thread(this);
    animator.start();
    running = true;
  }

  public void stop() {
    running = false;
    try {
      animator.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {

    double beforeCycle;
    double afterCycle;
    double timePassedSinceLastCycle = .0d;

    while (running) {

      beforeCycle = System.nanoTime();
      update();

      if(timePassedSinceLastCycle>60){
        render();
        timePassedSinceLastCycle = .0d;
      }

      afterCycle = System.nanoTime()-beforeCycle;
      timePassedSinceLastCycle += (afterCycle / (1000 * 1000));
    }
  }

  private void update() {
//    if(multiplicator > height){
//      multiplicator = 0.;
//    }
  }

  private void render() {
    BufferStrategy bs = getBufferStrategy();
    if (bs == null) {
      createBufferStrategy(2);
      return;
    }

    multiplicator += 9;
    pixelDrawer.getRandomPixels();
    pixelDrawer.setMultiplicator(multiplicator);
    if(multiplicator > 93){
      multiplicator = 0.;
    }
    System.out.println(multiplicator);

    for (int i = 0; i < pixels.length; i++) {
      pixels[i] = pixelDrawer.getPixels()[i];
    }

    Graphics g = bs.getDrawGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    bs.show();
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }
}
