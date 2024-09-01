package com.sudheer.Service;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sudheer.model.Book;
import com.sudheer.service.BookService;

@SpringBootTest
class MyBookProjectApplicationTests {
	@Autowired
	BookService service;
	


	@ParameterizedTest
	@MethodSource("provideBooksAndExpectedResults")
	public void saveBook(Book k,String bookName,String branchName) throws Exception {
		k.setBname(bookName);
		k.setBranch(branchName);
		Book b = service.saveBook(k);
		Assertions.assertNotEquals(b, null);
		Assertions.assertEquals(k,b);
		Assertions.assertEquals(branchName,b.getBranch());
		Assertions.assertEquals(bookName,b.getBname());
		Assertions.assertNotEquals(b.getBid(), null);
		
		
	}
	
	private static Stream<Arguments> provideBooksAndExpectedResults() {
	        return Stream.of(
	            Arguments.of(new Book(), "Embedded Systems", "Engineering"),
	            Arguments.of(new Book(), "Advanced Programming", "Tech"),
	            Arguments.of(new Book(), "Science Fiction", "Literature")
	        );
	    }

}
