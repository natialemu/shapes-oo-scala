package edu.luc.cs.laufer.cs372.shapes

/**
 * data Shape = Rectangle(w, h) | Location(x, y, Shape)
 */
sealed trait Shape

case class Rectangle(width: Int, height: Int) extends Shape

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  require(shape != null, "null shape in location")
}

case class Ellipse(majorAxis: Int, minorAxis: Int) extends Shape{
  require(majorAxis >= 0,"invalid value for major axis")
  require(minorAxis >=0,"invalid value for the minor axis")
}

case class Circle(radius : Int) extends Shape{
  require(radius >=0,"invalid value for the radius")
}

case class Group(shape1: Shape*) extends Shape{
  require(shape1 != null,"a group must be composed of shapes")

}


// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
