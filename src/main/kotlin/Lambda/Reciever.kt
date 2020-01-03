package Lambda

fun encloseInXMLAttributeExtension(sb: StringBuilder, attr: String, action: StringBuilder.() -> Unit): String {
    sb.append("<$attr>")
    sb.action()
    sb.append("</$attr>")
    return sb.toString()
}

val xml = encloseInXMLAttributeExtension(StringBuilder(), "attr") {
    append("MyAttribute")
}

fun main(args: Array<String>) {
    println(xml)
}