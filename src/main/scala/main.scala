def calc(order: List[String]): Double = {

  if order.isEmpty then return 0.0      // if list is empty (edge case)

  val menu = Map (                        // MenuItem: (price, serviceChargePercent)
    "Cola" -> (0.5, 0.0),
    "Coffee" -> (1.0, 0.0),
    "Cheese Sandwich" -> (2.0, 0.1),
    "Steak Sandwich" -> (4.50, 0.2),
  )

  val orderZip = order.map(x => menu.getOrElse(x, (0.0, 0.0)))  // Zip each item in order[] with it's key:value in the Map()  ->  List((0.5,0.0), (1.0,0.0), (2.0,0.1))

  val base: List[Double] = orderZip.map(_._1)                   // Get only the price of each item  ->  List(0.5, 1.0, 2.0)
  val baseCharge = base.sum

  val servicePercent = orderZip.maxBy(_._2)._2                         // Calc % of service, by finding max % in list  ->  0.1

  baseCharge * servicePercent match {
    case svcCharge if svcCharge > 20.0 => baseCharge + 20      // if service charge > 20 -> return base + 20
    case svcCharge => baseCharge + svcCharge
  }

}


@main
def main(): Unit = {
  val order = List("Cola", "Coffee", "Cheese Sandwich")
  printf("My order cost: %.2f", calc(order))

}