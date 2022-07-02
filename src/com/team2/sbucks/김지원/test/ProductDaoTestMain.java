package com.team2.sbucks.김지원.test;

import java.util.List;

import com.itwill.product.Product;
import com.itwill.product.ProductDao;

public class ProductDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDao productDao= new ProductDao();
		
		/*
		 * 상품상세리스트 보기
		 */
		System.out.println(productDao.selectByNo(1));
		System.out.println();
		/*
		 * 상품전체 리스트보기
		 */
		List<Product> productList = productDao.selectAll();
		System.out.println(productList);
		
		/*
		 * 상품추가
		 */
		Product insertProduct = new Product(11, null, 0, null, null, 0, 0, 0, 0);
		productDao.insertProduct(insertProduct);
		
		
		/*
		 * 상품정보 업데이트
		 */
		Product updateProduct = new Product(11, "(ICE)자몽허니블랙티", 0, null, null, 0, 0, 0, 0);
		productDao.updateProduct(updateProduct);
		/*
		 * 상품한개삭제
		 */
		productDao.deleteProduct(11);
	}

}
