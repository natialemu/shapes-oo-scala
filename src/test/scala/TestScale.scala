import edu.luc.cs.laufer.cs372.shapes._
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
    assert(newShape === Location(30,-30,Rectangle(160,240)))
  }

  test("basic group rescaling test") {
    val newShape = rescale(basicGroup,2)
    assert(newShape === Group(Ellipse(100,60),Rectangle(40,80)))
  }

  test("simple group rescaling test") {
    val newShape = rescale(simpleGroup,2)
    assert(  newShape === Group( Location(200,100,Ellipse(100,60)), Location(400 - 50,300 -25,Rectangle(200,100))))
  }
  test("complex group rescaling test") {
    val newShape = rescale(complexGroup,2)
    val expectedShape = Location(50,100, Group(
      Ellipse(40,80),
      Location(150,50,
        Group(
          Rectangle(100,60),
          Rectangle(600,120),
          Location(100,200,
            Ellipse(100,60)
          )
        )
      ),
      Rectangle(200,400)
    ))
    assert(newShape === expectedShape)
  }



}
