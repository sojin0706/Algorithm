package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_4485_?…¹?ƒ‰?˜·?…???• ê°?? ¤?‹¤ì§? {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N,t=1;
	static int[][]map;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int min;
	public static void main(String[] args) throws IOException {
		while(true) {
			
			N=Integer.parseInt(br.readLine());
			if(N==0) break; //0?´ë©? ?ƒˆì¶?
			
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				tokens=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(tokens.nextToken());
				}
			} //?…? ¥ ?™„ë£?
			min=Integer.MAX_VALUE;
			
			dijkstra();
			output.append("Problem ").append(t).append(": ").append(min).append("\n");
			t++;
		}
		System.out.println(output);
	}
	private static void dijkstra() {
		PriorityQueue<Node>pq=new PriorityQueue<>();
		int[][]cost=new int[N][N];
		//0,0ë¶??„° ?‹œ?‘?• ê±°ë‹¤
		for(int[]arr:cost) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		cost[0][0]=0; //?‚´ê°? ?‹œ?‘?•  0,0?? 0?œ¼ë¡? ì´ˆê¸°?™”(? œ?¼ ìµœì†Ÿê°’ì´?‹¤.)
		pq.offer(new Node(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Node head=pq.poll();
			if(head.r==N-1&&head.c==N-1) {
				min=head.cost; //??— ?„?‹¬
			}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)) {
					int oldCost=cost[nr][nc];
					int newCost=head.cost+map[nr][nc];
					
					if(newCost<oldCost) {
						cost[nr][nc]=newCost;
						pq.offer(new Node(nr,nc,newCost)); //?ƒˆë¡œìš´ê°? ?„£ê¸?
						}
				}
			}
		}
	
		
		
	}
	static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&c<N&&r<N;
	}
	
	static class Node implements Comparable<Node>{
		int r,c,cost;
		
		

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}



		@Override
		public int compareTo(Node o) {
			
			return this.cost-o.cost;
		}
		
	}

}
