package com.riverBlue

import java.awt.EventQueue
import javax.swing.{JFrame, JPanel}

/**
  * Created by jam414 on 26/01/17.
  */
object RiverBlue extends JFrame{

  initUI()

  def initUI(): Unit = {

    add(new Board)

    setSize(400, 300)
    setResizable(false)

    setTitle("River Blue")
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
    setLocationRelativeTo(null)
  }

  def main(args:Array[String]): Unit = {
    EventQueue.invokeLater(new Runnable() {
      @Override
      override def run(): Unit = {
        val ex = RiverBlue
        ex.setVisible(true)
      }
    })
  }


}
