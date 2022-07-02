package com.team2.sbucks.김지원.service;

import java.util.List;



public class ProductService {
	private ProductDao productDao;
	public ProductService() {
		productDao=new ProductDao();
	}
	
	/*
	 * 상품검색(한개)
	 * 
	 */
	public Product selectByNo(int no) throws Exception{
		return productDao.selectByNo(no);
		
	}
	/*
	 * 상품 여러개 검색
	 */
	public List<Product> selectAll() throws Exception{
		return productDao.selectAll();
	}
}
