/**
 * 
 */
package models;

import org.bson.Document;

import com.google.gson.Gson;

/**
 * @author amit
 *
 */
public class BookInformation extends Document {

	private String id;
	private String bookName;
	private String isbn;
	private String publicationYear;
	private double price;
	private String authorName;

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}