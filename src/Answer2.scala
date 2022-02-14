import scala.collection.mutable.ArrayBuffer
import scala.collection.immutable.ListMap




object Answer2 extends App {

  val sample_data = ArrayBuffer[Array[String]]()

  val readingSource = io.Source.fromFile("/Users/ranadilendrasingh/code/IdeaProjects/Scala_Assignment/my_sample_data_scala.csv")  // accessing data from a csv file
  for (data <- readingSource.getLines.drop(1)) {
    sample_data +=data.split(",").map(_.trim)
  }

  readingSource.close() //closing file


  // Q-1)- player with max(highest) runs

  var max_runs=0
  var index=0
  for (j <- 0 until sample_data.length-1){
    if (sample_data(j)(4).toInt > max_runs)
    {
      max_runs=sample_data(j)(4).toInt
      index=j
    }
  }
  println( "Player with the best highest run scored is \n")
  println(s" ${sample_data(index)(1)} with max runs ${sample_data(index)(4)} ")



  // Q-2)  top 5 players with highest scores

  println("\nTop 5 players by run scored : ")

  val player_score = scala.collection.mutable.Map.empty[String,Int]
  for (i <- 0 until sample_data.length-1){
    player_score+=(sample_data(i)(1)->sample_data(i)(4).toInt)
  }

  var player_score_sorted = ListMap(player_score.toSeq.sortWith(_._2 > _._2):_*) // sort the map according to values and in descending order

  var n=5 //number of player we want as output
  for((k,v) <- player_score_sorted if n>0)
  {
    println(s" $k scored $v ")
    n=n-1
  }

  // Q-3)- top 5 players with highest wicket

  println("\nTop 5 players by wicket taken :")

  val player_wickets = scala.collection.mutable.Map.empty[String,Int]
  for (i <- 0 until sample_data.length-1){
    player_wickets+=(sample_data(i)(1)->sample_data(i)(5).toInt)
  }

  var player_wickets_sorted= ListMap(player_wickets.toSeq.sortWith(_._2 > _._2):_*)

  n=5 //number of player we want as output
  for((k,v) <- player_wickets_sorted if n>0)
  {
    println(s" $k have taken $v wickets")
    n=n-1
  }


  // Q-4)- rank each player according to overall performance

  println("\n Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored: ")

  val player_rank = scala.collection.mutable.Map.empty[String,Int]
  for (i <- 0 to sample_data.length-1){
    player_rank+=(sample_data(i)(1)->(sample_data(i)(5).toInt*5 + sample_data(i)(4).toInt*.05).toInt)
  }

  var player_rank_sorted =ListMap(player_rank.toSeq.sortWith(_._2 > _._2):_*)
  var position=1

  //all player we want as output according to rank, greater rank means great performance
  for((k,v) <- player_rank_sorted )
  {
    println(s" $k rank $v ")
  }


}
