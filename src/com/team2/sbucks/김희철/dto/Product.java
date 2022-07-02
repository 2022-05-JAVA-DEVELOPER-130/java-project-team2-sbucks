package com.team2.sbucks.김희철.dto;

public class Product {
	private int product_no;
	private String product_name;
	private int product_price;
	private String product_allergy;
	private String product_content;
	private int product_espresso;
	private int product_syrup;
	private int product_syrupPrice;
	private int product_espressoPrice;

	public Product(int product_no, String product_name, int product_price, String product_allergy,
			String product_content, int product_espresso, int product_syrup, int product_syrupPrice,
			int product_espressoPrice) {
		this.product_no = product_no;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_allergy = product_allergy;
		this.product_content = product_content;
		this.product_espresso = product_espresso;
		this.product_syrup = product_syrup;
		this.product_syrupPrice = product_syrupPrice;
		this.product_espressoPrice = product_espressoPrice;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getProduct_allergy() {
		return product_allergy;
	}

	public void setProduct_allergy(String product_allergy) {
		this.product_allergy = product_allergy;
	}

	public String getProduct_content() {
		return product_content;
	}

	public void setProduct_content(String product_content) {
		this.product_content = product_content;
	}

	public int getProduct_espresso() {
		return product_espresso;
	}

	public void setProduct_espresso(int product_espresso) {
		this.product_espresso = product_espresso;
	}

	public int getProduct_syrup() {
		return product_syrup;
	}

	public void setProduct_syrup(int product_syrup) {
		this.product_syrup = product_syrup;
	}

	public int getProduct_syrupPrice() {
		return product_syrupPrice;
	}

	public void setProduct_syrupPrice(int product_syrupPrice) {
		this.product_syrupPrice = product_syrupPrice;
	}

	public int getProduct_espressoPrice() {
		return product_espressoPrice;
	}

	public void setProduct_espressoPrice(int product_espressoPrice) {
		this.product_espressoPrice = product_espressoPrice;
	}

	@Override
	public String toString() {
		return "Product [product_no=" + product_no + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_allergy=" + product_allergy + ", product_content=" + product_content
				+ ", product_espresso=" + product_espresso + ", product_syrup=" + product_syrup
				+ ", product_syrupPrice=" + product_syrupPrice + ", product_espressoPrice=" + product_espressoPrice
				+ "]";
	}

}
