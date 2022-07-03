package com.team2.sbucks.김희철.dao;

public class ProductSQL {
	public static final String PRODUCT_INSERT
	="insert into product values (?,?,?,?,?,?,?,?,?)";
	public static final String PRODUCT_UPDATE
	="update product set product_name=?,product_price=?,product_allergy=?,product_content=?,product_espresso,product_syrup,product_syrupPrice,product_espressoPrice  where product_no=?";
	public static final String PRODUCT_DELETE
	="delete from product where product_no=?";
	public static final String PRODUCT_SELECT_BY_NO
	="select* from product where product_no=?";
	public static final String PRODUCT_SELECT_ALL
	="select * from product";
}
