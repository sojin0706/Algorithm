package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_20437_���ڿ�����2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	
	public static void main(String[] args) throws Exception{
		int T=Integer.parseInt(br.readLine());
		char[]arr;
		int[]alph;
		for(int t=0;t<T;t++) {
			alph=new int[26]; //���ĺ� ���� 
			String str=br.readLine();
			int N=Integer.parseInt(br.readLine());
			
			arr=new char[str.length()];
			for(int i=0;i<str.length();i++) {
				arr[i]=str.charAt(i);
				alph[str.charAt(i)-97]++;
			}

			int min=Integer.MAX_VALUE; //���� ª�� ���� ���ڿ� ����
			int max=Integer.MIN_VALUE; //���� �� ���ڿ� ���� 
			boolean flag=false;
			//Ư�� ���ĺ��� ���̰� N���ΰ� ã�� 
			for(int i=0;i<str.length();i++) {
				// N���� ū�� �������� Ȯ���Ѵ�. 
				if(alph[arr[i]-97]>=N) {
					flag=true;
					int cnt=0;
					
					for(int j=i;j<str.length();j++) {
						//������ ������
						if(str.charAt(j)==str.charAt(i)) {
							cnt++;
							}
						if(cnt==N) {
							min=Math.min(min, j-i+1); //������ �ּҴ� ���� ��������
							max=Math.max(max, j-i+1); //�ִ�� ù/���� ���ƾ��� 
							break;
						}
					}
				}
			}
			if(flag==false) {
				System.out.println(-1);
			}else {
				System.out.println(min+" "+max);
			}
		}
	}

}
