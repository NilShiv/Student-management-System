package com.nil.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	private String area;
	private String state;
	private String district;
	private String pincode;
	private AddressType addressType;
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", area=" + area + ", state=" + state + ", district=" + district + ", pincode="
				+ pincode + ", addressType=" + addressType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(addressType, aid, area, district, pincode, state);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return addressType == other.addressType && aid == other.aid && Objects.equals(area, other.area)
				&& Objects.equals(district, other.district) && Objects.equals(pincode, other.pincode)
				&& Objects.equals(state, other.state);
	}
	
	
	
}
