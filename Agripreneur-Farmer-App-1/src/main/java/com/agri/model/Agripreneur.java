package com.agri.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Agripreneur")
public class Agripreneur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agripreneur_id")
    private Long agripreneurId;

    private String name;
    private String idNo;
    private String ventureName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category serviceCategory;

    private double serviceCost;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private State state;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne
    @JoinColumn(name = "taluka_id")
    private Taluka taluka;

    @ManyToOne
    @JoinColumn(name = "village_id")
    private Village village;

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

    @OneToMany(mappedBy = "agripreneur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AgripreneurImage> images;

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

	public Category getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(Category serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(double serviceCost) {
		this.serviceCost = serviceCost;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Taluka getTaluka() {
		return taluka;
	}

	public void setTaluka(Taluka taluka) {
		this.taluka = taluka;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
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

	public List<AgripreneurImage> getImages() {
		return images;
	}

	public void setImages(List<AgripreneurImage> images) {
		this.images = images;
	}
    
}
