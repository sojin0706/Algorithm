package SILVER;
package ?˜¼???ê¸?;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//ê¸°ë³¸?›ë¦?: bfs?¸?°, ì²˜ìŒ ë°©ë¬¸?•˜?Š”?• ê°? ? œ?¼ 'ì²˜ìŒ'?œ¼ë¡? ?„ì°©í•˜?Š” ?• ?´?‹¤.
//êµ³ì´ ìµœì†Ÿê°’ì„ êµ¬í•˜ì§? ?•Šê³? 1ì°¨ì› ë°°ì—´ë¡? ì²˜ë¦¬?•´ì£¼ê¸° 
//ê·? 1ì°¨ì› ë°°ì—´?— ëª‡ì´ˆ?— ë°©ë¬¸?–ˆ?Š”ì§? ? ?–´ì£¼ê¸° 
public class bj_1697_?ˆ¨ë°”ê¼­ì§? {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]visited=new int[100001];
	
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		//ë§Œì•½ ê°™ìœ¼ë©? ?”?´?ƒ ?•´ë³¼ê²ƒ?„ ?—†?´ 0?´?‹¤.
		if(N==K) {
			System.out.println(0);
			return;
		}
		//?•„?‹ˆ?¼ë©? bfsë¡? ?ƒ?ƒ‰
		bfs();
		//?–´ì°¨í”¼ visitedë°°ì—´?—?Š” ìµœì†Ÿê°’ì´ ?‹´ê²¨ì ¸ ?ˆ?œ¼?‹ˆ ê·¸ëƒ¥ ì¶œë ¥ 
		System.out.println(visited[K]);

	}
	static void bfs() {
		Queue<Integer>queue=new LinkedList<>();
		queue.offer(N); //? œ?¼ ì²˜ìŒ?—” ?ˆ˜ë¹ˆì´?˜ ?œ„ì¹˜ë?? ?„£?Š”?‹¤.
		visited[N]=0; //?ˆ˜ë¹ˆì´?Š” 0ì´ˆì— ë°©ë¬¸?–ˆ?‹¤ê³? ?ƒê°?
		
		while(!queue.isEmpty()) {
			int head=queue.poll();
			//	ë²”ìœ„ ?•ˆ?— ?ˆê³?			?•„ì§? ë°©ë¬¸?•˜ì§? ?•Š?•˜?‹¤ë©?
			if(isIn(head-1)&&visited[head-1]==0) {
				queue.offer(head-1);
				 //head-1?? ëª‡ì´ˆ?— ë°©ë¬¸?–ˆ?Š”ì§? ? ?–´ì£¼ê¸° (ê¸°ì¡´?‹œê°?+1)
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
