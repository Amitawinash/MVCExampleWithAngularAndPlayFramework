/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.Map;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

import models.BookInformation;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author amit
 *
 */
public class BookController extends Application {

	public static void addBook() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("book-db");
		MongoCollection<Document> collection = database
				.getCollection("BookInfo");
		// BookInformation bookInformation = prepareBookModel();
		Document document = new Document();
		Map<String, String> allSimple = params.allSimple();
		for (String key : allSimple.keySet()) {
			document.append(key, params.get(key));
		}
		collection.insertOne(document);
		client.close();
		BookController.index();
	}

	private static BookInformation prepareBookModel() {
		BookInformation bookInformation = new BookInformation();
		bookInformation.setBookName(params.get("bookName"));
		bookInformation.setAuthorName(params.get("authorName"));
		bookInformation.setIsbn(params.get("isbn"));
		bookInformation.setPrice(Double.parseDouble(params.get("price")));
		bookInformation.setPublicationYear(params.get("publicationYear"));
		return bookInformation;
	}

	public static void index() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("book-db");
		MongoCollection<Document> collection = database
				.getCollection("BookInfo");
		FindIterable<Document> findIterable = collection.find();
		client.close();
		renderArgs.put("items", findIterable);
		render();
	}

	public static void getBooks() {

	}

	public static void updateBook(BookInformation bookInformation) {

	}
}