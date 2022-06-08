
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Solves the Kattis problem: borg
 */
public class Main {
	private boolean[][] isWall;
	private boolean[][] isNode;
	private int[][] dist;
	private ArrayList<Pair<Integer, Integer>> vertices;
	private int start;
	private Queue<Pair<Integer, Integer>> q;
	
	/**
	 * Reads the input and prints the solution as specified by Kattis.
	 */
	public void runOnKattis() {
		Kattio io = new Kattio(System.in, System.out);

		int n = io.getInt();
		
		int x, y;
		String line;
		while (n-- > 0) {
			y = io.getInt();
			x = io.getInt();

			isWall = new boolean[x][y];
			isNode = new boolean[x][y];
			vertices = new ArrayList<>();
			
			for (int i = 0; i < x; i++) {
				line = io.getLine();

				for (int j = 0; j < y; j++) {
					if (line.charAt(j) == '#')
						isWall[i][j] = true;
					else if (line.charAt(j) == 'A') {
						isNode[i][j] = true;
						vertices.add(new Pair<Integer, Integer>(i, j));
					}
					else if (line.charAt(j) == 'S') {
						isNode[i][j] = true;
						start = vertices.size();
						vertices.add(new Pair<Integer, Integer>(i, j));
					}
				}
			}
			
			int vSize = vertices.size();
			
			dist = new int[vSize][vSize];
			
//			for (int i = 0; i < vSize; i++) {
//				System.err.println("v: "+i+" x: "+vertices.get(i).getFirst()+" y: "+vertices.get(i).getSecond());
//			}
//			System.err.println();

			int[][] distance;
			boolean[][] visited;

			int res = 0;
			
			for (int i = 0; i < vSize; i++) {
				distance = new int[x][y];
				visited = new boolean[x][y];
				visited[vertices.get(i).getFirst()][vertices.get(i).getSecond()] = true;
				
				q = new LinkedList<>();
				q.add(vertices.get(i));

				Pair<Integer, Integer> curr;
				while (!q.isEmpty()) {
					curr = q.poll();
					bfs(curr.getFirst(), curr.getSecond(), distance, visited);
				}
				
//				for (int j = 0; j < distance.length; j++) {
//					System.err.println(Arrays.toString(distance[j]));
//				}
//				System.err.println();
				
				for (int j = 0; j < vSize; j++) {
					if (i == j)
						continue;
					dist[i][j] = distance[vertices.get(j).getFirst()][vertices.get(j).getSecond()];
				}
			}
			
//			for (int i = 0; i < dist.length; i++) {
//				System.err.println(Arrays.toString(dist[i]));
//			}
//			System.err.println();
			
			boolean[] blue = new boolean[vSize];
			blue[start] = true;

			PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(vSize*vSize, new DistComparator());
			for (int i = 0; i < vSize; i++) {
				if (blue[i])
					continue;
				pq.add(new Pair<Integer, Integer>(start, i));
			}
			
			for (int i = 0; i < vSize-1; i++) {
				Pair<Integer, Integer> cheapest = pq.poll();
				int u = cheapest.getFirst();
				int v = cheapest.getSecond();
				
				if (blue[v]) {
					i--;
					continue;
				}
				
//				System.err.println("Found edge: "+u+","+v+" dist: "+dist[u][v]);
				
				res += dist[u][v];
				blue[v] = true;
				
				for (int w = 0; w < vSize; w++) {
					if (blue[w])
						continue;
					pq.add(new Pair<Integer, Integer>(v, w));
				}
			}
			io.println(res);
		}
		io.close();
	}
	
	private void bfs(int x, int y, int[][] dist, boolean[][] visited) {
//		System.err.println("x: "+x+" y: "+y);
		
		if (!visited[x][y+1] && !isWall[x][y+1]) {
			dist[x][y+1] = dist[x][y]+1;
			visited[x][y+1] = true;
			q.add(new Pair<Integer, Integer>(x, y+1));
		}
		
		if (!visited[x+1][y] && !isWall[x+1][y]) {
			dist[x+1][y] = dist[x][y]+1;
			visited[x+1][y] = true;
			q.add(new Pair<Integer, Integer>(x+1, y));
		}

		if (!visited[x-1][y] && !isWall[x-1][y]) {
			dist[x-1][y] = dist[x][y]+1;
			visited[x-1][y] = true;
			q.add(new Pair<Integer, Integer>(x-1, y));
		}
		
		if (!visited[x][y-1] && !isWall[x][y-1]) {
			dist[x][y-1] = dist[x][y]+1;
			visited[x][y-1] = true;
			q.add(new Pair<Integer, Integer>(x, y-1));
		}
		
		return;
	}
	
	public class DistComparator implements Comparator<Pair<Integer, Integer>> {

		@Override
		public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
			if (dist[o1.getFirst()][o1.getSecond()] < dist[o2.getFirst()][o2.getSecond()])
				return -1;
			if (dist[o1.getFirst()][o1.getSecond()] > dist[o2.getFirst()][o2.getSecond()])
				return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		new Main().runOnKattis();
	}
}
