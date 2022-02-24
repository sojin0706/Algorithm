package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1743_음식물피하기 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][]map;
	static int R,C,N;
	static int[][]deltas= {{-1,0},{1,0},{0,-1},{0,1}};
	static int cnt;
	static int max=Integer.MIN_VALUE;
	static boolean[][]visited;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		N=Integer.parseInt(tokens.nextToken());
		map=new int[R+1][C+1];
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(tokens.nextToken());
			int b=Integer.parseInt(tokens.nextToken());
			map[a][b]=1; //음식물
		}
		visited=new boolean[R+1][C+1];
		for(int r=1;r<=R;r++) {
			for(int c=1;c<=C;c++) {
				if(!visited[r][c]&&map[r][c]==1) {
					cnt=1;
					visited[r][c]=true;
					int ans=dfs(r,c);
					max=Math.max(ans, max);
				}
			}
		}
		System.out.println(max);
	
	}
	private static int dfs(int r,int c) {
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d][0];
			int nc=c+deltas[d][1];
			if(isIn(nr,nc)&&!visited[nr][nc]&&map[nr][nc]==1) {
				visited[nr][nc]=true;
				cnt++;
				dfs(nr,nc);
			}
		}
		return cnt;
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&c>=0&&r<=R&c<=C;
	}
	

}
