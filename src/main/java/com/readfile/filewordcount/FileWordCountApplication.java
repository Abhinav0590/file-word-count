package com.readfile.filewordcount;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.readfile.filewordcount.utils.components.WordCount;

@Configuration
public class FileWordCountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FileWordCountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		WordCount wordsCount = new WordCount();
		Map<String, AtomicInteger> sortedWordsList = wordsCount.getSortedWordList();
		sortedWordsList.forEach((word, count) -> System.out.println(word +"\t" + count));
	}
}
