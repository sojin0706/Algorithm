package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_20413_���̾Ƹ�� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	//���� ������ ������ �����Ѱ��� ���� �̹��޿� ������ ���� ���´�. 
	//�ִ��� ���ؾ��ϴϱ� ���� ��� -1 �� ���� �ִ��̴�. 
	
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
