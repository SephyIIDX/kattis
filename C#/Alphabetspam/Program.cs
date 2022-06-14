
using Kattis.IO;

/// <summary>
/// Solves the Kattis problem: alphabetspam
/// </summary>
public class Program
{
    /// <summary>
    /// Reads the input and prints the solution as specified by Kattis.
    /// </summary>
    public static void Main()
    {
        Kattio io = new Kattio();

        double whiteSpaces = 0, lowerCases = 0, upperCases = 0, symbols = 0;
        string spam = io.Next();
        foreach (int letter in spam)
        {
            if (97 <= letter && letter <= 122)
            {
                lowerCases++;
            }
            else if (65 <= letter && letter <= 90)
            {
                upperCases++;
            }
            else if (letter == 95)
            {
                whiteSpaces++;
            }
            else
            {
                symbols++;
            }
        }
        
        io.WriteLine(whiteSpaces / spam.Length);
        io.WriteLine(lowerCases / spam.Length);
        io.WriteLine(upperCases / spam.Length);
        io.WriteLine(symbols / spam.Length);
        io.Close();
    }
}
