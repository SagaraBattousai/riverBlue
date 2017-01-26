package com.riverBlue

/**
  * Created by jam414 on 26/01/17.
  */

import java.awt._
import java.awt.geom.{AffineTransform, Ellipse2D}
import javax.swing.JPanel

class GraphicsBoard extends JPanel {

  @Override
  override def paintComponent(graphics: Graphics): Unit = {
    super.paintComponent(graphics)

    drawDonut(graphics)
  }

  def drawDonut(graphics: Graphics): Unit = {
    val g2d:Graphics2D = graphics.asInstanceOf[Graphics2D]
    val rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON)

    rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)

    g2d.setRenderingHints(rh)

    val size:Dimension = getSize
    val w = size.getWidth
    val h = size.getHeight

    val e = new Ellipse2D.Double(0,0,80,130)
    g2d.setStroke(new BasicStroke(1))
    g2d.setColor(Color.GREEN)

    for(deg <- 0.0 to 360.0 by 5 ){
      val at = AffineTransform.getTranslateInstance(w/2, h/2)
      at.rotate(Math.toRadians(deg))
      g2d.draw(at.createTransformedShape(e))

    }


  }


}
