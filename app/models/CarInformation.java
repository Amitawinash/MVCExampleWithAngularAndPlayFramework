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
public class CarInformation extends Document {

	private String id;
	private String manufacturerName;
	private String model;
	private String colour;
	private double price;
	private String gear;
	private String seat;

	
	public void setPrice(double price) {
		this.price = price;
	}

	
	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getGear() {
		return gear;
	}

	public void setGear(String gear) {
		this.gear = gear;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
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