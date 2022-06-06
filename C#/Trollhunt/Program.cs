
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
        Scanner input = new Scanner();
        BufferedStdoutWriter output = new BufferedStdoutWriter();

        int bridgesLeft = input.NextInt() - 1;
        int groups = input.NextInt() / input.NextInt();

        int res = bridgesLeft / groups;
        if (bridgesLeft % groups > 0)
            res++;

        output.WriteLine(res);
        output.Close();
    }
}
