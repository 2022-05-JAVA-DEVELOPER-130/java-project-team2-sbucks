insert into product values(1, '아이스 아메리카노', 4500, '고카페인함유','진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피',0, 0, 0, 0);
insert into product values(2, '아메리카노', 4500, '고카페인함유','진한 에스프레소와 뜨거운 물을 섞어 스타벅스의 깔끔하고 강렬한 에스프레소를 가장 부드럽게 잘 느낄 수 있는 커피',0, 0, 0, 0);
insert into product values(3, '아이스 카페라떼', 5000, '우유','풍부하고 진한 농도의 에스프레소가 시원한 우유와 얼음을 만나 고소함과 시원함을 즐길 수 있는 대표적인 커피 라떼',0, 0, 0, 0);
insert into product values(4, '카페라떼', 4500, '우유','풍부하고 진한 에스프레소가 신선한 스팀 밀크를 만나 부드러워진 커피 위에 우유 거품을 살짝 얹은 대표적인 커피 라떼',0, 0, 0, 0);
insert into product values(5, '아이스 카페모카', 5500, '우유','진한 초콜릿 모카 시럽과 풍부한 에스프레소를 신선한 우유 그리고 얼음과 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피',0, 0, 0, 0);
insert into product values(6, '카페모카', 5500, '우유','진한 초콜릿 모카 시럽과 풍부한 에스프레소를 스팀 밀크와 섞어 휘핑크림으로 마무리한 음료로 진한 에스프레소와 초콜릿 맛이 어우러진 커피',0, 0, 0, 0);
insert into product values(7, '아이스 카라멜마끼야또', 5900, '대두 / 우유','향긋한 바닐라 시럽과 시원한 우유와 얼음을 넣고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료',0, 0, 0, 0);
insert into product values(8, '카라멜마끼야또', 5900, '대두 / 우유','향긋한 바닐라 시럽과 따뜻한 스팀 밀크 위에 풍성한 우유 거품을 얹고 점을 찍듯이 에스프레소를 부은 후 벌집 모양으로 카라멜 드리즐을 올린 달콤한 커피 음료',0, 0, 0, 0);
insert into product values(9, '아이스 카푸치노', 5000, '우유','풍부하고 진한 에스프레소에 신선한 우유와 우유 거품이 얼음과 함께 들어간 시원하고 부드러운 커피 음료',0, 0, 0, 0);
insert into product values(10, '카푸치노', 5000, '우유','풍부하고 진한 에스프레소에 따뜻한 우유와 벨벳 같은 우유 거품이 1:1 비율로 어우러져 마무리된 커피 음료',0, 0, 0, 0);

insert into productdetail values(1, 10, 150, 5);
insert into productdetail values(2, 5, 75, 0);
insert into productdetail values(3, 110, 75, 75);
insert into productdetail values(4, 110, 75, 70);
insert into productdetail values(5, 250, 95, 70);
insert into productdetail values(6, 200, 90, 65);
insert into productdetail values(7, 190, 75, 110);
insert into productdetail values(8, 140, 75, 70);
insert into productdetail values(9, 115, 75, 90);
insert into productdetail values(10, 90, 75, 60);

update product 
set product_no = 11
where product_no = 1;

delete from product
where product_no=3;

--제품 전체 리스트보기
select *
from product;

--제품 전체 영양보기
select *
from productDetail;

--상품리스트와 영양정보
select p.product_no 상품번호, p.product_name 상품이름, p.product_price 상품가격,
       p.product_allergy "알레르기 유발요인", p.product_content 상품설명, d.kal 칼로리, d.caffeine 카페인, d.na 나트륨
from product p
join productDetail d
on d.product_no=p.product_no
;



