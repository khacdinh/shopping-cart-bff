drop table if exists customer CASCADE;
drop table if exists order_detail CASCADE;
drop table if exists product CASCADE;
drop table if exists product_order CASCADE;

create table customer (
                          id bigint generated by default as identity,
                          address varchar(100),
                          city varchar(50),
                          country varchar(50),
                          deleted boolean not null,
                          email varchar(100) not null,
                          full_name varchar(100),
                          password varchar(225) not null,
                          phone varchar(50),
                          primary key (id)
);

create table order_detail (
                              order_id bigint not null,
                              product_id bigint not null,
                              subtotal float not null,
                              total integer not null,
                              primary key (order_id, product_id)
);
create table product (
                         id bigint generated by default as identity,
                         author varchar(50) not null,
                         deleted boolean not null,
                         description varchar(200) not null,
                         image varchar(255),
                         price float not null,
                         quantity integer not null,
                         title varchar(200) not null,
                         primary key (id)
);

create table product_order (
                               order_id bigint generated by default as identity,
                               deleted boolean not null,
                               order_date timestamp not null,
                               recipient_name varchar(100) not null,
                               recipient_phone varchar(20) not null,
                               shipping_address varchar(100) not null,
                               total float not null,
                               customer_id bigint not null,
                               primary key (order_id)
);