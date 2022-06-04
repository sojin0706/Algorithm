package GOLD;
import java.io.*;
import java.util.*;


public class bj_17141_연구소2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,C;
	static int[][]map;
	static int min=Integer.MAX_VALUE;
	static int count=0;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static List<Point>possible;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		possible=new LinkedList<>();
		map=new int[N][N];
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
				if(map[r][c]==2) {
					possible.add(new Point(r,c)); //바이러스 놓을 수 있는 곳 저장
				}else if(map[r][c]==0) {
					count++;
				}
			}
		}
		//전체개수에는 선택되지않은 바이러스의 개수도 들어가야한다.
		count=count+possible.size()-C;
		makeCombination(C,new Point[C],0);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void makeCombination(int toChoose,Point[]choosed,int start) {
		if(toChoose==0) {
			int time1=bfs(choosed);
			if(time1!=-1) {
				if(min>time1) {
					min=time1;
				}
			}
			return;
		}
		for(int i=start;i<possible.size();i++) {
			choosed[choosed.length-toChoose]=possible.get(i);
			makeCombination(toChoose-1,choosed,i+1);
		}
	}

	private static int bfs(Point[]virus) {
		Queue<Point>queue=new LinkedList<>();
		boolean[][]visited=new boolean[N][N];
		int total=count;
		for(Point p:virus) {
			queue.offer(new Point(p.r,p.c)); //queue에 virus로 변경한 포인트들 넣기 
			visited[p.r][p.c]=true;
		}
		int size=0;
		int time=0; //전역으로 선언했음 
		
		while(!queue.isEmpty()) {
			size=queue.size();
			while(size-->0) {
				Point head=queue.poll();
				for(int d=0;d<deltas.length;d++) {
					int nr=head.r+deltas[d][0];
					int nc=head.c+deltas[d][1];
					//범위 내 , 방문 x, map이 벽이 아니면 간다. (0이랑2는 갈 수 있다)
					if(isIn(nr,nc)&&visited[nr][nc]==false&&map[nr][nc]!=1) {
						queue.offer(new Point(nr,nc));
						visited[nr][nc]=true;
						total--;
					}
				}
			}
			if(queue.size()>0) {
				time++;
			}
		}
		if(total>0) {
			time=-1;
			return time;
		}
		return time;
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	
	private static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

}
