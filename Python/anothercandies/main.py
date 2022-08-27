#! /usr/bin/env python3

# Solves the Kattis problem: anothercandies
t = int(input())

for _ in range(t):
    input() # Read blank line at start of each test case
    n = int(input())

    remainder = 0
    for _ in range(n):
        candies = int(input()) % n
        remainder = (remainder + candies) % n    
    if remainder == 0:
        print('YES')
    else:
        print('NO')
