
/**
 * Solves the Kattis problem: cardtrick2
 */
fun main() {
    val io = Kattio()
    val t = io.int

    for (i in 0 until t) {
        val n = io.int

        var cards = listOf(n)
        for (j in n-1 downTo 1) {

            cards = listOf(j) + cards
            for (k in 1..j) {
                cards = cards.takeLast(1) + cards.dropLast(1)
            }
        }
        io.println(cards.toString().replace(Regex("[^\\d ]"),""))
    }
    io.close()
}
