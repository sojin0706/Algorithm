package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_16472_����� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static char[]arr;
	static int[]alph;
	static int N;
	public static void main(String[] args) throws Exception{
		N=Integer.parseInt(br.readLine());
		
		// N���� ������ ���ĺ����� �������Ѵ�.
		
		String str=br.readLine();
		arr=new char[str.length()];
		for(int i=0;i<str.length();i++) {
			arr[i]=str.charAt(i);
		}
		int max=Integer.MIN_VALUE;
		// ���غ���
		for(int i=0;i<str.length()-1;i++) {
			alph=new int[26];
			int cnt=1; // ù��°���� ��-1���� �� �غ��� 
			int len=1;
			char start=arr[i]; // �� ���ڿ�
			for(int j=i+1;j<str.length();j++) {
				if(start!=arr[j]) {
					if(alph[arr[j]-'a']==0) {
						cnt++; //������ �ø��� �ȵȴ�. -> ���� ������ ������ �����Ŷ�� ++
						alph[arr[j]-'a']++;
					}
				}
				if(cnt>N) {
					break; //ũ�� for���� Ż���Ѵ�.
				}
				len++; //���������� �ʾҴٸ� 
			}
			
			max=Math.max(max, len);
		}
		
		System.out.println(max);
		
	}

}
