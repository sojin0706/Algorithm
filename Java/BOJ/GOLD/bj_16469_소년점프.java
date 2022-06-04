package GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16469_소년점프 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static int[][]map;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1},{0,0}}; 
	static boolean[][]m1,m2,m3;
	static Queue<Point>r1=new LinkedList<>();
	static Queue<Point>r2=new LinkedList<>();
	static Queue<Point>r3=new LinkedList<>();
	static int cnt=0,depth=0,ans1=0,ans2=0;
	
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		map=new int[R+1][C+1];
		
		//입력
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r+1][c+1]=str.charAt(c)-'0';
			}
		}
		
		//배열 초기화
		m1=new boolean[R+1][C+1];
		m2=new boolean[R+1][C+1];
		m3=new boolean[R+1][C+1];
		
		 //값넣기
		tokens=new StringTokenizer(br.readLine());
		r1.offer(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
		tokens=new StringTokenizer(br.readLine());
		r2.offer(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
		tokens=new StringTokenizer(br.readLine());
		r3.offer(new Point(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken())));
		
		bfs();
		
	
		if(ans2==0) {
			System.out.println(-1);
		}else {
			System.out.println(ans1);
			System.out.println(ans2);
		}
		
		
	}
	
	private static void bfs() {
		 while(!r1.isEmpty()&&!r2.isEmpty()&&!r3.isEmpty()) {
			int size1=r1.size();
			int size2=r2.size();
			int size3=r3.size();
			
			//넉살 while문 
			while(size1-->0) {
				Point p=r1.poll();
				m1[p.r][p.c]=true;
				for(int d=0;d<deltas.length;d++) {
					int nr=p.r+deltas[d][0];
					int nc=p.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!m1[nr][nc]&&map[nr][nc]==0) {
						m1[nr][nc]=true;
						r1.offer(new Point(nr,nc));
					}
				}
			}
			
			//스윙스 while문 
			while(size2-->0) {
				Point p=r2.poll();
				m2[p.r][p.c]=true;
				for(int d=0;d<deltas.length;d++) {
					int nr=p.r+deltas[d][0];
					int nc=p.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!m2[nr][nc]&&map[nr][nc]==0) {
						m2[nr][nc]=true;
						r2.offer(new Point(nr,nc));
					}
				}
			}
			
			//창모 while문 
			while(size3-->0) {
				Point p=r3.poll();
				m3[p.r][p.c]=true;
				for(int d=0;d<deltas.length;d++) {
					int nr=p.r+deltas[d][0];
					int nc=p.c+deltas[d][1];
					
					if(isIn(nr,nc)&&!m3[nr][nc]&&map[nr][nc]==0) {
						m3[nr][nc]=true;
						r3.offer(new Point(nr,nc));
					}
				}
			}
			depth++;
			for(int r=0;r<R;r++) {
				for(int c=0;c<C;c++) {
					//다 방문 되어있으면? 
					if(m1[r][c]&&m2[r][c]&&m3[r][c]) {
						//처음 방문한거니까 깊이 저장 
						cnt++;
				}
			}
		}
			//cnt가 한개라도 있으면 만난거니까 return 
			if(cnt!=0) {
				ans1=depth;
				ans2=cnt;
				return;
			}
		}
	}
	private static boolean isIn(int r,int c) {
		return r>=1&&c>=1&&r<=R&&c<=C;
	}
	
	private static class Point{
		int r,c;
		public Point(int r,int c){
			this.r=r;
			this.c=c;
		}
	}

}
