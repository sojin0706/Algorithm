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
		N=Integer.parseInt(tokens.nextToken()); //?ˆ«?ê°? ì´? ëª‡ê°œ?ˆ?Š”ì§? (1ë¶??„° ?„¼?‹¤)
		M=Integer.parseInt(tokens.nextToken()); //? •? ?´ ì´? ëª‡ê°œê°? ?“¤?–´?˜¤?Š”ì§?
		V=Integer.parseInt(tokens.nextToken()); //?–´?””ë¶??„° ?‹œ?‘?•˜?Š”ì§?
		
		map=new int[N+1][N+1]; //1ë¶??„°4ê¹Œì? ?“¤?–´?˜¬êº¼ë‹ˆê¹? +1?•´ì£¼ê¸°
		for(int i=0;i<M;i++) {
			tokens=new StringTokenizer(br.readLine());
			int from=Integer.parseInt(tokens.nextToken());
			int to=Integer.parseInt(tokens.nextToken());
			
			map[from][to]=map[to][from]=1; //?“¤?–´ê°„ê±°?Š” 1ë¡? ì²˜ë¦¬?•´ì£¼ê¸°
		}
		visited=new boolean[N+1]; //1ë¶??„° 4ê¹Œì? ?¼?Š”ì§? ?•ˆ?¼?Š”ì§? ì²´í¬ 
		dfs(V);
		output.append("\n");
		bfs();
		System.out.println(output);
	}
	public static void dfs(int index) {
		visited[index]=true;
		output.append(index).append(" ");
		
		for(int i=1;i<=N;i++) {
			//ië¥? ë°©ë¬¸?•˜ì§? ?•Š?•˜ê³?, index?? ?¸? ‘?•´?ˆ?œ¼ë©?(?—°ê²°ë˜?–´?ˆ?œ¼ë©?)
			if(visited[i]==false&&map[index][i]==1) {
				//trueë¡? ë°”ê¾¸ê³?
				visited[i]=true;
				//ê±°ê¸° ë°©ë¬¸ 
				dfs(i);
			}
		}
	}
	public static void bfs() {
		Queue<Integer>queue=new LinkedList<Integer>();
		visited=new boolean[N+1]; //?‹¤?‹œ ì´ˆê¸°?™”(?œ„?—?„œ ?•œë²? ?¼?œ¼?‹ˆê¹?)
		visited[V]=true;
		queue.offer(V); //?¼?‹¨ ì²˜ìŒêº? ?„£ê¸?
		output.append(V).append(" ");
		
		while(!queue.isEmpty()) {
			int temp=queue.poll();
			for(int i=1;i<=N;i++) {
				//?œ„?—?ˆ?Š” temp?‘ ?¸? ‘?•´?ˆ?‹¤ 
				if(visited[i]==false&&map[temp][i]==1) {
					output.append(i).append(" ");
					queue.offer(i);
					visited[i]=true;
				}
			}
			
		}
		
	}

}
