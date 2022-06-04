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
		visit(0,0,(int)Math.pow(2, N)); //맵의 ?��기는 2^N?��?��. 
		
	}
	static void visit(int r,int c,int l) {
		//0,0�??�� ?��?��
	
		if(l==1) { //길이�? 1?�� ?��?��?���? cnt?��리기 
			if(r==R&&c==C) { //길이�? 1?�� ?��?��?��?��?���? ?��?�� ?��체�?? ?�� ?�� ?��?��. 
				System.out.println(cnt);
				System.exit(0);
			}
			cnt++;
			return;
		}
		
		//?��?�� ?��?���? 쪼개�?
		int half=l/2;
		visit(r,c,half); //1?��분면
		visit(r,c+half,half); //2?��분면
		visit(r+half,c,half); //3?��분면
		visit(r+half,c+half,half); //4?��분면 
		
	}
}
