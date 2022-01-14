use quan_ly_ban_hang;

INSERT INTO customer(customer_name, customer_age) VALUES 
('Minh Quan', 10), ('Ngoc Oanh', 20), ('Hong Ha', 50);

INSERT INTO `order`(customer_id, order_date, order_tatal_price) VALUES 
(1, '2006/03/21', NULL), (2, '2006/03/31', NULL), (1, '2006/03/16', NULL);

INSERT INTO product(product_name, product_price) VALUES
('May Giat', 3), ('Tu Lanh', 5), ('Dieu Hoa', 7), ('Quat', 1), ('Bep Dien', 2);

INSERT INTO order_detail(order_qty, order_id, product_id) VALUES
(3,1,1),
(7,1,3), 
(2,1,4), 
(1,2,1), 
(8,3,1), 
(4,2,5), 
(3,2,3);

SELECT order_id, order_date, order_tatal_price FROM `order`;

select customer.customer_name, product.product_name 
from customer inner join `order` on customer.customer_id = `order`.customer_id
inner join order_detail on `order`.order_id = order_detail.order_id
inner join product on order_detail.product_id = product.product_id;

select customer.customer_name, product.product_name, `order`.order_id,
order_detail.order_qty from customer join `order` on customer.customer_id = `order`.customer_id join order_detail on `order`.order_id = order_detail.order_id 
join product on order_detail.product_id = product.product_id
where order_detail.order_qty is null;


select `order`.order_id, `order`.order_date, sum(order_detail.order_qty * product.product_price) as 'tong_tien' 
from customer join `order` on customer.customer_id = `order`.customer_id
join order_detail on `order`.order_id = order_detail.order_id 
join product on order_detail.product_id = product.product_id
group by order_detail.order_id;
 
