
using Kattis.IO;

/// <summary>
/// Solves the Kattis problem: trollhunt
/// </summary>
public class Program
{
    /// <summary>
    /// Reads the input and prints the solution as specified by Kattis.
    /// </summary>
    public static void Main()
    {
        Kattio io = new Kattio();

        int bridgesLeft = io.NextInt() - 1;
        int groups = io.NextInt() / io.NextInt();

        int res = bridgesLeft / groups;
        if (bridgesLeft % groups > 0)
            res++;

        io.WriteLine(res);
        io.Close();
    }
}
