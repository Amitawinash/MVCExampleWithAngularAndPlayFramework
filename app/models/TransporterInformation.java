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
public class TransporterInformation extends Document {

	private String transporterName;
	private int originPincode;
	private String originCity;
	private String OriginState;
	private int destinationPinCode;
	private String destinationCity;
	private String destinationState;
	private double maxWeightAllowed;

	public void setMaxWeightAllowed(double maxWeightAllowed) {
		this.maxWeightAllowed = maxWeightAllowed;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public int getOriginPincode() {
		return originPincode;
	}

	public void setOriginPincode(int originPincode) {
		this.originPincode = originPincode;
	}

	public String getOriginCity() {
		return originCity;
	}

	public void setOriginCity(String originCity) {
		this.originCity = originCity;
	}

	public String getOriginState() {
		return OriginState;
	}

	public void setOriginState(String originState) {
		OriginState = originState;
	}

	public int getDestinationPinCode() {
		return destinationPinCode;
	}

	public void setDestinationPinCode(int destinationPinCode) {
		this.destinationPinCode = destinationPinCode;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDestinationState() {
		return destinationState;
	}

	public void setDestinationState(String destinationState) {
		this.destinationState = destinationState;
	}

	public double getMaxWeightAllowed() {
		return maxWeightAllowed;
	}

}