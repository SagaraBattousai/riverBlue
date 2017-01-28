package com.riverBlue

/**
  * Created by Gengar on 28/01/2017.
  */
class Missile(var u:Int, var v:Int) extends Sprite(u, v) {

  private val BOARD_WIDTH = 390
  private val MISSILE_SPEED = 2

  loadImage("resources/Blue/StandardCap/Right/right_static.png")
  setImageDimensions()

  def move(): Unit = {
    x += MISSILE_SPEED

    if (x > BOARD_WIDTH) vis = false

  }



}
