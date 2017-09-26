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
    forLoop1()
    forLoop2()
    whileLoop1()
    println(whenDescribe(10))
    range1()
    range2()
    range3()
    range4()
    collection1()
    collection2()
    collection3Lambda()
    defaultValues(21, "lalala")
    filterList()
    rangeUsage()
    mapFun()
    val data1proba = arrayOf(1, 3, 4, 312, 31)
    val data2proba = null
//    executeStatementIfNull()
    executeIfNotNull(data1proba)
    executeIfNotNull(data2proba)
    whenInFun("Red")
//    whenInFun("Yellow")
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

/**
 * *********************************LOOPS******************************************
 */

/**
 * kockica u CRTRL+Q oznacava val (immutable)
 * kruzic oznacava var (mutable)
 */
fun forLoop1() {
    var items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
}

/**
 * Koristenje index-a -> totalno nesto novo
 */
fun forLoop2() {
    val items = listOf("apple", "kiwi", "banana")
    for (index in items.indices) {
        println("item at index $index is ${items[index]}")
    }
}

/**
 * while loop -> koristenje varijable index++ -> STRAHOVITO BITNO
 */
fun whileLoop1() {
    val items = listOf("apple", "kiwi", "banana")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

/**
 * when statement - treba jos istraziti
 *
 */
fun whenDescribe(obj: Any): String {
    when (obj) {
        1 -> return "One"
        "Hello" -> return "Greetings"
        is Long -> return "Long"
        !is String -> return "Not a String"
        else -> return "Unknown"
    }
}

/**
 **************************************RANGES****************************************
 */

/**
 * in operator
 * provjera je li broj unutar nekog skupa brojeva
 */
fun range1() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
}

/**
 * provjera je li index unutar skupa indexa neke liste
 * vidimo da indexi -1 i velicina liste nisu unutar skupa indexa bilo koje liste
 */
fun range2() {
    val lista = listOf("a", "b", "c")
    if (-1 !in 0..lista.lastIndex) {
        println("-1 is out of")
    }
    if (lista.size !in lista.indices) {
        println("list size is out of valid list indices range too")
    }
}

/**
 * iteriranje po range-u
 */
fun range3() {
    for (x in 1..5) {
        print("$x ")
    }
}

/**
 * iterating over a progression
 * downTo, step
 */
fun range4() {
    println()
    for (x in 1..10 step 2) {
        print("$x ")
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print("$x ")
    }
    println()
}

/**
 **************************************COLLECTIONS****************************************
 */

/**
 * obicna kolekcija u obliku array-a
 */
fun collection1() {
    val items = arrayOf("jen", "dva", "tri")
    for (item in items) {
        println(item)
    }
}

/**
 * Koristenje when i in operatora unutar funkcije
 */
fun collection2() {
    val items = arrayOf("jabuka", "kruska", "sljiva")
    when {
        "jabuka" in items -> println("Ovo je ${items[0]}")
        "kruska" in items -> println("Ovo je ${items[1]}")
        "sljiva" in items -> println("Ovo je ${items[2]}")
    }
}

/**
 * Koristenje lambda expressiona uzimajuci kolekciju tipa array
 * Najprije filtrira prema onima koji pocinju s k
 * Onda sortira po abecedi
 * Onda mapira u sve velikim slovom
 * Onda za svaku tu listu printa to sto imamo
 */
fun collection3Lambda() {
    var fruits = arrayOf("jabuka", "ananas", "kruska", "kiwi", "sljiva")
    fruits
            .filter { it.startsWith("k") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

/**
 * Stavljanje defaultnih vrijednosti u parametre funkcije
 */
fun defaultValues(a: Int = 0, b: String = "") {
    println("$a $b")
}

/**
 * a =>
 * it => svi elementi liste
 * forEach => printanje svakog elementa liste posebno
 */
fun filterList() {
    val lista = arrayOf(21, 412, 2414, -21, -31, 212, 41, -12)
    val positives1 = lista.filter { a -> a > 0 }
    val positives2 = lista.filter { it > 0 }
    println("$positives1")
    println("$positives2")
    positives1.forEach { print("$it ") }
    positives2.forEach { print("$it ") }
    println()
}

/**
 * Sve range opcije - for petlja
 */
fun rangeUsage() {
    for (i in 1..10) {
        print("$i ")
    }
    println()
    for (i in 1 until 10) {
        print("$i ")
    }
    println()
    for (i in 2..10 step 2) {
        print("$i ")
    }
    println()
    for (i in 10 downTo 1) {
        print("$i ")
    }
    println()
    val b1: Int = 3
    if (b1 in 1..10) {
        print(11111)
    }
    println()
}

/**
 * Map struktura podataka
 */
fun mapFun() {
    val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map1)
    map1.forEach { print("$it ") }
    println()
    for (i in map1) {
        println(i.key + i.value)
        println(i.key)
        println(i.value)
    }
    println(map1.keys)
    println(map1.values)
}

/**
 * Throw-a korisni exception ako je varijabla null
 */
fun executeStatementIfNull() {
    val data2: Map<String, Int> = mapOf("bamboo" to 1321, "gmail" to 41241, "yahoo" to 414)
    val google = data2["google"]
    println(google)
    val email = data2["email"] ?: throw IllegalStateException("Email mi fali ovdje u map")
    println(email)
}

/**
 * naredba data1?.let => Izvrsi nesto ako data1 nije null
 */
fun executeIfNotNull(data1: Array<Int>?) {
    data1?.let { println("data1 nije null + $it") }
}

/**
 ************************** SINGLE EXPRESSION FUNCTION ******************************
 * Unutar ovakve funkcije ne mogu definirati varijable
 * Naredba throw izbaci ono sto je bitno kod runtime greske
 * Nakon throw naredbe se nista sljedece ne izvrsava
 */
fun whenInFun(color: String) = when (color) {
    "Red" -> println(124)
    "Green" -> println(342)
    "Blue" -> println(421)
    else -> throw IllegalArgumentException("Pogresni color parametar")
}

