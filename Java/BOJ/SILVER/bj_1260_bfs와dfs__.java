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
		N=Integer.parseInt(tokens.nextToken()); //?«?κ°? μ΄? λͺκ°??μ§? (1λΆ??° ?Ό?€)
		M=Integer.parseInt(tokens.nextToken()); //? ? ?΄ μ΄? λͺκ°κ°? ?€?΄?€?μ§?
		V=Integer.parseInt(tokens.nextToken()); //?΄?λΆ??° ????μ§?
		
		map=new int[N+1][N+1]; //1λΆ??°4κΉμ? ?€?΄?¬κΊΌλκΉ? +1?΄μ£ΌκΈ°
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(tokens.nextToken());
			int to=Integer.parseInt(tokens.nextToken());
			
			map[from][to]=map[to][from]=1; //?€?΄κ°κ±°? 1λ‘? μ²λ¦¬?΄μ£ΌκΈ°
		}
		visited=new boolean[N+1]; //1λΆ??° 4κΉμ? ?Ό?μ§? ??Ό?μ§? μ²΄ν¬ 
		dfs(V);
		output.append("\n");
		bfs();
		System.out.println(output);
	}
	public static void dfs(int index) {
		visited[index]=true;
		output.append(index).append(" ");
		
		for(int i=1;i<=N;i++) {
			//iλ₯? λ°©λ¬Έ?μ§? ??κ³?, index?? ?Έ? ?΄??Όλ©?(?°κ²°λ?΄??Όλ©?)
			if(visited[i]==false&&map[index][i]==1) {
				//trueλ‘? λ°κΎΈκ³?
				visited[i]=true;
				//κ±°κΈ° λ°©λ¬Έ 
				dfs(i);
			}
		}
	}
	public static void bfs() {
		Queue<Integer>queue=new LinkedList<Integer>();
		visited=new boolean[N+1]; //?€? μ΄κΈ°?(??? ?λ²? ?Ό?Ό?κΉ?)
		visited[V]=true;
		queue.offer(V); //?Ό?¨ μ²μκΊ? ?£κΈ?
		output.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=1;i<=N;i++) {
				//???? temp? ?Έ? ?΄??€ 
				if(visited[i]==false&&map[temp][i]==1) {
					output.append(i).append(" ");
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}

}
