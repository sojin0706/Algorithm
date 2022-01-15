

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_��� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N=Integer.parseInt(br.readLine());
		tokens=new StringTokenizer(br.readLine());
		map=new int[N];
		
		for(int i=0;i<N;i++) {
			map[i]=Integer.parseInt(tokens.nextToken());
		}
		Arrays.sort(map); //�ϴ� �����ϱ� 
		
		//�������� ����ϱ�
		int start=0;
		int end=N-1;
		int store1=0;
		int store2=0;
		int min=Integer.MAX_VALUE;
		while(start<end) {
			int a=map[start]+map[end];
			int b=Math.abs(a);
			if(min>b) {
				min=b;
				store1=map[start];
				store2=map[end];
			}
			
			if(a<0) {
				//0���� ������ a�� �ø���.(�� Ű������)
				start++;
				
			}else if(a>0) {
				//0���� ũ�� a�� ���δ�
				end--;
			}else if(a==0) {
				break;//0�̸� ���̻������� ����
			}
			
		}
		System.out.println(store1+" "+store2);
		
		
	}

}
