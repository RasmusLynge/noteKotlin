package Lambda

// Eksempel på et Android layout genereret hve hjælp af DSL med lambda med receivers.

// Et statisk android layout er laver med XML og vi vil her lave et en XML-generator der følger denne syntax
/*
XML.child
      .attribute
      .attribute
      .child
          .atttibute
          .attribute
      .child
          .atttibute
          .attribute
 */

// XML Container der representere den yderste container
// Containeren har kun én funktion, som tager imod et lambda med receiver type XMLChildContainer
open class XMLContainer {
    private val data = StringBuilder()

    fun child(tag: String, action: XMLChildContainer.() -> Unit): XMLContainer {
        data.append("<$tag")
        val tagData = XMLChildContainer()
        tagData.action()
        data.append(tagData.attrData())
        data.append(">")
        data.append(tagData.data())
        data.append("\n</$tag>")
        return this
    }

    fun data() = data.toString()
}

// Dette er også bare en container, men med attributterne attr og value
class XMLChildContainer : XMLContainer() {
    private val tagData = StringBuilder()

    fun attr(attrName: String, value: String) {
        tagData.append(" $attrName=\"$value\"")
    }

    fun attrData() = tagData.toString()
}

fun createAndroidLayout(): XMLContainer {
    return XMLContainer()
}



fun main(args: Array<String>) {
    val xml = createAndroidLayout()
        .child("LinearLayout") {
            attr("android:layout_height", "match_parent")
            attr("android:layout_width", "match_parent")
            attr("android:orientation", "vertical")
            child("ImageView") {
                attr("android:layout_height", "match_parent")
                attr("android:layout_width", "match_parent")
            }
            child("TextView") {
                attr("android:layout_height", "match_parent")
                attr("android:layout_width", "match_parent")
            }
        }
    println(xml.data())
}