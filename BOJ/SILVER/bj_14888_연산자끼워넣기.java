package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//�ߺ������� ���Ѵ��� ����Ǿ��ִ� �Ŀ��� ������ �ֱ� 
public class bj_14888_�����ڳ����ֱ� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]num ;
	static ArrayList<String> list = new ArrayList<String>();
	static int N,total=0;
	static int min=Integer.MAX_VALUE;
	static int max=Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		tokens=new StringTokenizer(br.readLine());
		num=new int[N];
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(tokens.nextToken());
		}//������� �־��ֱ�
		
		//������ �޾Ƽ� list�� �־��ֱ� 
		tokens=new StringTokenizer(br.readLine());
		int plus=Integer.parseInt(tokens.nextToken());
		for(int i=0;i<plus;i++) {
			list.add("+");
		}
		int minus=Integer.parseInt(tokens.nextToken());
		for(int i=0;i<minus;i++) {
			list.add("-");
		}
		int mul=Integer.parseInt(tokens.nextToken());
		for(int i=0;i<mul;i++) {
			list.add("*");
		}
		int div=Integer.parseInt(tokens.nextToken());
		for(int i=0;i<div;i++) {
			list.add("/");
		}
		
		
		//���� �� ������ ������� permutation���ֱ�
		permutation(N-1,new String[N-1],new boolean[N-1]);
		
		System.out.println(max);
		System.out.println(min);

	}
	private static void permutation(int toChoose,String[] choosed,boolean[] visited) {
		if(toChoose==0) {
			cal(choosed);
			return;
		}
		for(int i=0;i<list.size();i++) {
			if(visited[i]) {
				continue;
			}else {
				choosed[choosed.length-toChoose]=list.get(i);
				visited[i]=true;
				permutation(toChoose-1,choosed,visited);
				visited[i]=false;
			}
			
		}
	}
	private static void cal(String[]choosed) {
		
		int i=0;
		int j=0;

		while(true) {
			//���ڸ� �� �̾��� ��� 
			if(i==N) {
				break;
			}
			if(i==0) {
				total=num[i];
				i++;
			}
			if(choosed[j]=="+") {
				total+=num[i];
			}else if(choosed[j]=="-") {
				total-=num[i];
			}else if(choosed[j]=="/") {
				total/=num[i];
			}else if(choosed[j]=="*") {
				total*=num[i];
			}
			
			i++;
			j++;
		}
		min=Math.min(min, total);
		max=Math.max(max, total);
		
	}
	
	

}
