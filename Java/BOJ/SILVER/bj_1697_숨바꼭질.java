package SILVER;
package ?��?��??�?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//기본?���?: bfs?��?��, 처음 방문?��?��?���? ?��?�� '처음'?���? ?��착하?�� ?��?��?��.
//굳이 최솟값을 구하�? ?���? 1차원 배열�? 처리?��주기 
//�? 1차원 배열?�� 몇초?�� 방문?��?���? ?��?��주기 
public class bj_1697_?��바꼭�? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]visited=new int[100001];
	
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		//만약 같으�? ?��?��?�� ?��볼것?�� ?��?�� 0?��?��.
		if(N==K) {
			System.out.println(0);
			return;
		}
		//?��?��?���? bfs�? ?��?��
		bfs();
		//?��차피 visited배열?��?�� 최솟값이 ?��겨져 ?��?��?�� 그냥 출력 
		System.out.println(visited[K]);

	}
	static void bfs() {
		Queue<Integer>queue=new LinkedList<>();
		queue.offer(N); //?��?�� 처음?�� ?��빈이?�� ?��치�?? ?��?��?��.
		visited[N]=0; //?��빈이?�� 0초에 방문?��?���? ?���?
		
		while(!queue.isEmpty()) {
			int head=queue.poll();
			//	범위 ?��?�� ?���?			?���? 방문?���? ?��?��?���?
			if(isIn(head-1)&&visited[head-1]==0) {
				queue.offer(head-1);
				 //head-1?? 몇초?�� 방문?��?���? ?��?��주기 (기존?���?+1)
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
