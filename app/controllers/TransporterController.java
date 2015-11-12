/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.Map;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;

import models.BookInformation;
import models.CarInformation;
import models.TransporterInformation;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author Amit
 *
 */
public class TransporterController extends Application {

	public static void addTransporter() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("transporter-db");
		MongoCollection<Document> collection = database
				.getCollection("TransporterInfo");

		Document document = new Document();
		Map<String, String> allSimple = params.allSimple();
		for (String key : allSimple.keySet()) {
			document.append(key, params.get(key));
		}
		collection.insertOne(document);
		client.close();
		index();
	}

	public static void index() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("transporter-db");
		MongoCollection<Document> collection = database
				.getCollection("TransporterInfo");
		FindIterable<Document> findIterable = collection.find();
		System.out.println("inside If");
		play.Logger.info("Inside If", "Log");
		renderArgs.put("items", findIterable);
		render();
		client.close();
	}

	public static void searchTransporter() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("transporter-db");
		MongoCollection<Document> collection = database
				.getCollection("TransporterInfo");

		System.out.println("searchTransporter : " + params.allSimple());
		play.Logger.info("searchTransporter : " + params.allSimple(),
				"Search Params");
		BsonDocument queryJson = new BsonDocument();
		if (params.get("originCity") != null
				&& params.get("destinationCity") != null) {
			queryJson.append("originCity",
					new BsonString(params.get("originCity")));

			queryJson.append("destinationCity",
					new BsonString(params.get("destinationCity")));
		}

		FindIterable<Document> findIterable = collection.find(queryJson);
		play.Logger.info("Inside searchTransporter", "Log");
		renderArgs.put("items", findIterable);
		render();
		client.close();
	}

	public static void getTransporter() {

	}

	public static void updateTransporter(
			TransporterInformation transporterInformation) {

	}
}