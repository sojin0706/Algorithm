package 혼자풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//1.0인곳에 3개의 벽 세우기  => nC3 전체의 빈 공간에서 3개의 빈 공간을 선택해보자 => 벽 건설 (모든 공간을 돌아다니면서)
// 바이러스를 중심으로 퍼질수있는거 찾아보니(사방탐색으로 갈 수 있는 공간이 있으면 go)
// =>BFS(최단거리)/DFS => 이 문제는 얼마나 빠른속도로 퍼지냐는 중요하지 않으니까 bfs/dfs 어떤걸 쓰던 상관이 없다.
//남아있는 0번의 개수를 세어서 최대값 출력하기 


// 즉, 조합으로 3개를 뽑은다음에 벽을 세운 후 바이러스를 사방탐색을 시켜 갈 수 있는 0의 개수의 최대값을 구해보기 

public class bj_14502_연구소 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int[][]map;
	static int R,C;
	static List<Point> virus; //바이러스를 저장
	static List<Point> normal; //0을 저장 
	static int MAX=Integer.MIN_VALUE;
	static int[][]deltas= {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		 R=Integer.parseInt(tokens.nextToken()); //행
		 C=Integer.parseInt(tokens.nextToken()); //열
		 map=new int[R][C];
		 virus=new ArrayList<>();
		 normal=new ArrayList<>();
		for(int i=0;i<R;i++) {
			tokens=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(tokens.nextToken());
				if(map[i][j]==2) {
					virus.add(new Point(i,j)); //행과 열을 저장
				}else if(map[i][j]==0) {
					normal.add(new Point(i,j)); //만약 0이면 정상에 저장
				}
			} 
		}
		//이제 normal에 저장된것중에  3개의 위치를 조합으로 골라보기
		makeWallCombination(3,new Point[3],0);
		
		System.out.println(MAX);
		
	}
	
	private static void makeWallCombination(int toChoose,Point[]choosed,int start) {
		if(toChoose==0) {
			//벽 설치 위치 선정 끝 --> 벽 세우고, 안전영역 확인해보자 
			check(choosed);
			return;
		}
		for(int i=start;i<normal.size();i++) {
			choosed[choosed.length-toChoose]=normal.get(i);
			makeWallCombination(toChoose-1,choosed,i+1);
		}
	}
	
	public static void check(Point[]visited) {
		//1.이것들로 벽 세우기
		
		for(Point p:visited) {
			map[p.r][p.c]=1; //벽 세워주기
		}
		
		//2.바이러스 퍼트리고 카운트하기
		
		int polluted=bfs();
		
		MAX=Math.max(MAX, normal.size()-polluted-3);
		
		for(Point p:visited) {
			map[p.r][p.c]=0; //벽 초기화
		}	
		
	
	}
	
	public static int bfs() {
		//기본적으로 bfs는 queue사용
		Queue<Point> q=new LinkedList<>();
		boolean[][]visited=new boolean[R][C]; //방문여부 확인
		int Polluted=0;
		for(Point head:virus) {
			q.offer(head);
			visited[head.r][head.c]=true;
		}
		
		while(!q.isEmpty()) {
			Point head=q.poll();
			for(int d=0;d<deltas.length;d++) {
				int nr=head.r+deltas[d][0];
				int nc=head.c+deltas[d][1];
				
				if(isIn(nr,nc)&&map[nr][nc]==0&&visited[nr][nc]==false) {
					visited[nr][nc]=true;
					q.offer(new Point(nr,nc));
					Polluted++;
				}
			}
		}
		
		return Polluted;
		
	}
	public static boolean isIn(int r,int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}
	
	
	static class Point{
		int r,c; //행과 열을 저장할수있게한다. 
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

}
