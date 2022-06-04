package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1929_소수구하기 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output=new StringBuilder();
	static int N,M;
	public static void main(String[] args) throws Exception {
		

		tokens=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());

	    boolean[] temp = new boolean[M+1];
	   
	    temp[1]=true;
	    // 2의배수, 3의배수, 4의배수 ... 거르기 (M보다 작은애들만)
	    for(int i=2;i<=M;i++) {
	    	for(int j=2;i*j<=M;j++) {
	    		temp[i*j]=true;
	    	}
	    }
	    for(int i=N;i<=M;i++) {
	    	if(!temp[i]) {
	    		System.out.println(i);
	    	}
	    }
	}

}
