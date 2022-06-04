package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2606_바이?��?�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static int[][] map;
	static boolean[] visited;
	static int N,M;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine()); //컴퓨?��???��
		M=Integer.parseInt(br.readLine()); //?��결되?��?��?�� 간선??��?��
		
		map=new int[N+1][N+1]; //1�??�� ?��?��?��거니�?
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(tokens.nextToken());
			int to=Integer.parseInt(tokens.nextToken());
			map[from][to]=map[to][from]=1;
		}
		visited=new boolean[N+1];
		count=0;
		dfs(1);
		System.out.println(count);
	}
	public static void dfs(int cnt) {
		visited[cnt]=true;
		for(int i=1;i<=N;i++) {
			if(visited[i]==false&&map[cnt][i]==1) {
				count++;
				visited[i]=true;
				dfs(i);
			}
		}
	}

}
