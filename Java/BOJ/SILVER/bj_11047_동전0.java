package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_11047_����0 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]coin;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		coin=new int[N];
		
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		} //���� �Է¹ޱ�
		
		int cnt=0;
		int T=N-1;
		while(true) {
			if(K==0) {
				break;
			}
			for(int i=T;i>=0;i--) {
				if(coin[i]<=K) {
					//ã����
					K-=coin[i];
					T=i;
					cnt++;
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
		
		
		
	}

}
