package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Location(x,y,shape)=> Location(x, y, shape) // not yet implemented
    case Rectangle(width,height) => Location(0,0,Rectangle(width,height))
    case Ellipse(majorAxis,minorAxis)=>Location(-majorAxis,-minorAxis,Rectangle(majorAxis*2,minorAxis*2))
    case Circle(radius)=>Location(-radius,-radius,Rectangle(2*radius,2*radius))
    case Group(shape,shape2) => groupBoundingBox(Group(shape,shape2))
  }

  def groupBoundingBox(group : Group): Location={
  return Location(getMinx(group),getMiny(group),Rectangle(getMaxx(group)-getMinx(group),getMaxy(group)-getMinx(group)))
  }

  def getMinx(shape: Shape): Int= shape match{
    case Group(shape,shape2) => Math.min(apply(shape).x,apply(shape2).x)

  }

  def getMiny(shape: Shape): Int=shape match{
    case Group(shape,shape2) => Math.min(apply(shape).y,apply(shape2).y)
  }
  def getMaxx(shape: Shape): Int=shape match{
    case Group(shape,shape2) => Math.min(apply(shape).x + (Rectangle)(apply(shape)).width,apply(shape2).x + (Rectangle)(apply(shape2)).width )
  }

  def getMaxy(shape: Shape): Int=shape match{
    case Group(shape,shape2) => Math.min(apply(shape).y + (Rectangle)(apply(shape)).height,apply(shape2).y +(Rectangle)(apply(shape2)).height)
  }


}
