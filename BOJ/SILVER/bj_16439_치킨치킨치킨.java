package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_16439_ġŲġŲġŲ {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	static int[][]arr;
	static int totalmax=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		M=Integer.parseInt(tokens.nextToken());
		arr=new int[N][M];
		for(int r=0;r<N;r++) {
			tokens=new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c]=Integer.parseInt(tokens.nextToken());
			}
		}//�Է¿Ϸ�
		
		makeCombination(3,new int[3],0);
		System.out.println(totalmax);
		
	}
	private static void makeCombination(int toChoosed,int[]choosed,int start) {
		if(toChoosed==0) {
			//�ٻ���
			cal(choosed);
			return;
		}
		for(int i=0;i<M;i++) {
			choosed[choosed.length-toChoosed]=i;
			makeCombination(toChoosed-1,choosed,i+1);
			
		}
	}
	private static void cal(int[]choosed) {
		//�������ŭ for�� ���� �� ���� 3���߿��� �ִ� 1�� ���ϱ�
		int sum=0;
		for(int i=0;i<N;i++) {
			int max=Integer.MIN_VALUE;
			for(int j=0;j<choosed.length;j++) {
				if(arr[i][choosed[j]]>max) {
					max=arr[i][choosed[j]];
				}
			}
			sum+=max;
		}
		if(sum>totalmax) {
			totalmax=sum;
		}
		
	}
}
