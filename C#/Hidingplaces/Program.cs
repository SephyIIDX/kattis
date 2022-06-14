
using System;
using System.Collections.Generic;
using Kattis.IO;

/// <summary>
/// Solves the Kattis problem: hidingplaces
/// </summary>
public class Program
{
    static int[,] visited;
    static string[,] solutions;
    static int currentMove;

    /// <summary>
    /// Reads the input and prints the solution as specified by Kattis.
    /// </summary>
    public static void Main()
    {
        Kattio io = new Kattio();

        solutions = new string[8, 8];

        int n = io.NextInt();
        while (n > 0)
        {
            string s = io.Next();
            Tuple<int, int, int> pos = new Tuple<int, int, int>(s[0] - 97, s[1] - 49, 0); // a1 = (97, 49)

            if (solutions[pos.Item1, pos.Item2] != null)
            {
                io.WriteLine(solutions[pos.Item1, pos.Item2]);
                n--;
                continue;
            }

            currentMove = 0;
            visited = new int[8, 8];
            visited[pos.Item1, pos.Item2] = -1;

            Queue<Tuple<int, int, int>> q = new Queue<Tuple<int, int, int>>();
            q.Enqueue(pos);

            while (q.Count > 0)
            {
                Bfs(q);
            }

            s = currentMove.ToString();
            for (int j = 7; j >= 0; j--)
            {
                for (int i = 0; i < 8; i++)
                {
                    if(visited[i,j] == currentMove)
                        s = s + " " + char.ConvertFromUtf32(i + 97) + (j + 1);
                }
            }
            io.WriteLine(s);
            solutions[pos.Item1, pos.Item2] = s;
            n--;
        }
        io.Close();
    }

    private static void Bfs(Queue<Tuple<int, int, int>> q)
    {
        Tuple<int, int, int> pos = q.Dequeue();
    
        if (pos.Item3 > currentMove)
        {
            currentMove++;
        }

        if (0 <= pos.Item1-1 && pos.Item1-1 < 8 && 0 <= pos.Item2+2 && pos.Item2+2 < 8 && visited[pos.Item1 - 1, pos.Item2 + 2] == 0)
        {
            visited[pos.Item1-1, pos.Item2+2] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1-1, pos.Item2+2, pos.Item3+1));
        }

        if (0 <= pos.Item1+1 && pos.Item1+1 < 8 && 0 <= pos.Item2+2 && pos.Item2+2 < 8 && visited[pos.Item1 + 1, pos.Item2 + 2] == 0)
        {
            visited[pos.Item1+1, pos.Item2+2] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1+1, pos.Item2+2, pos.Item3 + 1));
        }

        if (0 <= pos.Item1-2 && pos.Item1-2 < 8 && 0 <= pos.Item2+1 && pos.Item2+1 < 8 && visited[pos.Item1 - 2, pos.Item2 + 1] == 0)
        {
            visited[pos.Item1-2, pos.Item2+1] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1-2, pos.Item2+1, pos.Item3 + 1));
        }

        if (0 <= pos.Item1-2 && pos.Item1-2 < 8 && 0 <= pos.Item2-1 && pos.Item2-1 < 8 && visited[pos.Item1 - 2, pos.Item2 - 1] == 0)
        {
            visited[pos.Item1-2, pos.Item2-1] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1-2, pos.Item2-1, pos.Item3 + 1));
        }

        if (0 <= pos.Item1+2 && pos.Item1+2 < 8 && 0 <= pos.Item2+1 && pos.Item2+1 < 8 && visited[pos.Item1 + 2, pos.Item2 + 1] == 0)
        {
            visited[pos.Item1+2, pos.Item2+1] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1+2, pos.Item2+1, pos.Item3 + 1));
        }

        if (0 <= pos.Item1+2 && pos.Item1+2 < 8 && 0 <= pos.Item2-1 && pos.Item2-1 < 8 && visited[pos.Item1 + 2, pos.Item2 - 1] == 0)
        {
            visited[pos.Item1+2, pos.Item2-1] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1+2, pos.Item2-1, pos.Item3 + 1));
        }

        if (0 <= pos.Item1-1 && pos.Item1-1 < 8 && 0 <= pos.Item2-2 && pos.Item2-2 < 8 && visited[pos.Item1 - 1, pos.Item2 - 2] == 0)
        {
            visited[pos.Item1-1, pos.Item2-2] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1-1, pos.Item2-2, pos.Item3 + 1));
        }

        if (0 <= pos.Item1+1 && pos.Item1+1 < 8 && 0 <= pos.Item2-2 && pos.Item2-2 < 8 && visited[pos.Item1 + 1, pos.Item2 - 2] == 0)
        {
            visited[pos.Item1+1, pos.Item2-2] = pos.Item3 + 1;
            q.Enqueue(new Tuple<int, int, int>(pos.Item1+1, pos.Item2-2, pos.Item3 + 1));
        }
    }
}
