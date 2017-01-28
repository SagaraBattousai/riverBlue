package com.riverBlue

import java.awt.Image
import java.awt.event.KeyEvent

import scala.collection.mutable.ListBuffer

/**
  * Created by Gengar on 27/01/2017.
  */
class Player(var u:Int, var v:Int) extends Sprite(u, v){

  private var dx:Int = 0
  private var dy:Int = 0
  private var missiles:ListBuffer[Missile] = ListBuffer()
  private var imgArray:Array[Array[Image]] = Array.ofDim[Image](4, 3)

  private val BASE_DIR = "resources/Blue/StandardCap/"
  private val UP_DIR = BASE_DIR + "Up"
  private val DOWN_DIR = BASE_DIR + "Down"
  private val LEFT_DIR = BASE_DIR + "Left"
  private val RIGHT_DIR = BASE_DIR + "Right"

  private val UP = 0
  private val DOWN = 1
  private val LEFT = 2
  private val RIGHT = 3

  private val STATIC = 0
  private val LEFT_LEG = 1
  private val RIGHT_LEG = 2

  loadImages()

  def loadImages(): Unit = {
    loadImage(UP_DIR + "/up_static.png")
    imgArray(UP)(STATIC) =  img

    loadImage(UP_DIR + "/up_left.png")
    imgArray(UP)(LEFT_LEG) =  img

    loadImage(UP_DIR + "/up_right.png")
    imgArray(UP)(RIGHT_LEG) =  img


    loadImage(DOWN_DIR + "/down_static.png")
    imgArray(DOWN)(STATIC) =  img

    loadImage(DOWN_DIR + "/down_left.png")
    imgArray(DOWN)(LEFT_LEG) =  img

    loadImage(DOWN_DIR + "/down_right.png")
    imgArray(DOWN)(RIGHT_LEG) =  img


    loadImage(LEFT_DIR + "/left_static.png")
    imgArray(LEFT)(STATIC) =  img

    loadImage(LEFT_DIR + "/left_left.png")
    imgArray(LEFT)(LEFT_LEG) =  img

    loadImage(LEFT_DIR + "/left_right.png")
    imgArray(LEFT)(RIGHT_LEG) =  img


    loadImage(RIGHT_DIR + "/right_static.png")
    imgArray(RIGHT)(STATIC) =  img

    loadImage(RIGHT_DIR + "/right_left.png")
    imgArray(RIGHT)(LEFT_LEG) =  img

    loadImage(RIGHT_DIR + "/right_right.png")
    imgArray(RIGHT)(RIGHT_LEG) =  img

    loadImage(DOWN_DIR + "/down_static.png")
    setImageDimensions()

  }

  def move(): Unit = {
    x += dx
    y += dy
  }

  def getMissiles:ListBuffer[Missile] = missiles

  def keyPressed(e:KeyEvent): Unit = {

    val key = e.getKeyCode

    key match {
      case KeyEvent.VK_LEFT  => dx = -1; img = imgArray(LEFT)(LEFT_LEG)
      case KeyEvent.VK_RIGHT => dx =  1; img = imgArray(RIGHT)(RIGHT_LEG)
      case KeyEvent.VK_UP    => dy = -1; img = imgArray(UP)(RIGHT_LEG)
      case KeyEvent.VK_DOWN  => dy =  1; img = imgArray(DOWN)(LEFT_LEG)
      case KeyEvent.VK_SPACE => fire()
      case _ =>
    }
  }

  def fire(): Unit = {
    println("x: " + x + ", y: " + y)
    missiles += new Missile(x + width, y + height / 2)
  }

    def keyReleased(e:KeyEvent): Unit = {

      val key = e.getKeyCode

      key match {
        case KeyEvent.VK_LEFT  => dx = 0; img = imgArray(LEFT)(STATIC)
        case KeyEvent.VK_RIGHT => dx = 0; img = imgArray(RIGHT)(STATIC)
        case KeyEvent.VK_UP    => dy = 0; img = imgArray(UP)(STATIC)
        case KeyEvent.VK_DOWN  => dy = 0; img = imgArray(DOWN)(STATIC)
        case _ =>
      }


  }





}
