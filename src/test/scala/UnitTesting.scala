import org.scalatest.funsuite.AnyFunSuite

class UnitTesting extends AnyFunSuite {

  test("Non-max service charge"){
    val order = List("Cola", "Coffee", "Cheese Sandwich")
    assert(calc(order) == 3.85)
  }

  test("Max service charge"){
    val order = List.fill(40)("Steak Sandwich")
    assert(calc(order) == 200.0)
  }

  test("Empty List"){
    assert(calc(List()) == 0.0)
  }

}