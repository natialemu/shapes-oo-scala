import org.scalatest.FunSuite

import edu.luc.cs.laufer.cs372.shapes.TestFixtures._
import edu.luc.cs.laufer.cs372.shapes._

class TestBoundingBox extends FunSuite {

  def testBoundingBox(description: String, s: Shape, x: Int, y: Int, width: Int, height: Int) = {
    test(description) {
      val b = boundingBox(s)
      val r = b.shape.asInstanceOf[Rectangle]
      assert(x === b.x)
      assert(y === b.y)
      assert(width === r.width)
      assert(height === r.height)
    }
  }
  def testMin(description: String, s: Shape, minx: Int, miny: Int, maxX: Int, maxY: Int)={
    test(description){
      assert(boundingBox.getMinx(s) === minx)
      assert(boundingBox.getMiny(s) == miny)
      assert(boundingBox.getMaxy(s) == maxY)
      assert(boundingBox.getMaxx(s) == maxX)

    }

  }


  testMin("test Min of group", basicGroup,-50,-30,50,40)
  // TODO comment these tests back in

  testBoundingBox("simple ellipse", simpleEllipse, -50, -30, 100, 60)
  testBoundingBox("simple rectangle", simpleRectangle, 0, 0, 80, 120)
  testBoundingBox("simple location", simpleLocation, 70, 30, 80, 120)
  testBoundingBox("basic group", basicGroup, -50, -30, 100, 70)
  testBoundingBox("simple group", simpleGroup, 150, 70, 350, 280)
  testBoundingBox("complex group", complexGroup, 30, 60, 470, 320)
}
