package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Author author1 = new Author("John", "Wick");
		Book book1 = new Book("Test Driven Development", "123123");
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);

		authorRepository.save(author1);
		bookRepository.save(book1);

		Author author2 = new Author("John", "Malone");
		Book book2 = new Book("Design of networks", "777555");
		author2.getBooks().add(book2);
		book2.getAuthors().add(author2);

		authorRepository.save(author2);
		bookRepository.save(book2);

		System.out.println("Started in bootstrap");
		System.out.println("Number of books" + bookRepository.count());
		System.out.println("Number of authors" + authorRepository.count());
	}

}
