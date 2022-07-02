package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.dao.ProductDetailDao;
import com.team2.sbucks.김희철.dto.ProductDetail;

public class ProductDetailDaoTestMain {

	public static void main(String[] args) throws Exception {
		ProductDetailDao productDetailDao = new ProductDetailDao();

		ProductDetail newProductDetail = new ProductDetail(1, 10, 150, 5);
		newProductDetail = new ProductDetail(2, 5, 75, 0);
		newProductDetail = new ProductDetail(3, 110, 75, 75);
		newProductDetail = new ProductDetail(4, 110, 75, 70);
		newProductDetail = new ProductDetail(5, 250, 95, 70);
		newProductDetail = new ProductDetail(6, 200, 90, 65);
		newProductDetail = new ProductDetail(7, 190, 75, 110);
		newProductDetail = new ProductDetail(8, 140, 75, 70);
		newProductDetail = new ProductDetail(9, 115, 75, 90);
		newProductDetail = new ProductDetail(10, 90, 75, 60);
		
		System.out.println("영양정보 : " + productDetailDao.insertProductDetail(newProductDetail));

		System.out.println("영양정보삭제 : " + productDetailDao.deleteProductDetail(2));

		ProductDetail updateProductDetail = new ProductDetail(11, 99, 999, 9);
		System.out.println("영양정보수정 : " + productDetailDao.updateProductDetail(updateProductDetail));

		System.out.println(productDetailDao.selectByNo(5));

		System.out.println(productDetailDao.selectAll());

	}
}
