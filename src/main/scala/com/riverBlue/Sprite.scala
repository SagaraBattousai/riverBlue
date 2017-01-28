package com.riverBlue

import java.awt.Image
import javax.swing.ImageIcon

/**
  * Created by Gengar on 28/01/2017.
  */
class Sprite(_x:Int, _y:Int) {

//  def this(x:Int, y:Int) {
//    this(x,y,true)
//  }

  protected var x:Int = _x
  protected var y:Int = _y
  protected var width:Int = 0
  protected var height:Int = 0
  protected var vis:Boolean = true
  protected var img:Image = _

  def getImage:Image = img

  def getX:Int = x

  def getY:Int = y

  def isVisable:Boolean = vis

  def setVisable(visable:Boolean): Unit = vis = visable

  protected def loadImage(imgName:String): Unit ={

    val ii = new ImageIcon(imgName)
    img = ii.getImage
  }

  protected def setImageDimensions(): Unit = {

    width = img.getWidth(null)
    height = img.getHeight(null)

  }







}
