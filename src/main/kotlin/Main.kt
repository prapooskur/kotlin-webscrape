@file:Suppress("MagicNumber")

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements


fun getWebData (inpurl: String) {
    val baseurl: String = "https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum="
    var url: String = baseurl+inpurl
    var locationCookie: String = inpurl.substring(0,2)

    val cookies = HashMap<String, String>()
    cookies["WebInaCartDates"] = ""
    cookies["WebInaCartLocation"] = locationCookie
    cookies["WebInaCartMeals"] = ""
    cookies["WebInaCartQtys"] = ""
    cookies["WebInaCartRecipes"] = ""

    var doc: Document = Jsoup.connect(url).cookies(cookies).get()
//    println(doc)
    var table: Elements = doc.select("table[width=100%][cellspacing=1][cellpadding=0][border=0]")

    var breakfast = table[0]
    var lunch = table[1]
    var dinner = table[2]
    var latenight = table[3]

    var rows: Elements = breakfast.select("tr")

    for (i in rows) {

    }

    println(rows)


}

fun main() {

    var ninelewis = "40&locationName=College+Nine%2fJohn+R.+Lewis+Dining+Hall&naFlag=1"
    var cowellstev = "05&locationName=Cowell%2fStevenson+Dining+Hall&naFlag=1"
    var crownmerrill = "20&locationName=Crown%2fMerrill+Dining+Hall&naFlag=1"
    var porterkresge = "25&locationName=Porter%2fKresge+Dining+Hall&naFlag=1"

    var locations = arrayOf(ninelewis,cowellstev,crownmerrill,porterkresge)

    getWebData(ninelewis)

}

