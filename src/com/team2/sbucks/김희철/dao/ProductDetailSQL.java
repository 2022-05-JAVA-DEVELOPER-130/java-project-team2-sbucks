package com.team2.sbucks.김희철.dao;

public class ProductDetailSQL {
	public static final String PRODUCTDETAIL_INSERT
	="insert into productDetail  values (?,?,?,?)";
	public static final String PRODUCTDETAIL_UPDATE
	="update productDetail set kal=?,caffeine=?,na=? where product_no=?";
	public static final String PRODUCTDETAIL_DELETE
	="delete from productDetail where product_no=?";
	public static final String PRODUCTDETAIL_SELECT_BY_NO
	="select* from productDetail where product_no=?";
	public static final String PRODUCTDETAIL_SELECT_ALL
	="select * from productDetail";
}
