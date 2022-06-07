
/**
 * Solves the Kattis problem: peasoup
 */
fun main() {
    val io = Kattio()
    fun solve(): String? {
        val n = io.int
        for (i in 0 until n) {
            val k = io.int
            val restaurant = io.line
            var hasPeaSoup = false
            var hasPancakes = false
            for (j in 0 until k) {
                val line = io.line
                if (!hasPeaSoup && line.equals("pea soup")) {
                    hasPeaSoup = true
                } else if (!hasPancakes && line.equals("pancakes")) {
                    hasPancakes = true
                }
                if (hasPeaSoup && hasPancakes) {
                    return restaurant
                }
            }
        }
        return "Anywhere is fine I guess"
    }

    io.println(solve())
}
