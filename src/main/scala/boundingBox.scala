package edu.luc.cs.laufer.cs372.shapes

// TODO: implement this behavior

object boundingBox {
  def apply(s: Shape): Location = s match {
    case Location(x,y,shape)=> Location(x+apply(shape).x,y+apply(shape).y,apply(shape).shape)
    case Rectangle(width,height) => Location(0,0,Rectangle(width,height))
    case Ellipse(majorAxis,minorAxis)=>Location(-majorAxis,-minorAxis,Rectangle(majorAxis*2,minorAxis*2))
    case Circle(radius)=>Location(-radius,-radius,Rectangle(2*radius,2*radius))
    case Group(shape,shape2) => groupBoundingBox(Group(shape,shape2))
    case Group(shape) => groupBoundingBox(Group(shape))
    case Group(shape,shape2,shape3) => groupBoundingBox(Group(shape,shape2,shape3))
  }

  def groupBoundingBox(group : Group): Location={
  return Location(getMinx(group),getMiny(group),Rectangle(getMaxx(group)-getMinx(group),getMaxy(group)-getMiny(group)))
  }

  def getMinx(shape: Shape): Int= shape match{
    case Group(shape,shape2) => Math.min(apply(shape).x,apply(shape2).x)
    case Group(shape,shape2,shape3) => {
      List[Shape](shape,shape2,shape3).foldLeft{(10000)}{case (minimum, next)=>
        math.min(minimum,apply(next).x)
      }
    }

  }

  def getMiny(shape: Shape): Int=shape match{
    case Group(shape,shape2) => Math.min(apply(shape).y,apply(shape2).y)
    case Group(shape,shape2,shape3) => {
      List[Shape](shape,shape2,shape3).foldLeft{(10000)}{case (minimum, next)=>
        math.min(minimum,apply(next).y)
      }
    }
  }
  def getMaxx(shape: Shape): Int=shape match{
    case Group(shape,shape2) => {
      //val r = b.shape.asInstanceOf[Rectangle]
      val shapeRectangle = apply(shape).shape.asInstanceOf[Rectangle]
      val shape2Rectangle = apply(shape2).shape.asInstanceOf[Rectangle]
      Math.max(apply(shape).x + shapeRectangle.width, apply(shape2).x + shape2Rectangle.width )
    }
    case Group(shape,shape2,shape3) => {
      List[Shape](shape,shape2,shape3).foldLeft{(0)}{case (minimum, next)=>
        val shapeRectangle = apply(next).shape.asInstanceOf[Rectangle]

        math.max(minimum,apply(next).x + shapeRectangle.width)
      }
    }
  }

  def getMaxy(shape: Shape): Int=shape match{

    case Group(shape,shape2) => {
      val shapeRectangle = apply(shape).shape.asInstanceOf[Rectangle]
      val shape2Rectangle = apply(shape2).shape.asInstanceOf[Rectangle]
      Math.max(apply(shape).y + shapeRectangle.height,apply(shape2).y +shape2Rectangle.height)
    }
    case Group(shape,shape2,shape3) => {
      List[Shape](shape,shape2,shape3).foldLeft{(0)}{case (minimum, next)=>
        val shapeRectangle = apply(next).shape.asInstanceOf[Rectangle]

        math.max(minimum,apply(next).y + shapeRectangle.height)
      }
    }
  }


}
