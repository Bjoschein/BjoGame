/**
 * PixelDrawer.java  
 *
 * Creator:
 * 10.04.13 21:47 Bjoern
 *
 * Maintainer:
 * 10.04.13 21:47 Bjoern
 *
 * Last Modification:
 * $Id: $
 *
 * Copyright (c) 2003 ABACUS Research AG, All Rights Reserved
 */
package graphics;

import main.GameStatics;

import java.util.Random;

public class PixelDrawer {
  private int[] pixels;
  private int arraySize;
  private Double multiplicator = 1.0;
  private Random random;


  public PixelDrawer(int width, int height) {
    arraySize = width * height;
    random = new Random();
  }

  // Strategy-Pattern hier :)
  public void getRandomPixels() {
    pixels = new int[arraySize];
    int j = 0;
    for (int i = 0; i < arraySize; i++) {
//      pixels[i] = (int)(i * multiplicator);
      j++;
      if (i % (100) == multiplicator) {
        j = 0;
      }
      pixels[i] = j;
    }
  }

  public int[] getPixels() {
    return pixels;
  }

  public void setMultiplicator(Double multiplicator) {
    this.multiplicator = multiplicator;
  }

  public Double getMultiplicator(){
    return multiplicator;
  }
}
