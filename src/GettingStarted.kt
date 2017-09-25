/**
 * Immutable variables
 * nemaju crtu ispod varijable
 * ako su izvan funkcije, onda su ljubicasti
 */
val x: Int = 1
val y = 2

/**
 * Mutable variables
 * imaju crtu ispod oznake varijable
 */
var z: Int = 131

/**
 * String template
 */
var w1 = 1
val w2 = "w1 jednako je $w1"
// w3 poprimi vrijednost stringa i to je to, nema više mijenjanja varijable z!!!
val w3 = "${w2.replace("jednako", "bilo je jednako")}, ali sad je jednako $z"

/**
 * main funkcija - kao izvršna jedinica
 */
fun main(args: Array<String>) {
//    ovo ne moze, jer je x mutable varijabla
//    x += 2
    z += 3
    println("z je jednako $z")
    println("w3: $w3")
    val t = 5
    println("$t + $x + $y")
    println("Hello, world! Zbroj 7 + 8 jednak je ${zbroji(7, 8)}")
    println("Hello, world! Razlika 9 - 4 jednaka je ${oduzmi(9, 4)}")
    printZbroji(7, 8)
    printOduzmi(9, 4)
    val q1 = maxOf(2, 5)
    println(q1)
    val q2 = minOf(2, 5)
    println(q2)

    var nullVar = nullReturnChecker()
    if (nullVar == null) {
        println("nullVar je null!")
    }

    //Fora je to sto prilikom println, nece se ispisati null pointer exception, vec null
    var nullVar2 = s2
    if (nullVar2 == null) {
        println("nullVar2 je null! - $nullVar2")
    }
    //Ovdje cemo dobiti exception tipa KotlinNullPointerException ako forsiramo s3
    //da moze biti null
    //znaci samo dok koristimo FORCE OPERATOR !! (dva usklicnika), onda mozemo dobiti
    //KotlinNullPointerException
    var nullVar3 = s3!!.length
    println(nullVar3)

    var nullVar4: String = nullReturnChecker() ?: "Nema imena - ovo je zapravo null pointer exception"
    var nullVar5 = nullReturnChecker()
    println(nullVar4)
    println(nullVar5)

    //Ovdje ispise Kotlin.Unit
    var nullVar6 = handlingExceptionDjeljenje(0)
    println(nullVar6)

    //Ovo je okej!
    handlingExceptionDjeljenje(0)
    handlingExceptionDjeljenje(2)

    nullFunctionKoristenje("")

    println(getMojStringLength("fawas"))
    println(getMojStringLength(2411))
    println(getMojStringLength(124.21))
    println(getMojStringLength(null))
}

/**
 * Normalni return type
 */
fun zbroji(a: Int, b: Int): Int {
    return a + b
}

/**
 * Inferred return type
 */
fun oduzmi(a: Int, b: Int) = a - b

/**
 * Unit je ovdje kao inače void
 */
fun printZbroji(a: Int, b: Int): Unit {
    println("zbroj $a + $b jednak je ${a + b}")
}

/**
 * Return type se moze izbjeci
 */
fun printOduzmi(a: Int, b: Int) {
    println("razlika $a - $b jednaka je ${a - b}")
}

/**
 * Conditional expressions
 */
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

/**
 * Koristenje if statementa kao expressiona za funkciju
 */
fun minOf(a: Int, b: Int) = if (a < b) a else b

/**
 ******************************** NULL pravila **************************************
 */

/**
 * Ne mozemo postaviti vrijednost varijable na null
 */
//var s1: String = null

/**
 * Dopustamo varijabli da bude null s upitnikom na tipu podataka (String?)
 */
var s2: String? = null
var s3: String? = "Praznici"


/**
 * Dopustamo funkciji da vraca null
 */
fun nullReturnChecker(): String? {
    return null
}

/**
 * Exception handling
 * U slucaju da user krivo napise (dopustimo mu da pise slova gdje trebaju biti brojke)
 * koristimo IllegalArgumentException
 */
fun handlingExceptionDjeljenje(djelitelj: Int) {
    try {
        if (djelitelj == 0) {
            throw IllegalArgumentException("Cant't divide with zero ")
        } else {
            println("8 / $djelitelj jednako je ${8 / djelitelj}")
        }
    } catch (e: IllegalArgumentException) {
        println("${e.message}")
    }
}

/**
 * U ovoj funkciji imamo 2 stvari za razmotriti
 * (1) funkcija moze imati poziv na funkciju koja vraca null
 * (2) parametar w1 se ponavlja kao i gore definirani
 * Treba izbjegavati iste nazive, jer se ako se naziv root-type varijable podudara s
 * nazivom lokalne varijable u funkciji, tada lokalna varijabla u funkciji
 * ima prednost - u nasem slucaju w1
 */
fun nullFunctionKoristenje(w1: String) {
    var h1 = nullReturnChecker()

    z = 23
    if (h1 == null) {
        println("imamo null + $w1")
    }
}

/**
 * is operator - provjerava da li je "Nesto" jednako obj
 * dakle unutar is operatora ne mozemo se bas igrati s null
 * no mozemo
 */
fun getMojStringLength(obj: Any?): String {
    if (obj is String) {
        return "Ovo je String"
    } else if (obj is Int) {
        return "Ovo je Int"
    } else if (obj !is Double) {
        return "Ovo nije Double"
    } else {
        return "Ovo nije ni String, ni Int, ni Double"
    }
}








