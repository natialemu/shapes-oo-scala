import edu.luc.cs.laufer.cs372.shapes.{Ellipse, Rectangle, Shape}
import edu.luc.cs.laufer.cs372.shapes.TestFixtures._
import edu.luc.cs.laufer.cs372.shapes.behaviors._
import org.scalatest.FunSuite

/**
  * Created by Nathnael on 2/25/2017.
  */
class TestScale extends FunSuite{

    test("simple ellipse rescale test") {
      val newShape = rescale(simpleEllipse,2)
      assert(newShape === Ellipse(simpleEllipse.majorAxis*2,simpleEllipse.minorAxis*2))
    }

  test("simple rectangle rescale test") {
    val newShape = rescale(simpleRectangle,2)
    assert(newShape === Rectangle(simpleRectangle.width*2,simpleRectangle.height*2))
  }

  test("simple location rescale test") {
    val newShape = rescale(simpleLocation,2)
    assert(newShape === Ellipse(simpleEllipse.majorAxis*2,simpleEllipse.minorAxis*2))
  }

  test("basic group rescaling test") {
    val newShape = rescale(basicGroup,2)
    assert(newShape === Ellipse(simpleEllipse.majorAxis*2,simpleEllipse.minorAxis*2))
  }

  test("simple group rescaling test") {
    val newShape = rescale(simpleGroup,2)
    assert(newShape === Ellipse(simpleEllipse.majorAxis*2,simpleEllipse.minorAxis*2))
  }
  test("complex group rescaling test") {
    val newShape = rescale(complexGroup,2)
    assert(newShape === Ellipse(simpleEllipse.majorAxis*2,simpleEllipse.minorAxis*2))
  }



}
