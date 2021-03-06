using System;
using System.IO;

namespace Kattis.IO
{
    public class Kattio : StreamWriter
    {
        private string line;
        string[] tokens = new string[0];
        private int pos;
        StreamReader reader;

        public Kattio(Stream inStream) : base(new BufferedStream(Console.OpenStandardOutput()))
        {
            var bs = new BufferedStream(inStream);
            reader = new StreamReader(bs);
        }

        public Kattio() : this(Console.OpenStandardInput())
        {
            // Nothing more to do
        }

        private string PeekNext()
        {
            if (pos < 0)
                // pos < 0 indicates that there are no more tokens
                return null;
            if (pos < tokens.Length)
            {
                if (tokens[pos].Length == 0)
                {
                    ++pos;
                    return PeekNext();
                }
                return tokens[pos];
            }
            line = reader.ReadLine();
            if (line == null)
            {
                // There is no more data to read
                pos = -1;
                return null;
            }
            // Split the line that was read on white space characters
            tokens = line.Split(null);
            pos = 0;
            return PeekNext();
        }

        public bool HasNext()
        {
            return (PeekNext() != null);
        }

        public string Next()
        {
            string next = PeekNext();
            if (next == null)
                throw new NoMoreTokensException();
            ++pos;
            return next;
        }

        public string NextLine()
        {
            PeekNext();
            pos = tokens.Length;
            return line;
        }

        public int NextInt()
        {
            return int.Parse(Next());
        }

        public long NextLong()
        {
            return long.Parse(Next());
        }

        public float NextFloat()
        {
            return float.Parse(Next());
        }

        public double NextDouble()
        {
            return double.Parse(Next());
        }
    }


    public class NoMoreTokensException : Exception
    {
    }

}
