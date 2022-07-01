
/**
 * Solves the Kattis problem: semafori
 */
fun main() {
    val io = Kattio()
    val n = io.readInt
    val l = io.readInt
    var pos = 0
    var time = 0

    for (i in 0 until n) {
        val lightPos = io.readInt
        val red = io.readInt
        val green = io.readInt

        time += lightPos - pos
        pos = lightPos

        val lightCycle = time % (red + green)
        if (lightCycle <= red)
            time += red - lightCycle
    }
    time += l - pos

    io.println(time)
    io.close()
}
