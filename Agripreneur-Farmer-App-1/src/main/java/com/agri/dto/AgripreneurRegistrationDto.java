package com.agri.dto;

import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class AgripreneurRegistrationDto {

    @NotNull(message = "Category ID must not be null")
    private Long categoryId;

    @NotNull(message = "State ID must not be null")
    private Long stateId;

    @NotNull(message = "District ID must not be null")
    private Long districtId;

    @NotNull(message = "Taluka ID must not be null")
    private Long talukaId;

    @NotNull(message = "Village ID must not be null")
    private Long villageId;

    private String name;
    private String idNo;
    private String ventureName;
    private Double serviceCost;
    private String pincode;
    private String mobileNumber;
    private String landlineNumber;
    private String email;
    private String ntiName;
    private Double latitude;
    private Double longitude;
    private String restrictedInfo;
    private Double annualTurnover;
    private Double annualIncome;
    private Integer personsEmployed;
    private Integer farmersCovered;
    private Integer villagesCovered;
    private Boolean bankLoan;
    private Boolean subsidy;
    private String keywords;
    
    private MultipartFile[] images; // Image data

    // Getters and Setters

    public MultipartFile[] getImages() {
        return images;
    }

    public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getTalukaId() {
		return talukaId;
	}

	public void setTalukaId(Long talukaId) {
		this.talukaId = talukaId;
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
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

	public Double getServiceCost() {
		return serviceCost;
	}

	public void setServiceCost(Double serviceCost) {
		this.serviceCost = serviceCost;
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

	public String getRestrictedInfo() {
		return restrictedInfo;
	}

	public void setRestrictedInfo(String restrictedInfo) {
		this.restrictedInfo = restrictedInfo;
	}

	public Double getAnnualTurnover() {
		return annualTurnover;
	}

	public void setAnnualTurnover(Double annualTurnover) {
		this.annualTurnover = annualTurnover;
	}

	public Double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public Integer getPersonsEmployed() {
		return personsEmployed;
	}

	public void setPersonsEmployed(Integer personsEmployed) {
		this.personsEmployed = personsEmployed;
	}

	public Integer getFarmersCovered() {
		return farmersCovered;
	}

	public void setFarmersCovered(Integer farmersCovered) {
		this.farmersCovered = farmersCovered;
	}

	public Integer getVillagesCovered() {
		return villagesCovered;
	}

	public void setVillagesCovered(Integer villagesCovered) {
		this.villagesCovered = villagesCovered;
	}

	public Boolean getBankLoan() {
		return bankLoan;
	}

	public void setBankLoan(Boolean bankLoan) {
		this.bankLoan = bankLoan;
	}

	public Boolean getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(Boolean subsidy) {
		this.subsidy = subsidy;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public void setImages(MultipartFile[] images) {
        this.images = images;
    }

    // Other getters and setters
}
