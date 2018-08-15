package com.readfile.filewordcount.utils.components;

import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
public class ParseFileTest {
	
	@Test
	public void readFileTest() {
		assertNotNull("List of String is not returned ", ParseFile.readFile());

	}

}
