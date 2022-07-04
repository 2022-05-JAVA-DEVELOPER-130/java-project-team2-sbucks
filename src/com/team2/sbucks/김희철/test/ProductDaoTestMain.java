package com.team2.sbucks.김희철.test;

import com.team2.sbucks.김희철.dao.ProductDao;
import com.team2.sbucks.김희철.dto.Product;

public class ProductDaoTestMain {
	public static void main(String[] args) throws Exception {
		
	
	ProductDao productDao = new ProductDao();
	
	Product inserProduct = new Product(1, "null", 4500, "null", "null", 0, 0, 0, 0);
	System.out.println("메뉴생성 : "+inserProduct);
	/*
	Product newProduct = 
				new Product(1, "아이스 아메리카노", 4500, "고카페인함유",
			"진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피",
			0, 0, 0, 0);
	
	newProduct = new Product(2, "아메리카노", 4500, "고카페인함유",
			"진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피",
			0, 0, 0, 0);
	newProduct = new Product(3, "아이스 카페라떼", 5000, "우유",
			"풍부하고 진한 농도의 에스프레소가 시원한 우유와 얼음을 만나 고소함과 시원함을 즐길 수 있는 대표적인 커피 라떼",
			0, 0, 0, 0);
	newProduct = new Product(4, "카페라떼", 4500, "우유",
			"풍부하고 진한 에스프레소가 신선한 스팀 밀크를 만나 부드러워진 커피 위에 우유 거품을 살짝 얹은 대표적인 커피 라떼",
			0, 0, 0, 0);
	newProduct = new Product(5, "아이스 카페모카", 5500, "우유",
			"진한 초콜릿 모카 시럽과 풍부한 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피",
			0, 0, 0, 0);
	newProduct = new Product(6, "카페모카", 5500, "우유",
			"진한 초콜릿 모카 시럽과 풍부한 에스프레소를 스팀 밀크와 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피",
			0, 0, 0, 0);
	newProduct = new Product(7, "아이스 카라멜마끼야또", 5900, "대두 / 우유",
			"향긋한 바닐라 시럽과 시원한 우유와 얼음을 넣고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료",
			0, 0, 0, 0);
	newProduct = new Product(8, "카라멜마끼야또", 5900, "대두 / 우유",
			"향긋한 바닐라 시럽과 따뜻한 스팀 밀크 위에 풍성한 우유 거품을 얹고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료",
			0, 0, 0, 0);
	newProduct = new Product(9, "아이스 카푸치노", 5000, "우유",
			"풍부하고 진한 에스프레소에 신선한 우유와 우유 거품이 얼음과 함께 들어간 시원하고 부드러운 커피 음료",
			0, 0, 0, 0);
	newProduct = new Product(10, "카푸치노", 5000, "우유",
			"풍부하고 진한 에스프레소에 따뜻한 우유와 벨벳 같은 우유 거품이 1:1 비율로 어우러져 마무리된 커피 음료",
			0, 0, 0, 0);
		*/
	
	
	System.out.println("메뉴삭제 : "+productDao.deleteProduct(2));
	
	Product updatProduct = new Product(11,"업데이트 테스트", 99999999, "실험1", "실험2", 9999, 999, 99, 9);
	System.out.println("메뉴수정 : "+productDao.updateProduct(updatProduct));
	
	System.out.println(productDao.selectByNo(1));
	
	System.out.println(productDao.selectAll());
	
	
	
	
	}
}
