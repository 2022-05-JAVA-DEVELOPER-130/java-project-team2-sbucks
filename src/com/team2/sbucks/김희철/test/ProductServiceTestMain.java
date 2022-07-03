package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.service.ProductService;

public class ProductServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductService();
		
		System.out.println(productService.selectByNo(2));
		
		System.out.println(productService.selectAll());
		
	}

}
