package com.readfile.filewordcount.utils.components;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.readfile.filewordcount.utils.Constants;

@Component
public class ParseFile {

	private static Log log = LogFactory.getLog(ParseFile.class);

	public static List<String> readFile() {
		List<String> lines = new ArrayList<>();
		try {
			
			lines = Files.readAllLines(Paths.get(Constants.FILE_NAME));
			
		}catch(IOException e) {
			log.error("unable to read the file" + e.getMessage(),e);
			
		}
		
		return lines;

	}

}
