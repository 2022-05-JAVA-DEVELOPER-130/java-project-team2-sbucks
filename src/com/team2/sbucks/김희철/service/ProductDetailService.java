package com.team2.sbucks.김희철.service;

import java.util.List;

import com.team2.sbucks.김희철.dao.ProductDetailDao;
import com.team2.sbucks.김희철.dto.ProductDetail;

public class ProductDetailService {
	private ProductDetailDao productDetailDao;

	public ProductDetailService() {
		productDetailDao = new ProductDetailDao();
	}

	public ProductDetail selectByNo(int no) throws Exception {
		return productDetailDao.selectByNo(no);
	}

	public List<ProductDetail> selectAll() throws Exception {
		return productDetailDao.selectAll();
	}

}
