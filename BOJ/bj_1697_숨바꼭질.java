package 혼자풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//기본원리: bfs인데, 처음 방문하는애가 제일 '처음'으로 도착하는 애이다.
//굳이 최솟값을 구하지 않고 1차원 배열로 처리해주기 
//그 1차원 배열에 몇초에 방문했는지 적어주기 
public class bj_1697_숨바꼭질 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]visited=new int[100001];
	
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		//만약 같으면 더이상 해볼것도 없이 0이다.
		if(N==K) {
			System.out.println(0);
			return;
		}
		//아니라면 bfs로 탐색
		bfs();
		//어차피 visited배열에는 최솟값이 담겨져 있으니 그냥 출력 
		System.out.println(visited[K]);

	}
	static void bfs() {
		Queue<Integer>queue=new LinkedList<>();
		queue.offer(N); //제일 처음엔 수빈이의 위치를 넣는다.
		visited[N]=0; //수빈이는 0초에 방문했다고 생각
		
		while(!queue.isEmpty()) {
			int head=queue.poll();
			//	범위 안에 있고			아직 방문하지 않았다면
			if(isIn(head-1)&&visited[head-1]==0) {
				queue.offer(head-1);
				 //head-1은 몇초에 방문했는지 적어주기 (기존시간+1)
				visited[head-1]=visited[head]+1;
			}
			
			if(isIn(head+1)&&visited[head+1]==0) {
				queue.offer(head+1);
				visited[head+1]=visited[head]+1;
			}
			
			if(isIn(head*2)&&visited[head*2]==0) {
				queue.offer(head*2);
				visited[head*2]=visited[head]+1;
				
			}
			
		}
	}
	static boolean isIn(int n) {
		return n>=0&&n<=100000;
	}

}
