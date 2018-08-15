package com.readfile.filewordcount.utils.components;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class WordCountTest {

	@InjectMocks
	private WordCount wordCount;
	
	@Test
	public void getSortedWordList() {

		Map<String, AtomicInteger> sortedWordLists = getExpectedHashMap();
		Integer expectedResponseSize = sortedWordLists.size();
		assertTrue(
				"the expected response is not returned" + sortedWordLists + "response" + wordCount.getSortedWordList(),
				expectedResponseSize.equals(new Integer(wordCount.getSortedWordList().size())));

	}

	private Map<String, AtomicInteger> getExpectedHashMap() {

		Map<String, AtomicInteger> sortedWordListExp = new LinkedHashMap<>();
		sortedWordListExp.put("I", new AtomicInteger(443));
		sortedWordListExp.put("the", new AtomicInteger(415));
		sortedWordListExp.put("and", new AtomicInteger(372));
		sortedWordListExp.put("of", new AtomicInteger(263));
		sortedWordListExp.put("a", new AtomicInteger(259));
		sortedWordListExp.put("to", new AtomicInteger(254));
		sortedWordListExp.put("my", new AtomicInteger(253));
		sortedWordListExp.put("you", new AtomicInteger(177));
		sortedWordListExp.put("this", new AtomicInteger(148));
		sortedWordListExp.put("that", new AtomicInteger(145));

		return sortedWordListExp;

	}

}
