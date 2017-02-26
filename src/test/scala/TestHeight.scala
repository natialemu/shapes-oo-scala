import edu.luc.cs.laufer.cs372.shapes.Shape
import edu.luc.cs.laufer.cs372.shapes.TestFixtures._
import edu.luc.cs.laufer.cs372.shapes.behaviors._
import org.scalatest.FunSuite


/**
  * Created by Nathnael on 2/25/2017.
  */
class TestHeight extends FunSuite{
  def testHeight(description: String, s: Shape, sz : Int) = {
    test(description) {


      //val r = b.shape.asInstanceOf[Rectangle]
      assert(height(s) == sz)
    }
  }

  // TODO comment these tests back in

  testHeight("simple ellipse", simpleEllipse, 1)
  testHeight("simple rectangle", simpleRectangle, 1)
  testHeight("simple location", simpleLocation, 1)
  testHeight("basic group", basicGroup, 2)
  testHeight("simple group", simpleGroup, 2)
  testHeight("complex group", complexGroup, 3)

}
