package com.agri.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Agripreneur")
public class Agripreneur {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "agripreneur_id")
    private Long agripreneurId;
    @Column(name = "name")
    private String name;
    private String idNo;
    private String ventureName;
    private double serviceCost;
    private String state;
    private String district;
    private String taluka;
    private String villege;
    private String pincode;
    private String mobileNumber;
    private String landlineNumber;
    private String email;
    private String ntiName;
    private double latitude;
    private double longitude;
    private String restrictedInfo;
    private double annualTurnover;
    private double annualIncome;
    private int personsEmployed;
    private int farmersCovered;
    private int villagesCovered;
    private boolean bankLoan;
    private boolean subsidy;
    private String keywords;
   
   	public Long getAgripreneurId() {
		return agripreneurId;
	}

	public void setAgripreneurId(Long agripreneurId) {
		this.agripreneurId = agripreneurId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getVentureName() {
		return ventureName;
	}

	public void setVentureName(String ventureName) {
		this.ventureName = ventureName;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
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

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getVillege() {
		return villege;
	}

	public void setVillege(String villege) {
		this.villege = villege;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLandlineNumber() {
		return landlineNumber;
	}

	public void setLandlineNumber(String landlineNumber) {
		this.landlineNumber = landlineNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNtiName() {
		return ntiName;
	}

	public void setNtiName(String ntiName) {
		this.ntiName = ntiName;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getRestrictedInfo() {
		return restrictedInfo;
	}

	public void setRestrictedInfo(String restrictedInfo) {
		this.restrictedInfo = restrictedInfo;
	}

	public double getAnnualTurnover() {
		return annualTurnover;
	}

	public void setAnnualTurnover(double annualTurnover) {
		this.annualTurnover = annualTurnover;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public int getPersonsEmployed() {
		return personsEmployed;
	}

	public void setPersonsEmployed(int personsEmployed) {
		this.personsEmployed = personsEmployed;
	}

	public int getFarmersCovered() {
		return farmersCovered;
	}

	public void setFarmersCovered(int farmersCovered) {
		this.farmersCovered = farmersCovered;
	}

	public int getVillagesCovered() {
		return villagesCovered;
	}

	public void setVillagesCovered(int villagesCovered) {
		this.villagesCovered = villagesCovered;
	}

	public boolean isBankLoan() {
		return bankLoan;
	}

	public void setBankLoan(boolean bankLoan) {
		this.bankLoan = bankLoan;
	}

	public boolean isSubsidy() {
		return subsidy;
	}

	public void setSubsidy(boolean subsidy) {
		this.subsidy = subsidy;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

    }
