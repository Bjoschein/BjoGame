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
  private int width;
  private int height;
  private int arraySize;
  private Double multiplicator = 1.0;
  private Random random;


  public PixelDrawer(int width, int height) {
    this.width = width;
    this.height = height;
    arraySize = width * height;
    random = new Random();
    pixels = new int[arraySize];
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

  public void createFractal(){
    for(int y = 0; y < width; y++){
      for(int x = 0; x < height; x++){
        if(x==y){
          pixels[x*y] = 1221;
        } else {
          pixels[x*y] = 2233;
        }
      }
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
