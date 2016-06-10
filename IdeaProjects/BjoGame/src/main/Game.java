package main;

import graphics.GamePanel;
import graphics.PixelDrawer;
import input.KeyboardInput;

/**
 * Created with IntelliJ IDEA.
 * User: Bjoern
 * Date: 08.04.13
 * Time: 20:59
 * To change this template use File | Settings | File Templates.
 */
public class Game {

  private GamePanel display;

  public static void main(String[] args){
    KeyboardInput keyInput = new KeyboardInput();
    PixelDrawer pixelDrawer = new PixelDrawer(GameStatics.WIDTH, GameStatics.HEIGHT);
    GamePanel gamePanel = new GamePanel(keyInput,pixelDrawer);
    gamePanel.start();
  }
}
