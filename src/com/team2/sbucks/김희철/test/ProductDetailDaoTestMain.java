package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.dao.ProductDetailDao;
import com.team2.sbucks.김희철.dto.ProductDetail;

public class ProductDetailDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDetailDao productDetailDao = new ProductDetailDao();
		
		ProductDetail insertProductDetail1 = new ProductDetail(1, 10, 150, 5);
		ProductDetail insertProductDetail2 = new ProductDetail(2, 5, 75, 0);
		ProductDetail insertProductDetail3 = new ProductDetail(3, 110, 75, 75);
		ProductDetail insertProductDetail4 = new ProductDetail(4, 110, 75, 70);
		ProductDetail insertProductDetail5 = new ProductDetail(5, 250, 95, 70);
		ProductDetail insertProductDetail6 = new ProductDetail(6, 200, 90, 65);
		ProductDetail insertProductDetail7 = new ProductDetail(7, 190, 75, 110);
		ProductDetail insertProductDetail8 = new ProductDetail(8, 140, 75, 70);
		ProductDetail insertProductDetail9 = new ProductDetail(9, 115, 75, 90);
		ProductDetail insertProductDetail10 = new ProductDetail(10, 90, 75, 60);
		
		productDetailDao.insertProductDetail(insertProductDetail1);
		productDetailDao.insertProductDetail(insertProductDetail2);
		productDetailDao.insertProductDetail(insertProductDetail3);
		productDetailDao.insertProductDetail(insertProductDetail4);
		productDetailDao.insertProductDetail(insertProductDetail5);
		productDetailDao.insertProductDetail(insertProductDetail6);
		productDetailDao.insertProductDetail(insertProductDetail7);
		productDetailDao.insertProductDetail(insertProductDetail8);
		productDetailDao.insertProductDetail(insertProductDetail9);
		productDetailDao.insertProductDetail(insertProductDetail10);

		System.out.println("영양정보삭제 : " + productDetailDao.deleteProductDetail(2));

		ProductDetail updateProductDetail = new ProductDetail(1, 99, 999, 9);
		System.out.println("영양정보수정 : " + productDetailDao.updateProductDetail(updateProductDetail));

		System.out.println(productDetailDao.selectByNo(5));

		System.out.println(productDetailDao.selectAll());

	}
}
