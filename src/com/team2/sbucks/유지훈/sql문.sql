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
update cart set cart_qty = cart_qty+1 where member_no = 1 and product_no = 1;

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
       cart_qty "상품개수",      (p.product_price+
                                (p.product_espresso*p.product_espressoprice)+
                                (p.product_syrup*p.product_syrupprice))*
                                 cart_qty "총 가격"
from cart c
join product p
on c.product_no = p.product_no
where member_no = 1;

-- 1번 회원이 선택한 상품 총 가격
select sum((p.product_price+
         (p.product_espresso*p.product_espressoprice)+
         (p.product_syrup*p.product_syrupprice))*
          cart_qty) "전체 가격"
from cart c
join product p
on c.product_no = p.product_no
group by member_no;

---------------------주문------------------------
-- orderList는 주문번호와 주문시간을 빼기 위한 테이블인듯하다. insert, delete
-- orderList에 price는 아직 쓰임새를 모르겠네요.
--1번회원이 상품을 주문한다
insert into orderlist(order_no, order_date, member_no)
values(orderlist_order_no_seq.nextval, sysdate, 1);
--1번 회원이 주문을 취소한다.
delete from orderlist where order_no = 1;
--1번 회원 주문 내역
select * from orderlist where member_no = 1;
--------------------주문상세----------------------
--orderDetail
--order_stmt 1.주문완료, 2.준비중, 3.준비완료, 4.픽업 완료
--1번 회원이 1번 상품을 1개 주문했다.
insert into orderdetail(orderdetail_no, order_no, order_qty, order_stmt, product_no)
        values(ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,3,1,1,1);

--1번 회원의 주문 상세내역을 본다.
select list.order_no "주문번호",order_date "주문일자", member_no "회원번호",
       product_name "상품이름", product_price "상품가격",
       product_espresso "에스프레소 옵션", product_syrup "샷 옵션"
       
from orderdetail detail
join orderlist list
on detail.order_no = list.order_no
join product p
on detail.product_no = p.product_no;



insert into orderlist(order_no,order_date,member_no) 
values (orderList_order_no_SEQ.nextval,sysdate,1);
insert into orderdetail(orderdetail_no, order_no, order_stmt, product_no,order_qty)
values (ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,orderList_order_no_SEQ.currval,1,1,2);


insert into orderdetail (orderdetail_no, order_no, order_stmt, product_no,order_qty)
select 
ORDERDETAIL_ORDERDETAIL_NO_SEQ.nextval,
orderList_order_no_SEQ.currval,
1,
c.product_no,c.cart_qty
from cart c
where member_no=3;
