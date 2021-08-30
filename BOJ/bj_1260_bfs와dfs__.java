import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1260_bfs와dfs__ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int N,M,V;
	static boolean[] visited;
	static int[][]map;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken()); //숫자가 총 몇개있는지 (1부터 센다)
		M=Integer.parseInt(tokens.nextToken()); //정점이 총 몇개가 들어오는지
		V=Integer.parseInt(tokens.nextToken()); //어디부터 시작하는지
		
		map=new int[N+1][N+1]; //1부터4까지 들어올꺼니까 +1해주기
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(tokens.nextToken());
			int to=Integer.parseInt(tokens.nextToken());
			
			map[from][to]=map[to][from]=1; //들어간거는 1로 처리해주기
		}
		visited=new boolean[N+1]; //1부터 4까지 썼는지 안썼는지 체크 
		dfs(V);
		output.append("\n");
		bfs();
		System.out.println(output);
	}
	public static void dfs(int index) {
		visited[index]=true;
		output.append(index).append(" ");
		
		for(int i=1;i<=N;i++) {
			//i를 방문하지 않았고, index와 인접해있으면(연결되어있으면)
			if(visited[i]==false&&map[index][i]==1) {
				//true로 바꾸고
				visited[i]=true;
				//거기 방문 
				dfs(i);
			}
		}
	}
	public static void bfs() {
		Queue<Integer>queue=new LinkedList<Integer>();
		visited=new boolean[N+1]; //다시 초기화(위에서 한번 썼으니까)
		visited[V]=true;
		queue.offer(V); //일단 처음꺼 넣기
		output.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=1;i<=N;i++) {
				//위에있는 temp랑 인접해있다 
				if(visited[i]==false&&map[temp][i]==1) {
					output.append(i).append(" ");
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}

}
