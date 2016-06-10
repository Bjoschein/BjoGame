/**
 * KeyboardInput.java  
 *
 * Creator:
 * 24.04.13 20:48 Bjoern
 *
 * Maintainer:
 * 24.04.13 20:48 Bjoern
 *
 * Last Modification:
 * $Id: $
 *
 * Copyright (c) 2003 ABACUS Research AG, All Rights Reserved
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println(e.getKeyChar());
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(e.getKeyChar());
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(e.getKeyChar());
  }

}
