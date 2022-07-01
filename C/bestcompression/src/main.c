
#include <stdio.h>

/*
 * Solves the Kattis problem: bestcompression
 */
int main()
{
    long long N;
    int b;

    scanf("%lld %d", &N, &b);

    if (N < (2L << b))
        printf("yes\n");
    else
        printf("no\n");

    return 0;
}
