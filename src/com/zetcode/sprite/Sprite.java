package com.zetcode.sprite;

import java.awt.Image;

public class Sprite {

    private boolean visible;
    private Image image;
    private boolean dying;

    int x;
    int y;
    int dx;

    public Sprite() {

        visible = true;
    }
  public void die() {

        visible = false;
    }
 
    public boolean isVisible() {

        return visible;
    }
