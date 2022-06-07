
/**
 * Solves the Kattis problem: peasoup
 */
fun main() {

    fun solve(): String {
        val n = readLine()!!.toInt()
        for (i in 0 until n) {
            val k = readLine()!!.toInt()
            val restaurant = readLine()!!
            var hasPeaSoup = false
            var hasPancakes = false
            for (j in 0 until k) {
                val line = readLine()
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

    println(solve())
}
