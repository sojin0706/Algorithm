package SILVER;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1074_Z {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static StringTokenizer tokens;
	static int N,R,C;
	static int cnt;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		cnt=0;
		visit(0,0,(int)Math.pow(2, N)); //ë§µì˜ ?¬ê¸°ëŠ” 2^N?´?‹¤. 
		
	}
	static void visit(int r,int c,int l) {
		//0,0ë¶??„° ?‹œ?‘
	
		if(l==1) { //ê¸¸ì´ê°? 1?— ?„?‹¬?•˜ë©? cnt?Š˜ë¦¬ê¸° 
			if(r==R&&c==C) { //ê¸¸ì´ê°? 1?— ?„?‹¬?–ˆ?–´?•¼ì§? ?–˜?˜ ? •ì²´ë?? ?•Œ ?ˆ˜ ?ˆ?‹¤. 
				System.out.println(cnt);
				System.exit(0);
			}
			cnt++;
			return;
		}
		
		//?‹µ?´ ?—†?œ¼ë©? ìª¼ê°œê¸?
		int half=l/2;
		visit(r,c,half); //1?‚¬ë¶„ë©´
		visit(r,c+half,half); //2?‚¬ë¶„ë©´
		visit(r+half,c,half); //3?‚¬ë¶„ë©´
		visit(r+half,c+half,half); //4?‚¬ë¶„ë©´ 
		
	}
}
