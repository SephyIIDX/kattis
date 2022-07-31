#! /usr/bin/env python3

import math

# Solves the Kattis problem: catalansquare
n = int(input()) + 1
ans = math.factorial(2 * n) // math.factorial(n + 1) // math.factorial(n)

print(ans)
