package edu.luc.cs.laufer.cs372.shapes



import edu.luc.cs.laufer.cs372.shapes._

/**
  * Created by Nathnael on 2/25/2017.
  */

object behaviors {

  def size(shape:Shape) : Int = shape match{
    case Circle(c)=> 1
    case Rectangle(width,height) => 1
    case Ellipse(majorAxis,minorAxis) => 1
    case Location(x,y,shape) => size(shape)
    case Group(shapes@_*) => sum(shapes)
  }

  def sum(shape: Seq[Shape]): Int ={
    return shape.foldLeft{(0)}{case ((sum),next)=>
       sum + size(next)
    }
  }
  def maxHeight(shape: Seq[Shape]): Int ={
    return shape.foldLeft{(0)}{case ((maximum),next)=>
      math.max(maximum,height(next))
    }
  }




  def height(shape:Shape) : Int = shape match{
    case Circle(c)=> 1
    case Rectangle(width,height) => 1
    case Ellipse(majorAxis,minorAxis) => 1
    case Location(x,y,shape) => 1 + height(shape)
    case Group(shapes@_*) => 1 + maxHeight(shapes)


  }
  def rescaleGroup(factor: Int, acc: List[Shape], shape: Seq[Shape]): List[Shape] = shape match {
    case Nil => acc.reverse
    case n :: rest=> rescaleGroup(factor,rescale(n,factor)::acc,rest)
  }



  def rescale(shape:Shape, factor: Int) : Shape = shape match{
    case Circle(c)=> Circle(c*factor)
    case Rectangle(width,height) => new Rectangle(width*factor,height*factor)
    case Ellipse(majorAxis,minorAxis) => Ellipse(majorAxis*factor,minorAxis*factor)
    case Location(x,y,shape) => shape match {
      case Circle(c) => Location(x,y,rescale(shape,factor))
      case Rectangle(width,height) => Location(x - (width/2)*(factor-1),y - (height/2)*(factor-1),rescale(shape,factor))
      case Ellipse(majorAxis,minorAxis)=> Location(x,y,rescale(shape,factor))
      case Group(shapes@_*) => Location(x,y,rescale(shape,factor))
    }
    case Group(shapes@_*) => Group(rescaleGroup(factor,List[Shape](),Seq(shapes:_*)):_*)
  }

}
