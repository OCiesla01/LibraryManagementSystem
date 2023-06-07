package com.oc01.springbootlibrarymanagementsystem;

import com.oc01.springbootlibrarymanagementsystem.entity.Author;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes=SpringBootLibraryManagementSystemApplicationTests.class)
class AuthorTest {

	Author author = new Author(
			"Hilary", "Smith", "USA", null, null, 12, false);

	@Test
	public void testEmptyConstructor_ReturnsTrue() {
		Author author = new Author();
		assertEquals(0, author.getId());
	}

	@Test
	public void testConstructor_ReturnsTrue() {
		assertEquals("Hilary", author.getFirstName());
	}

	@Test
	public void testToString_ReturnsTrue() {
		assertEquals("Author{" +
				"id=" + author.getId() +
				", firstName='" + author.getFirstName() + '\'' +
				", lastName='" + author.getLastName() + '\'' +
				", origin='" + author.getOrigin() + '\'' +
				", dateOfBirth=" + author.getDateOfBirth() +
				", dateOfDeath=" + author.getDateOfDeath() +
				", awardsAndRecognitions=" + author.getAwardsAndRecognitions() +
				", totalBooks=" + author.getTotalBooks() +
				", books=" + author.getBooks() +
				", isDeleted=" + author.isDeleted() +
				'}', author.toString());
	}

//	More Tests with an in-memory database will be added later on

}
