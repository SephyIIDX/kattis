
#include <stdio.h>

/*
 * Solves the Kattis problem: semafori
 */
int main()
{
    int N, L, pos = 0, time = 0;
    scanf("%d %d", &N, &L);

    for (int i = 0; i < N; i++)
    {
        int D, R, G;
        scanf("%d %d %d", &D, &R, &G);

        time += D - pos;
        pos = D;
        
        int cycle_time = time % (R + G);
        if (cycle_time <= R) //Red light
        {
            time += R - cycle_time;
        }
    }
    time += L - pos;
    
    printf("%d\n", time);
    return 0;
}
