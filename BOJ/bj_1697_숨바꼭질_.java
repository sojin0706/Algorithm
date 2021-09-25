import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1697_숨바꼭질_ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int N,K,count;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		visited=new boolean[100001];
		bfs();
		
	}
	
	private static void bfs() {
		count=0;
		Queue<Integer>queue=new LinkedList<>();
		queue.offer(N); //초기위치
		visited[N]=true;
		int size=0;
		outer:while(!queue.isEmpty()) {
			size=queue.size();
			while(size-->0) {
				int head=queue.poll();
				if(head==K) break outer;
				if(head-1>=0&&visited[head-1]==false) {					
					visited[head-1]=true;
					queue.offer(head-1);
				}
				if(head+1<100001&&visited[head+1]==false) {	
					visited[head+1]=true;
					queue.offer(head+1);
				}
				if(head*2<100001&&visited[head*2]==false) {			
					visited[head*2]=true;
					queue.offer(head*2);
				}
			}
			count++;
		}
		System.out.println(count);
	}

}
