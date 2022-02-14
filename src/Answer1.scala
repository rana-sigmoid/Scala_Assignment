import scala.math.BigDecimal.double2bigDecimal

object Answer1 extends App{

  //array making by ending index
  val arr=(0.049d until 100.050d by 0.050d).toArray

  val n = arr.size
  print("number of value you want check \n")
  var number_of_check=scala.io.StdIn.readInt()
  while(number_of_check>0)
  {
    print("Enter the value ")
    val value=scala.io.StdIn.readDouble()

    //edge case
    if(value<0 || value>100.049)
      print("Please enter value in range (0 - 100.049) \n")

    else {
      val end_index = binary_search(arr, n, BigDecimal(value))
      print("the range is ")

      println(s"${arr(end_index)-0.049} - ${arr(end_index)}")    // printing the required range
      number_of_check = number_of_check - 1
    }
  }

  //getting upper range index of value
  def binary_search(arr:Array[BigDecimal],size:Int,value:BigDecimal):Int={

    var start=0
    var end=size-1
    while(start<end)
    {
      val mid = (start + (end - start) / 2)
      if(arr(mid)>=value)
        end=mid
      else
        start=mid+1
    }
    return start
  }
}
