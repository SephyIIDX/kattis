
#include <cstdio>
using namespace std;

/*
 * Solves the Kattis problem: semafori
 */
int main()
{
    int N, L, position = 0, time = 0;
    scanf("%d %d", &N, &L);

    for (int i = 0; i < N; i++)
    {
        int D, R, G;
        scanf("%d %d %d", &D, &R, &G);

        time += D - position;
        position = D;
        
        int lightCycle = time % (R + G);
        if (lightCycle <= R) //Red light
        {
            time += R - lightCycle;
        }
    }
    time += L - position;
    
    printf("%d\n", time);
    return 0;
}
