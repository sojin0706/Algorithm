import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_1249_보급로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N;
	static int[][]map;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			for(int r=0;r<N;r++) {
				String str=br.readLine();
				for(int c=0;c<N;c++) {
					map[r][c]=str.charAt(c)-'0';
				}
			}
			
			int result=dik();
			output.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(output);
	}
	private static int dik() {
		PriorityQueue<Point>queue=new PriorityQueue<>();
		queue.offer(new Point(0,0,map[0][0])); //0,0은 시작점: 거기의 가치는 0이다.
		int[][]cost=new int[N][N];
		for(int[]arr:cost) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		cost[0][0]=0;
		
		while(!queue.isEmpty()) {
			Point head=queue.poll();
			if(head.r==N-1&&head.c==N-1) {
				return head.cost;
			}
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)) {
					int oldcost=cost[nr][nc];
					int newcost=map[nr][nc]+head.cost;
					if(oldcost>newcost) {
						cost[nr][nc]=newcost;
						queue.offer(new Point(nr,nc,newcost));
					}
				}
			}
		}
		return -1;
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	
	private static class Point implements Comparable<Point>{
		int r,c,cost;

		public Point(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			
			return this.cost-o.cost;
		}
		
	}

}
