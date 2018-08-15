package com.readfile.filewordcount.utils.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.readfile.filewordcount.utils.Constants;;

@Component
public class WordCount {
	
	public Map<String, AtomicInteger> getSortedWordList() {
		 Map<String, AtomicInteger> wordCount = new HashMap<>();

	        List<String> wordsList = ParseFile.readFile();

	        wordsList.forEach(line -> {
	            String[] words = line.split(Constants.WORD_SPLIT_REGEX);
	            Arrays.stream(words).forEach(word -> {
	                if (wordCount.containsKey(word)) {
	                    wordCount.get(word).incrementAndGet();
	                } else {
	                    wordCount.put(word, new AtomicInteger(1));
	                }
	            });
	        });

	        return displaySortedList(wordCount);

	    }

	private Map<String, AtomicInteger> displaySortedList(Map<String, AtomicInteger> wordCount) {
		List<Map.Entry<String, AtomicInteger>> list = new ArrayList<>(wordCount.entrySet());
		list.sort(Map.Entry.comparingByValue((i1, i2) -> i2.get() - i1.get()));

		Map<String, AtomicInteger> sortedWordList = new LinkedHashMap<>();
		for (Map.Entry<String, AtomicInteger> entry : list.subList(0, 10)) {
		    sortedWordList.put(entry.getKey(), entry.getValue());
		}
		
		return sortedWordList;

		
	}
		
		
	}


