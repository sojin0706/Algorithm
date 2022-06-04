package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3109_빵집 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static char[][]map;
	static int R,C,cnt;
	static boolean result;
	static int[]deltas= {-1,0,1}; //row�? ?��?��주기 
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		map=new char[R][C];
		for(int i=0;i<R;i++) {
			String str=br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		for(int i=0;i<R;i++) {
			dfs(i,0); //i?��,0?���??�� ?��?��?��?�� 간다.
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int r,int c) {
		//기�?조건 =>?���?�? ?��?��?�� ?��?��갈래 ?��?��?�� ?��?��?��, 만약 ?��?��?��?���? ?��른애?�� �?�?치기 ?���? ?��?���? 차단
		if(c==C-1) { //만약 C-1?��?�� ?��?��?��?���??
			cnt++;
			return true;
		}
		 
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d];
			int nc=c+1;
			if(ischeck(nr,nc)==true&&map[nr][nc]=='.') {
				map[nr][nc]='X'; //X�? 바꾸�?
				if(dfs(nr,nc)==true) { //?���? 간게 true�? 
					return true; //만약 true�? �?�?치기 stop?���? true�? 바꿔주기 
				}
		//		dfs(nr,nc); //만약 false�? ?���? ?��?�� 	
			}
		}
		return false; //?��기까�? ?��?���? false
		
	}
	static boolean ischeck(int r,int c) {
		if(r>=0&&r<R&&c>=0&&c<C) return true;
		else return false;
	}

}
