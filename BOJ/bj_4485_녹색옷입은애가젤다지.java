import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_4485_녹색옷입은애가젤다지 {
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
			if(N==0) break; //0이면 탈출
			
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				tokens=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(tokens.nextToken());
				}
			} //입력 완료
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
		//0,0부터 시작할거다
		for(int[]arr:cost) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		cost[0][0]=0; //내가 시작할 0,0은 0으로 초기화(제일 최솟값이다.)
		pq.offer(new Node(0,0,map[0][0]));
		
		while(!pq.isEmpty()) {
			Node head=pq.poll();
			if(head.r==N-1&&head.c==N-1) {
				min=head.cost; //끝에 도달
			}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)) {
					int oldCost=cost[nr][nc];
					int newCost=head.cost+map[nr][nc];
					
					if(newCost<oldCost) {
						cost[nr][nc]=newCost;
						pq.offer(new Node(nr,nc,newCost)); //새로운값 넣기
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
