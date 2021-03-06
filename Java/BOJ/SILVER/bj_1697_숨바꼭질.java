package SILVER;
package ?Ό???κΈ?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//κΈ°λ³Έ?λ¦?: bfs?Έ?°, μ²μ λ°©λ¬Έ??? κ°? ? ?Ό 'μ²μ'?Όλ‘? ?μ°©ν? ? ?΄?€.
//κ΅³μ΄ μ΅μκ°μ κ΅¬νμ§? ?κ³? 1μ°¨μ λ°°μ΄λ‘? μ²λ¦¬?΄μ£ΌκΈ° 
//κ·? 1μ°¨μ λ°°μ΄? λͺμ΄? λ°©λ¬Έ??μ§? ? ?΄μ£ΌκΈ° 
public class bj_1697_?¨λ°κΌ­μ§? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]visited=new int[100001];
	
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		//λ§μ½ κ°μΌλ©? ??΄? ?΄λ³Όκ²? ??΄ 0?΄?€.
		if(N==K) {
			System.out.println(0);
			return;
		}
		//???Όλ©? bfsλ‘? ??
		bfs();
		//?΄μ°¨νΌ visitedλ°°μ΄?? μ΅μκ°μ΄ ?΄κ²¨μ Έ ??Ό? κ·Έλ₯ μΆλ ₯ 
		System.out.println(visited[K]);

	}
	static void bfs() {
		Queue<Integer>queue=new LinkedList<>();
		queue.offer(N); //? ?Ό μ²μ? ?λΉμ΄? ?μΉλ?? ?£??€.
		visited[N]=0; //?λΉμ΄? 0μ΄μ λ°©λ¬Έ??€κ³? ?κ°?
		
		while(!queue.isEmpty()) {
			int head=queue.poll();
			//	λ²μ ?? ?κ³?			?μ§? λ°©λ¬Έ?μ§? ???€λ©?
			if(isIn(head-1)&&visited[head-1]==0) {
				queue.offer(head-1);
				 //head-1?? λͺμ΄? λ°©λ¬Έ??μ§? ? ?΄μ£ΌκΈ° (κΈ°μ‘΄?κ°?+1)
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
