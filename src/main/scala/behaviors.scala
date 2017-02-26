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
    case Group(shapes: Seq[Shape]) => sum(shapes)
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
    case Group(shapes: Seq[Shape]) => 1 + maxHeight(shapes)


  }
  def rescaleGroup(shape: Seq[Shape], factor: Int): Shape={
     val newShapes = shape.foldLeft(Seq[Shape]())((r,c)=> r :: rescale(c,factor))
    return Group(newShapes)
  }

  //how to rescale a shape:
  //create an empty sequence or list
  //go through the list of shapes and rescale each shape and add it to the list
  //then create a new group out of the sequence of lists


  def rescale(shape:Shape, factor: Int) : Shape = shape match{
    case Circle(c)=> Circle(c*factor)
    case Rectangle(width,height) => new Rectangle(width*factor,height*factor)
    case Ellipse(majorAxis,minorAxis) => Ellipse(majorAxis*factor,minorAxis*factor)
    case Location(x,y,shape) => Location(x*factor,y*factor,rescale(shape,factor))
    case Group(shapes: Seq[Shape]) => rescaleGroup(shapes, factor) //Group(rescale(shape,factor),rescale(shape2,factor))
  }

}
