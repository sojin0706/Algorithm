package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_4796_ķ�� {
	
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception {
		// ķ���� 20���� 10�ϵ��ȸ� ��� ����
		// ���� P���� L�ϵ��ȸ� ��� ����. V�� �ް� ��� ķ���� �ִ� ��ĥ?
		int i=1;
		while(true) {
			tokens=new StringTokenizer(br.readLine());
			
			int L=Integer.parseInt(tokens.nextToken()); //L�ϵ��� ��밡��
			int P=Integer.parseInt(tokens.nextToken()); //���� P�� ��
			int V=Integer.parseInt(tokens.nextToken()); //V��¥�� �ް� ����
			
			//���� ����
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
