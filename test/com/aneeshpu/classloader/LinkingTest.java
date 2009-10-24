package com.aneeshpu.classloader;

import static org.junit.Assert.*;
import static org.junit.Assert.assertFalse;

import java.io.File;

import org.junit.Test;

public class LinkingTest {

	@Test
	public void should_fail_to_find_class_on_classpath_even_after_class_is_copied_back() throws Exception {

		Linking linking = new Linking();
		linking.removeBooksFromClassPath();

		String basePath = "/home/aneeshpu/workspace/JavaClassLinkingExample/bin/";
		String packagePath = "com/aneeshpu/classloader/";
		String originalClass = basePath + packagePath + "Book.class";

		assertFalse(new File(originalClass).exists());

		Author author = new Author();
		try {
			author.add(new Book());
			fail("expected book to not be found on classpath");
		} catch (Throwable e) {
//			e.printStackTrace();
		}

		linking.addBooksBackToClassPath();

		assertTrue("Expected books to have been copied back into the classpath", new File(originalClass).exists());

		try {
			author.add(new Book());
			fail("expected book to not be found on classpath");
		} catch (Throwable e) {
//			e.printStackTrace();
		}
	}
}