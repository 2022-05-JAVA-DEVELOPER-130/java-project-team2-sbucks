package com.team2.sbucks.김희철.service;

import java.util.List;

import com.team2.sbucks.김희철.dao.ProductDao;
import com.team2.sbucks.김희철.dao.ProductDetailDao;
import com.team2.sbucks.김희철.dto.Product;

public class ProductService {
	private ProductDao productDao;

	public ProductService() {
		productDao = new ProductDao();
	}

	public Product selectByNo(int no) throws Exception {
		return productDao.selectByNo(no);
	}

	public List<Product> selectAll() throws Exception {
		return productDao.selectAll();
	}
}
