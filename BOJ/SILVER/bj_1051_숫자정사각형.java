package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1051_숫자정사각형 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static int[][]map;
	static int k;
	public static void main(String[] args) throws Exception{
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		map=new int[R][C];
		for(int r=0;r<R;r++) {
			String str=br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c]=str.charAt(c)-'0';
			}
		}
		//다해보기 
		int max=1; //최댓값은 일단 1이다.
		k=Math.min(R, C)-1; //최대가 k만큼이다. 
		
		for(int r=0;r<R-1;r++) {
			for(int c=0;c<C-1;c++) {
				int temp=check(r,c);
				max=Math.max(temp, max);
			}
		}
		System.out.println(max);
	}
	private static int check(int r,int c) {
		int i=1;
		int max=1;
		while(true) {
			if(i>k) {
				break;
			}
			if(isIn(r+i,c+i)) {
				if(map[r][c]==map[r+i][c]&&map[r][c]==map[r+i][c+i]&&map[r][c]==map[r][c+i]&&isIn(r+i,c+i)){
					max=(i+1)*(i+1);
				}
			}
			i++;
		}
		return max;
	}
	private static boolean isIn(int r,int c) {
		return r>=0&&r<R&&c>=0&&c<C;
	}

}
