
using Kattis.IO;

/// <summary>
/// Solves the Kattis problem: kitten
/// </summary>
public class Program
{
    /// <summary>
    /// Reads the input and prints the solution as specified by Kattis.
    /// </summary>
    public static void Main()
    {
        Kattio io = new Kattio();
        int[] branches = new int[101];

        int k = io.NextInt();
        
        string[] line = io.NextLine().Split(' ');
        int currentBranch = int.Parse(line[0]);
        int branchesTo;
        while (currentBranch > 0)
        {
            for (int i = 1; i < line.Length; i++)
            {
                branchesTo = int.Parse(line[i]);
                branches[branchesTo] = currentBranch;
            }

            line = io.NextLine().Split(' ');
            currentBranch = int.Parse(line[0]);
        }

        branchesTo = branches[k];
        io.Write(k);
        while (branchesTo != 0)
        {
            io.Write(" " + branchesTo);
            branchesTo = branches[branchesTo];
        }
        io.WriteLine();
        io.Close();
    }
}
