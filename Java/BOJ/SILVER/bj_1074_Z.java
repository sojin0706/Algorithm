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
		visit(0,0,(int)Math.pow(2, N)); //λ§΅μ ?¬κΈ°λ 2^N?΄?€. 
		
	}
	static void visit(int r,int c,int l) {
		//0,0λΆ??° ??
	
		if(l==1) { //κΈΈμ΄κ°? 1? ??¬?λ©? cnt?λ¦¬κΈ° 
			if(r==R&&c==C) { //κΈΈμ΄κ°? 1? ??¬??΄?Όμ§? ?? ? μ²΄λ?? ? ? ??€. 
				System.out.println(cnt);
				System.exit(0);
			}
			cnt++;
			return;
		}
		
		//?΅?΄ ??Όλ©? μͺΌκ°κΈ?
		int half=l/2;
		visit(r,c,half); //1?¬λΆλ©΄
		visit(r,c+half,half); //2?¬λΆλ©΄
		visit(r+half,c,half); //3?¬λΆλ©΄
		visit(r+half,c+half,half); //4?¬λΆλ©΄ 
		
	}
}
