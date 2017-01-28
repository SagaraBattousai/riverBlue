package com.riverBlue

import java.awt.{Color, Graphics, Graphics2D, Toolkit}
import java.awt.event.{ActionEvent, ActionListener, KeyAdapter, KeyEvent}
import javax.swing.{JPanel, Timer}

import scala.collection.mutable.ListBuffer

/**
  * Created by jam414 on 26/01/17.
  */

class Board extends JPanel with ActionListener {

  private val PLAYER_X = 40
  private val PLAYER_Y = 60
  private val DELAY = 10
  private val timer:Timer = new Timer(DELAY, this)
  private val player:Player = new Player(PLAYER_X, PLAYER_Y)

  addKeyListener(new TAdapter())
  setFocusable(true)
  setBackground(Color.BLACK)
  setDoubleBuffered(true)
  timer.start()

  @Override
  override def paintComponent(g: Graphics): Unit = {
    super.paintComponent(g)

    doDrawing(g)

    Toolkit.getDefaultToolkit().sync()
  }

  def doDrawing(g:Graphics): Unit = {
    val g2d = g.asInstanceOf[Graphics2D]
    g2d.drawImage(player.getImage, player.getX, player.getY, this)

    val ms: ListBuffer[Missile] = player.getMissiles

    for (m <- ms) {
      g2d.drawImage(m.getImage, m.getX, m.getY, this)
    }
  }


  @Override
  override def actionPerformed(e: ActionEvent) = {

    updateMissiles()
    updatePlayer()

    repaint()
  }

  def updateMissiles(): Unit = {

    val ms:ListBuffer[Missile] = player.getMissiles

    for (m <- ms) {
      if (m.isVisable) m.move() else ms -= m
    }
  }

  def updatePlayer():Unit = player.move()

  private class TAdapter extends KeyAdapter {

    @Override
    override def keyReleased(e: KeyEvent): Unit = player.keyReleased(e)

    @Override
    override def keyPressed(e: KeyEvent): Unit = player.keyPressed(e)
  }

}