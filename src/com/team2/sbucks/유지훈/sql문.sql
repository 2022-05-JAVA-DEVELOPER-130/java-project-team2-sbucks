--회원
/*
insert into membership values(1,'유지훈','010-2488-8655','1996/01/16','dnjsxn01@naver.com','지훈백작','포도좋아함',1,1);
insert into membership values(2,'박부장','010-5745-5675','1966/03/11','dog@google.com','박용사','당충전',2,2);
insert into membership values(3,'삼삼삼','010-3333-3333','1933/03/23','three3@naver.com','3샷3','초콜릿3개',1,2);
*/
--상품
/*
insert into product values(1,'아메리카노',5000,'카페인','잠이안와요',1,1,700,500);
insert into product values(2,'카라멜 마끼야또',6000,'달콤해','너무달아요',1,2,700,500);
insert into product values(3,'자바 프라푸치노',7500,'짱맛있어요','너무비쌈',3,1,700,500);
insert into product values(4,'초콜릿 라떼',5500,'초콜릿','가나초콜릿',0,0,700,500);
insert into product values(5,'달고나 라떼',6500,'달달고나','달달해욧',1,0,700,500);
*/

------------------------장바구니--------------------------
-- 장바구니에 상품을 추가한다. ##추가 = insert, update ##
-- 1번 회원이 1번 상품을 장바구니에 추가함 총 개수는 1개
insert into cart(cart_no,product_no,member_no,cart_qty) 
values(cart_cart_no_seq.nextval,1,1,1);
-- 1번 회원이 2번 상품을 장바구니에 추가함
insert into cart(cart_no,product_no,member_no,cart_qty)
values(cart_cart_no_seq.nextval,2,1,1);
-- 1번 상품이 1개 이상일때는 update
update cart set cart_qty = cart_qty+1 where member_no = 1 and cart_qty >= 1;

-- 장바구니에 상품을 삭제한다. ## 삭제 = delete, update ##
-- 1번회원이 장바구니에서 상품을 삭제함.
-- 상품이 1개일 경우는 delete
delete from cart where member_no = 1 and cart_qty = 1;
-- 상품이 2개 이상일 경우에는 update
update cart set cart_qty = cart_qty-1 where member_no = 1 and cart_qty >= 2;
-- 1번 회원의 상품 전체삭제
delete from cart where member_no = 1;

-- 1번 회원이 고른 상품 ## DB에서 해당 데이터 검색 = select ##
select p.product_name "상품이름", p.product_price+
                                (p.product_espresso*p.product_espressoprice)+
                                (p.product_syrup*p.product_syrupprice) "상품가격",
       cart_qty
from cart c
join product p
on c.product_no = p.product_no
where member_no = 1;

---------------------주문------------------------
--1번회원이 상품을 주문한다
insert into orderlist(order_no, order_date, member_no, order_price)
values(orderlist_order_no_seq.nextval, sysdate, 1, 7000);
--1번 회원이 주문을 취소한다.  
delete from orderlist where member_no = 1;  


--------------------주문상세----------------------
--