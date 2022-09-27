CREATE TABLE category (
  id long primary key AUTO_INCREMENT,
  name varchar(50)  NOT NULL,
  description varchar(100)
);

insert into category(name,description)
values('Candies','imported');

insert into category(name,description)
values('Vegetables','organic vegetables');

insert into category(name,description)
values('Meal','with sugar');

insert into category(name,description)
values('Dairy','milk products');

CREATE TABLE product (
    id long primary key AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    description varchar(100),
    category_id long NOT NULL,
    price double,
    CONSTRAINT fk_category_product_id
    FOREIGN KEY(category_id)
    REFERENCES Category(id)
);
insert into product(name,description, category_id, price)
values('Strawberry popsicle','with sugar', 1, 10);

insert into product(name,description, category_id, price)
values('Milk','lactose-free', 4, 30);

insert into product(name,description, category_id, price)
values('Chess','oaxaca', 4, 50);

insert into product(name,description, category_id, price)
values('steak','lactose-free', 3, 100);

insert into product(name,description, category_id, price)
values('carrots','organic', 2, 1);

CREATE TABLE "order_tbl" (
    id long primary key AUTO_INCREMENT,
    order_date date NOT NULL,
    total_amount double

);

insert into "order_tbl" (order_date,total_amount)
values('2022-09-22', 40);

insert into "order_tbl" (order_date,total_amount)
values('2022-09-26', 151);

CREATE TABLE "order_product" (
  product_id long NOT NULL,
  order_id long NOT NULL,
  CONSTRAINT fk_product_id
      FOREIGN KEY(product_id)
      REFERENCES Product(id),
   CONSTRAINT fk_order_id
       FOREIGN KEY(order_id)
       REFERENCES "order_tbl"(id)
);

insert into "order_product" (product_id, order_id)
values(1, 1);

insert into "order_product" (product_id, order_id)
values(2, 1);

insert into "order_product" (product_id, order_id)
values(3, 2);

insert into "order_product" (product_id, order_id)
values(4, 2);

insert into "order_product" (product_id, order_id)
values(5, 2);