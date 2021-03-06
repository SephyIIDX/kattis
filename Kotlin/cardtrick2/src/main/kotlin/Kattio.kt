/** Simple yet moderately fast I/O routines.
 *
 * Example usage:
 *
 * val io = Kattio()
 *
 * while (io.hasMoreTokens) {
 *     val n = io.int
 *     val d = io.double
 *     val ans = d*n
 *
 *     io.println("Answer: " + ans)
 * }
 *
 * io.close()
 *
 *
 * Some notes:
 *
 * - When done, you should always do io.close() or io.flush() on the
 *   Kattio-instance, otherwise, you may lose output.
 *
 * - The io.int, io.double, and io.long properties will throw an
 *   exception if there is no more data in the input, so it is generally
 *   a good idea to use hasMoreTokens to check for end-of-file.
 *
 * Original author of Java-version: Kattis
 * Converted to Kotlin using IntelliJ IDEA.
 */

import java.util.StringTokenizer
import java.io.BufferedReader
import java.io.BufferedOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.io.OutputStream

internal class Kattio(i: InputStream = System.`in`, o: OutputStream = System.out) :
    PrintWriter(BufferedOutputStream(o)) {

    val hasMoreTokens: Boolean
        get() = peekToken() != null

    val readInt: Int
        get() = nextToken()!!.toInt()
    val readDouble: Double
        get() = nextToken()!!.toDouble()
    val readLong: Long
        get() = nextToken()!!.toLong()
    val readWord: String?
        get() = nextToken()
    val readLine: String?
        get() = nextLine()

    private var r: BufferedReader
    private var line: String? = null
    private var st: StringTokenizer? = null
    private var token: String? = null

    private fun peekToken(): String? {
        if (token == null) try {
            while (st == null || !st!!.hasMoreTokens()) {
                line = r.readLine()
                if (line == null) return null
                st = StringTokenizer(line)
            }
            token = st!!.nextToken()
        } catch (_: IOException) {
        }
        return token
    }

    private fun nextToken(): String? {
        val ans = peekToken()
        token = null
        return ans
    }

    private fun nextLine(): String? {
        peekToken()
        st = null
        token = null
        return line
    }

    init {
        r = BufferedReader(InputStreamReader(i))
    }
}
