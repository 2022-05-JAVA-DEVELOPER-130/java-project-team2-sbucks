package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.service.ProductDetailService;

public class ProductDetailServiceTestMain {

	public static void main(String[] args) throws Exception {
		
		ProductDetailService productDetailService = new ProductDetailService();
		
		System.out.println(productDetailService.selectByNo(7));
		
		System.out.println(productDetailService.selectAll());
		
	}

}
