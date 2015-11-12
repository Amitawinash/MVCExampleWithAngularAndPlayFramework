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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author Amit
 *
 */
public class CarController extends Application {

	public static void addCar() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("car-db");
		MongoCollection<Document> collection = database
				.getCollection("CarInfo");
		// BookInformation bookInformation = prepareBookModel();
		Document document = new Document();
		Map<String, String> allSimple = params.allSimple();
		for (String key : allSimple.keySet()) {
			document.append(key, params.get(key));
		}
		collection.insertOne(document);
		client.close();
		index();
	}

	private static CarInformation prepareCarModel() {
		// BookInformation bookInformation = new BookInformation();
		CarInformation carIncormation = new CarInformation();

		carIncormation.setManufacturerName(params.get("ManufacturerName"));
		carIncormation.setPrice(Double.parseDouble(params.get("price")));
		carIncormation.setGear(params.get("gear"));
		carIncormation.setColour(params.get("colour"));
		carIncormation.setModel(params.get("model"));
		carIncormation.setSeat(params.get("seat"));
		return carIncormation;

	}

	public static void index() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("car-db");
		MongoCollection<Document> collection = database
				.getCollection("CarInfo");
		FindIterable<Document> findIterable = collection.find();
		renderArgs.put("items", findIterable);
		render();
		client.close();
	}

	public static void fetchAllCar() {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("transporter-db");
		MongoCollection<Document> collection = database
				.getCollection("TransporterInfo");
		FindIterable<Document> findIterable = collection.find();
		JsonArray jsonArray = new JsonArray();
		for (Document document : findIterable) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("name", document.getString("To"));
			jsonObject.addProperty("employees", document.getString("From"));
			jsonObject.addProperty("headoffice", document.getString("City"));
			jsonArray.add(jsonObject);
		}
		renderJSON(jsonArray);
		client.close();
	}

	public static void fetchAllCar(String origin, String destination) {
		MongoClient client = new MongoClient("localhost");
		MongoDatabase database = client.getDatabase("transporter-db");
		MongoCollection<Document> collection = database
				.getCollection("TransporterInfo");
		BsonDocument queryJson = new BsonDocument();
		queryJson.append("origin", new BsonString(origin));
		queryJson.append("destination", new BsonString(destination));
		FindIterable<Document> findIterable = collection.find(queryJson);
		JsonArray jsonArray = new JsonArray();
		for (Document document : findIterable) {
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("name", document.getString("To"));
			jsonObject.addProperty("employees", document.getString("From"));
			jsonObject.addProperty("headoffice", document.getString("City"));
			jsonArray.add(jsonObject);
		}
		renderJSON(jsonArray);
		client.close();
	}

	public static void getCar() {

	}

	public static void updateCar(CarInformation carInformation) {

	}
}