

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class bj_20291_파일정리 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output=new StringBuilder();
	static int N;
	static Map<String,Integer> map=new HashMap<>();
	static String word1="";
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<word.length();j++) {
				if(word.charAt(j)=='.') {
					word1=word.substring(j+1,word.length()); //뒤에 파일명만 따로 저장
					if(map.get(word1)==null) {
						map.put(word1, 1);
					}else {
						map.put(word1, map.get(word1)+1);
					}
				}
			}//입력완료
	}
		ArrayList<String>list=new ArrayList<>();
		//key의 값만 얻어와서 저장한다. 
		for (String key : map.keySet()) {
			list.add(key);
		}   
		Collections.sort(list); //맵 순서대로 정렬후 
		for(int t=0;t<list.size();t++) {
			System.out.println(list.get(t)+" "+map.get(list.get(t)));
		}
		
		
		
	}

}
