package com.riverBlue

/**
  * Created by jam414 on 26/01/17.
  */

import java.awt._
import javax.swing.{ImageIcon, JPanel}

class ThreadBoard extends JPanel with Runnable {

  val B_WIDTH = 350
  val B_HEIGHT = 350
  val INIT_X = -40
  val INIT_Y = -40
  val DELAY = 25


  var img: Image = _
  var animator: Thread = _
  var xCoord: Int = 0
  var yCoord: Int = 0


  initBoard()

  def initBoard(): Unit = {

    setBackground(Color.BLACK)
    setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT))
    setDoubleBuffered(true)

    loadImage()

    xCoord = INIT_X
    yCoord = INIT_Y

  }

  def loadImage(): Unit = {
    val ii = new ImageIcon("resources/Blue/StandardCap/Down/down_static.png")
    img = ii.getImage
  }

  @Override
  override def paintComponent(graphics: Graphics) {
    super.paintComponent(graphics)

    drawStar(graphics)
  }

  def drawStar(graphics: Graphics) = {
    graphics.drawImage(img, xCoord, yCoord, this)
    Toolkit.getDefaultToolkit().sync()

  }

  override def addNotify(): Unit = {
    super.addNotify()

    animator = new Thread(this)
    animator.start()
  }

  def cycle(): Unit = {
    xCoord += 1
    yCoord += 1

    if (yCoord > B_HEIGHT) {

      yCoord = INIT_Y
      xCoord = INIT_X
    }
  }

  @Override
  def run(): Unit = {

    var beforeTime: Long = System.currentTimeMillis()
    var timeDiff: Long = 0
    var sleep: Long = 0

    while (true) {
      cycle()
      repaint()

      timeDiff = System.currentTimeMillis() - beforeTime
      sleep = DELAY - timeDiff

      if (sleep < 0) sleep = 0

      try {
        Thread.sleep(sleep)
      } catch {
        case e: InterruptedException => println("Interupted: " + e.getMessage())
      }

      beforeTime = System.currentTimeMillis()
    }
  }

}
