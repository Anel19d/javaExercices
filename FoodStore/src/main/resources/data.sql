CREATE TABLE category (
  id long primary key AUTO_INCREMENT,
  name varchar(50)  NOT NULL,
  description varchar(100)
);

insert into category(name,description)
values('candies','with sugar');

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

CREATE TABLE "order" (
    id long primary key AUTO_INCREMENT,
    order_date date NOT NULL,
    total_amount double
);

insert into "order" (order_date,totalAmount)
values('2022-09-22', 10);

CREATE TABLE "order_product" (
  product_id long NOT NULL,
  order_id long NOT NULL,
  CONSTRAINT fk_product_id
      FOREIGN KEY(product_id)
      REFERENCES Product(id),
   CONSTRAINT fk_order_id
       FOREIGN KEY(order_id)
       REFERENCES "order"(id)
);

insert into "order_product" (product_id, order_id)
values(1, 1);