package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260_bfs??dfs__ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int N,M,V;
	static boolean[] visited;
	static int[][]map;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //?��?���? �? 몇개?��?���? (1�??�� ?��?��)
		M=Integer.parseInt(tokens.nextToken()); //?��?��?�� �? 몇개�? ?��?��?��?���?
		V=Integer.parseInt(tokens.nextToken()); //?��?���??�� ?��?��?��?���?
		
		map=new int[N+1][N+1]; //1�??��4까�? ?��?��?��꺼니�? +1?��주기
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(tokens.nextToken());
			int to=Integer.parseInt(tokens.nextToken());
			
			map[from][to]=map[to][from]=1; //?��?��간거?�� 1�? 처리?��주기
		}
		visited=new boolean[N+1]; //1�??�� 4까�? ?��?���? ?��?��?���? 체크 
		dfs(V);
		output.append("\n");
		bfs();
		System.out.println(output);
	}
	public static void dfs(int index) {
		visited[index]=true;
		output.append(index).append(" ");
		
		for(int i=1;i<=N;i++) {
			//i�? 방문?���? ?��?���?, index?? ?��?��?��?��?���?(?��결되?��?��?���?)
			if(visited[i]==false&&map[index][i]==1) {
				//true�? 바꾸�?
				visited[i]=true;
				//거기 방문 
				dfs(i);
			}
		}
	}
	public static void bfs() {
		Queue<Integer>queue=new LinkedList<Integer>();
		visited=new boolean[N+1]; //?��?�� 초기?��(?��?��?�� ?���? ?��?��?���?)
		visited[V]=true;
		queue.offer(V); //?��?�� 처음�? ?���?
		output.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=1;i<=N;i++) {
				//?��?��?��?�� temp?�� ?��?��?��?��?�� 
				if(visited[i]==false&&map[temp][i]==1) {
					output.append(i).append(" ");
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}

}
