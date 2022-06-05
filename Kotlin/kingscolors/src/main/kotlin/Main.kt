
private const val MOD = 1000000007

/**
 * Solves the Kattis problem: kingscolors
 *
 * Using Tabulation, Bottom-Up Dynamic Programming
 */
fun main() {
    val io = Kattio()
    val n = io.int
    val k = io.int
    val colorings = Array(n+1) { LongArray(k+1) }

    colorings[1][1] = 1
    for (i in 2..n) {
        for (j in 1..k) {
            colorings[i][j] = (j * colorings[i-1][j-1] + (j-1) * colorings[i-1][j]) % MOD
        }
    }

    io.println(colorings[n][k])
    io.close()
}
