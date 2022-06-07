
/**
 * Solves the Kattis problem: loorolls
 */
fun main() {
    val io = Kattio()
    val l = io.readLong
    var n = io.readLong

    var rest = n
    var count = 0

    while (rest > 0) {
        rest = l % n
        n -= rest

        count++
    }

    io.println(count)
    io.close()
}
