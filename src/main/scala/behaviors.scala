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
    case Group(shape) => size(shape)
    case Group(shape, shape1) => size(shape) + size(shape1)
    case Group(shape, shape1, shape2) => size(shape) + size(shape1) + size(shape2)
    case Group(shape: Seq[Shape]) => sum(shape)
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
    case Group(shape) => 1 + height(shape)
    case Group(shape, shape1) => 1 + maxHeight(List[Shape](shape,shape1))
    case Group(shape,shape1,shape2) => 1 + maxHeight(List[Shape](shape,shape1,shape2))
    case Group(shapes: Seq[Shape]) => 1 + maxHeight(shapes)


  }
  def rescaleGroup(shape: Seq[Shape], factor: Int, acc: List[Shape]): List[Shape] = shape match {
    case Nil => acc.reverse
    case n :: rest=> rescaleGroup(rest,factor,rescale(n,factor)::acc)
  }

  //how to rescale a shape:
  //create an empty sequence or list
  //go through the list of shapes and rescale each shape and add it to the list
  //then create a new group out of the sequence of lists


  def rescale(shape:Shape, factor: Int) : Shape = shape match{
    case Circle(c)=> Circle(c*factor)
    case Rectangle(width,height) => new Rectangle(width*factor,height*factor)
    case Ellipse(majorAxis,minorAxis) => Ellipse(majorAxis*factor,minorAxis*factor)
    case Location(x,y,shape) => shape match {
      case Circle(c) => Location(x,y,rescale(shape,factor))
      case Rectangle(width,height) => Location(x - (width/2)*(factor-1),y - (height/2)*(factor-1),rescale(shape,factor))
      case Ellipse(majorAxis,minorAxis)=> Location(x,y,rescale(shape,factor))
      case Group(shape3) => Location(x,y,rescale(shape,factor))
      case Group(shape3, shape1)=>Location(x,y,rescale(shape,factor))
      case Group(shape3,shape1,shape2)=>Location(x,y,rescale(shape,factor))
    }
    case Group(shape) =>Group(rescale(shape,factor))
    case Group(shape, shape1) => Group(rescaleGroup(Seq[Shape](shape,shape1),factor,List[Shape]()):_*)
    case Group(shape, shape1, shape2) =>Group(rescaleGroup(Seq[Shape](shape,shape1,shape2),factor,List[Shape]()):_*)
    case Group(shapes : Seq[Shape]) => Group(rescaleGroup(shapes, factor,List[Shape]()):_*) //Group(rescale(shape,factor),rescale(shape2,factor))
  }

}
