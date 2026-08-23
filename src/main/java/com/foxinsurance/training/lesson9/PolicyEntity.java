package com.foxinsurance.training.lesson9;

import jakarta.persistence.*;

@Entity
@Table(name = "jpa_policies")
public class PolicyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String productType;
	private double premium;
	private String status;

	protected PolicyEntity() {
	}

	public PolicyEntity(String customerName, String productType, double premium, String status) {
		this.customerName = customerName;
		this.productType = productType;
		this.premium = premium;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getProductType() {
		return productType;
	}

	public double getPremium() {
		return premium;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "PolicyEntity{id=" + id + ", customer='" + customerName + "', product='" + productType + "', premium="
				+ premium + ", status='" + status + "'}";
	}
}
