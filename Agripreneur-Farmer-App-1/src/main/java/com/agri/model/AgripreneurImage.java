package com.agri.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
@Entity
public class AgripreneurImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private byte[]imageData;
	
	@ManyToOne
	private Agripreneur agripreneur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
		public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
		public Agripreneur getAgripreneur() {
		return agripreneur;
	}
	public void setAgripreneur(Agripreneur agripreneur) {
		this.agripreneur = agripreneur;
	}
	

}

