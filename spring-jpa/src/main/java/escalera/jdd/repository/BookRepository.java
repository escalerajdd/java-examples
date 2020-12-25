package escalera.jdd.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import escalera.jdd.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitle(String title);

}
