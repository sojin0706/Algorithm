package GOLD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_3109_ë¹µì§‘ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static char[][]map;
	static int R,C,cnt;
	static boolean result;
	static int[]deltas= {-1,0,1}; //rowë§? ?¡?•„ì£¼ê¸° 
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
			dfs(i,0); //i?–‰,0?—´ë¶??„° ?‹œ?‘?•´?„œ ê°„ë‹¤.
		}
		System.out.println(cnt);
	}
	
	static boolean dfs(int r,int c) {
		//ê¸°ì?ì¡°ê±´ =>?¬ê·?ë¡? ?¸?•´?„œ ?—¬?Ÿ¬ê°ˆë˜ ?ƒ?ƒ‰?„ ?•˜?Š”?°, ë§Œì•½ ?„?‹¬?–ˆ?œ¼ë©? ?‹¤ë¥¸ì• ?“¤ ê°?ì§?ì¹˜ê¸° ?•˜ì§? ?•Š?„ë¡? ì°¨ë‹¨
		if(c==C-1) { //ë§Œì•½ C-1??— ?„?‹¬?–ˆ?œ¼ë©??
			cnt++;
			return true;
		}
		 
		for(int d=0;d<deltas.length;d++) {
			int nr=r+deltas[d];
			int nc=c+1;
			if(ischeck(nr,nc)==true&&map[nr][nc]=='.') {
				map[nr][nc]='X'; //Xë¡? ë°”ê¾¸ê³?
				if(dfs(nr,nc)==true) { //?•„ê¹? ê°„ê²Œ trueë©? 
					return true; //ë§Œì•½ trueë©? ê°?ì§?ì¹˜ê¸° stop?•˜ê³? trueë¡? ë°”ê¿”ì£¼ê¸° 
				}
		//		dfs(nr,nc); //ë§Œì•½ falseë©? ?´ê²? ?‹¤?–‰ 	
			}
		}
		return false; //?—¬ê¸°ê¹Œì§? ?™”?œ¼ë©? false
		
	}
	static boolean ischeck(int r,int c) {
		if(r>=0&&r<R&&c>=0&&c<C) return true;
		else return false;
	}

}
