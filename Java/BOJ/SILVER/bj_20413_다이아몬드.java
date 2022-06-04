package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_20413_다이아몬드 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	//지금 돈에서 이전에 과금한것을 빼면 이번달에 과금한 돈이 나온다. 
	//최댓값을 구해야하니까 다음 등급 -1 한 값이 최댓값이다. 
	
	public static void main(String[] args) throws Exception {
		N=Integer.parseInt(br.readLine());
		tokens=new StringTokenizer(br.readLine());
		
		int S=Integer.parseInt(tokens.nextToken());
		int G=Integer.parseInt(tokens.nextToken());
		int P=Integer.parseInt(tokens.nextToken());
		int D=Integer.parseInt(tokens.nextToken());
		
		String grade=br.readLine();
		
		int sum=0;
		int temp=0;
		
		for(int i=0;i<grade.length();i++) {
			if(grade.charAt(i)=='B') {
				sum+=S-1-temp;
				temp=S-1-temp;
			}else if(grade.charAt(i)=='S') {
				sum+=G-1-temp;
				temp=G-1-temp;
			}else if(grade.charAt(i)=='G') {
				sum+=P-1-temp;
				temp=P-1-temp;
			}
			else if(grade.charAt(i)=='P') {
				sum+=D-1-temp;
				temp=D-1-temp;
			}
			else if(grade.charAt(i)=='D') {
				sum+=D;
				temp=D;
			}
			
			
		}
		System.out.println(sum);
		
		
	}

}
