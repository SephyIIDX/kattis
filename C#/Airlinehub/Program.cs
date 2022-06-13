
using System;
using System.Globalization;
using Kattis.IO;

/// <summary>
/// Solves the Kattis problem: airlinehub
/// </summary>
public class Program
{
    /// <summary>
    /// Reads the input and prints the solution as specified by Kattis.
    /// </summary>
    public static void Main()
    {
        Kattio io = new Kattio();

        while (io.HasNext())
        {
            int n = io.NextInt();
            double[] lat = new double[n];
            double[] lon = new double[n];

            for (int i = 0; i < n; i++)
            {
                lat[i] = io.NextDouble();
                lon[i] = io.NextDouble();
            }

            double lat1, lat2, deltaLon, d;

            int k = 0;
            double min = Double.MaxValue;
            double max;

            for (int i = n - 1; i >= 0; i--)
            {
                max = 0;
                lat1 = DegreeToRadian(lat[i]);
                for (int j = 0; j < n; j++)
                {
                    if (i == j)
                        continue;
                    lat2 = DegreeToRadian(lat[j]);

                    deltaLon = DegreeToRadian(lon[j] - lon[i]);

                    d = 1 - ((Math.Sin(lat1) * Math.Sin(lat2)) + (Math.Cos(lat1) * Math.Cos(lat2) * Math.Cos(deltaLon)));
                    if (d > max)
                        max = d;
                }

                if (max < min)
                {
                    min = max;
                    k = i;
                }
            }
            io.WriteLine(lat[k].ToString("0.00", CultureInfo.InvariantCulture) + " " + lon[k].ToString("0.00", CultureInfo.InvariantCulture));
        }
        io.Close();
    }

    private static double DegreeToRadian(double angle)
    {
        return Math.PI * angle / 180.0;
    }
}
