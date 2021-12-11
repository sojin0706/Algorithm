package 코딩테스트준비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2468_안전영역 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static boolean[][]visited;
	static int N;
	static int[][]map,map2;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	static int countmax=Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		map2=new int[N][N];
		
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
				map2[r][c]=map[r][c];
			}
		}//입력완료
		
		//최대와 최소 구하기 (최소 ~ 최대 까지 탐색예정)
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				min=Math.min(min, map[r][c]);
				max=Math.max(max, map[r][c]);
			}
		}
	
		
		//최솟값부터 최댓값까지 dfs로 최대영역개수 구하기 
		while(true) {
			if(min==max+1) {
				if(countmax==0) {
					System.out.println(1);
					break;
				}else {
					System.out.println(countmax);
					break;
				}
			
				
			}
			visited=new boolean[N][N];
			change(); //물에 잠기면 방문 true로 체크 
			int ans=0;
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					if(map[r][c]>min&&visited[r][c]==false) {
						ans++;
						dfs(r,c);
					}
				}
			}
			
			countmax=Math.max(countmax, ans);
			map=map2;
			min++;
			
		}
		

	}
	private static void change() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]<=min) {
					visited[r][c]=true;
				}
			}
		}
		
	}
	private static void dfs(int r,int c) {
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			if(isIn(nr,nc)&&map[nr][nc]>min&&visited[nr][nc]==false) {
				visited[nr][nc]=true;
				dfs(nr,nc);
			}
		}
	}
	
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<N&&c<N;
	}
	
//	private static class Point{
//		int r,c;
//
//		public Point(int r, int c) {
//			super();
//			this.r = r;
//			this.c = c;
//		}
//		
//	}

}
