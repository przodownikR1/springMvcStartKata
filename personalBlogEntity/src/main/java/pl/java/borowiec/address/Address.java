package pl.java.borowiec.address;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import pl.java.borowiec.def.RegExp;

/**
 * @author Sławomir Borowiec
 *         Module name : personalBlogEntity
 *         Creating time : 10-03-2013 23:23:44
 */
@Embeddable
@XmlRootElement(name = "address")
public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5271571702826932282L;
	@NotNull
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
	private String country;
	
	@NotNull
	@Size(min = 2, max = 50)
	@Column(nullable = false, length = 50)
	private String town;
	
	@Size(min = 2, max = 50)
	@Pattern(regexp = ".+")
	private String street;

	
	private String streetNumber;

	private String homeNumber;

	@Column(nullable = false, length = 6)
	@Pattern(regexp = RegExp.POSTAL_CODE_REGEX)
	private String zipcode;

	@Column(name = "latitude", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private Double latitude;

	@Column(name = "longitude", nullable = true)
	@Basic(fetch = FetchType.LAZY)
	private Double longitude;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
