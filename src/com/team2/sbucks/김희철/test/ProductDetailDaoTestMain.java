package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.dao.ProductDetailDao;
import com.team2.sbucks.김희철.dto.ProductDetail;

public class ProductDetailDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDetailDao productDetailDao = new ProductDetailDao();
/*
		ProductDetail insertProductDetail = new ProductDetail(1, 10, 150, 5);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(2, 5, 75, 0);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(3, 110, 75, 75);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(4, 110, 75, 70);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(5, 250, 95, 70);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(6, 200, 90, 65);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
*/
		ProductDetail insertProductDetail = new ProductDetail(7, 190, 75, 110);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(8, 140, 75, 70);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(9, 115, 75, 90);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		insertProductDetail = new ProductDetail(10, 90, 75, 60);
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(insertProductDetail));
		

		System.out.println("영양정보삭제 : " + productDetailDao.deleteProductDetail(2));

		ProductDetail updateProductDetail = new ProductDetail(1, 99, 999, 9);
		System.out.println("영양정보수정 : " + productDetailDao.updateProductDetail(updateProductDetail));

		System.out.println(productDetailDao.selectByNo(5));

		System.out.println(productDetailDao.selectAll());

	}
}
