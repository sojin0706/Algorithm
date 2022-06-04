package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14889_스타트와링크_ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[][]map;
	static boolean[]visited;
	static int N;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(br.readLine());
		visited=new boolean[N];
		map=new int[N][N];
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c]=Integer.parseInt(tokens.nextToken());
			}
		} //입력 완료
		dfs(0,0);
		System.out.println(min);
	}
	private static void dfs(int cnt,int start) {
		//도달하면? 
		if(cnt==N/2) {
			check(visited);
			return;
		}
		for(int i=start;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(cnt+1,i+1);
				visited[i]=false; //갈림길에서 갔다가 끝나면 다시 돌아옴 
			}
		}
	}
	
	private static void check(boolean[]visited) {
			int sum1=0;
			int sum2=0;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(visited[i]&&visited[j]) {
						sum1+=map[i][j]+map[j][i];
					}else if(!visited[i]&&!visited[j]) {
						sum2+=map[i][j]+map[j][i];
					}
				}
			}
			int total=Math.abs(sum1-sum2);
			min=Math.min(total, min);
	} 

}
