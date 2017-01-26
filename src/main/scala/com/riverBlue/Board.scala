package com.riverBlue

/**
  * Created by jam414 on 26/01/17.
  */

import java.awt.geom.{AffineTransform, Ellipse2D}
import java.awt._
import javax.swing.{ImageIcon, JPanel}

class Board extends JPanel {

  var img:Image = null

  initBoard()

  def initBoard(): Unit ={

    loadImage()

    val w = img.getWidth(this)
    val h = img.getHeight(this)
    setPreferredSize(new Dimension(w, h))
  }

  def loadImage(): Unit = {
    val ii = new ImageIcon("resources/Blue/StandardCap/Static/down.png")
    img = ii.getImage
  }

  @Override
  override def paintComponent(graphics: Graphics) {
    graphics.drawImage(img, 0, 0, null)
  }

}
