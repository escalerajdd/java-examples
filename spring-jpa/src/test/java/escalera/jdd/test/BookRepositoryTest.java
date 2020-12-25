package escalera.jdd.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import escalera.jdd.entity.Book;
import escalera.jdd.repository.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private BookRepository bookRepository;

	@Test
	public void insertBookTest() {
		// Given
		Book book = new Book("Testing Spring JPA");

		// When
		entityManager.persist(book);

		// Then
		List<Book> books = bookRepository.findByTitle("Testing Spring JPA");
		assertEquals(1, books.size());
		assertThat(books).extracting(Book::getTitle).containsOnly("Testing Spring JPA");
	}

}
