@file:Suppress("MagicNumber")
import Time
import getWebData

fun main() {
    var ninelewis = "40&locationName=College+Nine%2fJohn+R.+Lewis+Dining+Hall&naFlag=1"
    var cowellstev = "05&locationName=Cowell%2fStevenson+Dining+Hall&naFlag=1"
    var crownmerrill = "20&locationName=Crown%2fMerrill+Dining+Hall&naFlag=1"
    var porterkresge = "25&locationName=Porter%2fKresge+Dining+Hall&naFlag=1"

    var locations = arrayOf(ninelewis,cowellstev,crownmerrill,porterkresge)

    var choice=locations[0]

//    println("Breakfast")
    val breakfastmenu = getWebData(choice, Time.BREAKFAST)
    for (i in breakfastmenu) {
        println(i)
    }
    println()
    val lunchmenu = getWebData(choice, Time.LUNCH)
    for (i in lunchmenu) {
        println(i)
    }
    println()
    val dinnermenu = getWebData(choice, Time.DINNER)
    for (i in dinnermenu) {
        println(i)
    }
    println()
    val latenightmenu = getWebData(choice, Time.LATENIGHT)
    for (i in latenightmenu) {
        println(i)
    }
    /*
    println()
    println("Lunch")
    getWebData(choice, Time.LUNCH)
    println()
    println("Dinner")
    getWebData(choice, Time.DINNER)
    println()
    println("Late Night")
    getWebData(choice, Time.LATENIGHT)
    */
}

