import edu.luc.cs.laufer.cs372.shapes.TestFixtures.{simpleLocation, simpleRectangle}
import edu.luc.cs.laufer.cs372.shapes.{Rectangle, Shape, boundingBox}
import org.scalatest.FunSuite
import edu.luc.cs.laufer.cs372.shapes.behaviors._
import edu.luc.cs.laufer.cs372.shapes.TestFixtures._

/**
  * Created by Nathnael on 2/25/2017.
  */
class TestSize extends FunSuite{

  def testSize(description: String, s: Shape, sz : Int) = {
    test(description) {


      //val r = b.shape.asInstanceOf[Rectangle]
      assert(size(s) == sz)
    }
  }

  // TODO comment these tests back in

  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group", basicGroup, 2)
  testSize("simple group", simpleGroup, 2)
  testSize("complex group", complexGroup, 5)

}
