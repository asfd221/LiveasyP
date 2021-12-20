package com.noob.liveasy.model;

import javax.persistence.*;

@Entity
@Table(name = "loads")
public class Load {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loadId;

	@Column(name = "loadingPoint")
	private String loadingPoint;

	@Column(name = "unloadingPoint")
	private String unloadingPoint;

	@Column(name = "productType")
	private String productType;

	@Column(name = "truckType")
	private String truckType;

	@Column(name = "noOfTrucks")
	private long noOfTrucks;

	@Column(name = "weight")
	private long weight;

	@Column(name = "comment")
	private String comment;

	@Column(name = "shipperId")
	private String shipperId;

	//@JsonFormat (pattern = "dd-MM-yyyy", shape = Shape.STRING)
	@Column(name = "Date")
	private String Date;

	public Load() {

	}
	public Load(String loadingPoint, String unloadingPoint, String productType, String truckType, long noOfTrucks, long weight, String comment, String shipperId, String Date) {
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.shipperId = shipperId;
		this.Date = Date;
	}

	public long getloadId () {
		return loadId;
	}

	public String getloadingPoint () {
		return loadingPoint;
	}
	public void setloadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}
	public String getunloadingPoint () {
		return unloadingPoint;
	}
	public void setunloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}
	public String getproductType () {
		return productType;
	}
	public void setproductType(String productType) {
		this.productType = productType;
	}
	public String gettruckType () {
		return truckType;
	}
	public void settruckType(String truckType) {
		this.truckType = truckType;
	}
	public long getnoOfTrucks () {
		return noOfTrucks;
	}
	public void setnoOfTrucks(long x) {
		this.noOfTrucks = x;
	}
	public long getweight () {
		return weight;
	}
	public long setweight(long weight) {
		return this.weight = weight;
	}
	public String getcomment () {
		return comment;
	}
	public void setcomment(String comment) {
		this.comment = comment;
	}
	public String getshipperId () {
		return shipperId;
	}
	public void setshipperId(String shipperId) {
		this.shipperId = shipperId;
	}
	public String getDate () {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date;
	}
	@Override
	public String toString() {
		return "payload : {loadingPoint : " + loadingPoint + ", unloadingPoint : " + unloadingPoint + ", productType : " + productType + ", truckType : " + truckType + ", noOfTrucks : " + String.valueOf (noOfTrucks) + ", weight : " + String.valueOf (weight) + ", comment : " + comment + ", shipperId : " + shipperId + ", Date : " + Date + "}";
	}
}

