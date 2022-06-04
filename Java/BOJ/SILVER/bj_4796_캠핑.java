package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_4796_캠핑 {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception {
		// 캠핑장 20일중 10일동안만 사용 가능
		// 연속 P일중 L일동안만 사용 가능. V일 휴가 사용 캠핑장 최대 며칠?
		int i=1;
		while(true) {
			tokens=new StringTokenizer(br.readLine());
			
			int L=Integer.parseInt(tokens.nextToken()); //L일동안 사용가능
			int P=Integer.parseInt(tokens.nextToken()); //연속 P일 중
			int V=Integer.parseInt(tokens.nextToken()); //V일짜리 휴가 시작
			
			//종료 조건
			if(L==0&&P==0&&V==0) {
				break;
			}
			
			int n=V/P;
			int m=V%P;
			int sum=0;
			
			
			
			if(m>L) {
				sum=n*L+L;
			}else {
				sum=n*L+m;
			}
			
			System.out.println("Case "+i+": "+sum);
			i++;
		}
		
		
	}

}
