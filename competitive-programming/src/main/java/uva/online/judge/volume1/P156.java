package uva.online.judge.volume1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

//156 - Anagrams
public class P156 {

	private static HashMap<String, List<String>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		map = new HashMap<>();
		while ((input = br.readLine()).compareTo("#") != 0) {
			String[] tokens = input.trim().split(" ");
			for(String token: tokens) {
				String hash = getHash(token);
				if(map.containsKey(hash)) {
					map.get(hash).add(token);
				} else {
					List<String> list = new ArrayList<>();
					list.add(token);
					map.put(hash, list);
				}
			}
		}
		List<String> anagrams = new ArrayList<String>();
		for(String key: map.keySet()) {
			if(map.get(key).size() == 1) {
				anagrams.add(map.get(key).get(0));
			}
		}
		Collections.sort(anagrams);
		for(String word: anagrams)
			System.out.println(word);
	}

	private static String getHash(String token) {
		char[] hashArray = token.toUpperCase().toCharArray();
		Arrays.sort(hashArray);
		return new String(hashArray);
	}

}