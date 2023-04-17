@file:Suppress("MagicNumber")

import org.jsoup.Jsoup
import org.jsoup.nodes.Document


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
    println(doc)
}

fun main() {
    val BASE_URL="https://nutrition.sa.ucsc.edu/shortmenu.aspx?sName=UC+Santa+Cruz+Dining&locationNum="

    var ninelewis = "40&locationName=College+Nine%2fJohn+R.+Lewis+Dining+Hall&naFlag=1"
    var cowellstev = "05&locationName=Cowell%2fStevenson+Dining+Hall&naFlag=1"
    var crownmerrill = "20&locationName=Crown%2fMerrill+Dining+Hall&naFlag=1"
    var porterkresge = "25&locationName=Porter%2fKresge+Dining+Hall&naFlag=1"

    var locations = arrayOf(ninelewis,cowellstev,crownmerrill,porterkresge)

    getWebData(ninelewis)

}

