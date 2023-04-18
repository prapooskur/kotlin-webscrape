@file:Suppress("MagicNumber")

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


enum class Time {
    BREAKFAST,
    LUNCH,
    DINNER,
    LATENIGHT
}
fun getWebData (inputurl: String, time: Time) {
    val baseurl: String = "https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum="
    var url: String = baseurl+inputurl
    var locationCookie: String = inputurl.substring(0,2)

    val cookies = HashMap<String, String>()
    cookies["WebInaCartDates"] = ""
    cookies["WebInaCartLocation"] = locationCookie
    cookies["WebInaCartMeals"] = ""
    cookies["WebInaCartQtys"] = ""
    cookies["WebInaCartRecipes"] = ""

    var doc: Document = Jsoup.connect(url).cookies(cookies).get()
//    println(doc)
    var table: Elements = doc.select("table[width=100%][cellspacing=1][cellpadding=0][border=0]")


    val timechoice = time.ordinal

    var rows: Elements = table[timechoice].select("tr")
    var trs: Elements = rows.select("tr")
//    println("start")



    //START UNNEST HERE
    var listItems = mutableListOf<String>()
    for (j in trs) {
//        println(j)
//        println("start")
        var separators: String = j.select("span[style=\"color: #000000\"]").toString()
        var items: String = j.select("span[style=\"color: #585858\"]").toString()
//            print(items)
        if (separators.length > 29 && !separators.contains("&nbsp;")) {
            var cleanSeparator = separators.substring(29, separators.length - 7)
            println(cleanSeparator)
        }
        if (items.length > 42 && items !in listItems) {
            var cleanItem = items.substring(29, items.length - 13)
            if (!listItems.contains(cleanItem)) {
//                println("add")
                println(cleanItem)
                listItems.add(cleanItem)
            }
        }
    }
    //END LOOP

    var flattenList = mutableListOf<String>()
    var count = 0
    for (i in listItems) {
        if (i !in flattenList) {
            flattenList.add(i)
        }
    }

/*
    for (i in rows) {
        var tr: Elements = i.select("tr")



        var listItems = mutableListOf<String>()
        for (j in tr) {
            println(j)
            println("asdf")
            var separators: String = j.select("span[style=\"color: #000000\"]").toString()
            var items: String = j.select("span[style=\"color: #585858\"]").toString()
//            print(items)
            if (separators.length > 29 && !separators.contains("&nbsp;")) {
//                println(separators.substring(29, separators.length - 7))
            }
            if (items.length > 42 && items !in listItems) {
                var cleanItem = items.substring(29, items.length - 13)
                if (!listItems.contains(cleanItem)) {
//                    println("1")
 //                   println(cleanItem)
                    listItems.add(cleanItem)
                }
            }
        }
        //END LOOP

        var flattenList = mutableListOf<String>()
        var count = 0
        for (i in listItems) {
            if (i !in flattenList) {
                flattenList.add(i)
            }
        }


//        print(listItems)



    }


 */

    //println(rows)


}

fun main() {
    var ninelewis = "40&locationName=College+Nine%2fJohn+R.+Lewis+Dining+Hall&naFlag=1"
    var cowellstev = "05&locationName=Cowell%2fStevenson+Dining+Hall&naFlag=1"
    var crownmerrill = "20&locationName=Crown%2fMerrill+Dining+Hall&naFlag=1"
    var porterkresge = "25&locationName=Porter%2fKresge+Dining+Hall&naFlag=1"

    var locations = arrayOf(ninelewis,cowellstev,crownmerrill,porterkresge)

    println("Breakfast")
    getWebData(cowellstev, Time.BREAKFAST)
    println()
    println("Lunch")
    getWebData(cowellstev, Time.LUNCH)
    println()
    println("Dinner")
    getWebData(cowellstev, Time.DINNER)
    println()
    println("Late Night")
    getWebData(cowellstev, Time.LATENIGHT)

}

