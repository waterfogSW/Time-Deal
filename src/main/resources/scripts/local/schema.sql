drop table if exists time_deal.product, time_deal.user;

create table time_deal.product
(
    id             bigint auto_increment
        primary key,
    created_at     datetime(6)  not null,
    updated_at     datetime(6)  not null,
    description    varchar(255) not null,
    image_url      varchar(255) not null,
    name           varchar(255) not null,
    original_price bigint       not null,
    quantity       bigint       not null,
    selling_price  bigint       not null
);

create table time_deal.user
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  not null,
    updated_at datetime(6)  not null,
    password   varchar(255) not null,
    role       varchar(255) not null,
    username   varchar(255) not null,
    constraint UK_sb8bbouer5wak8vyiiy4pf2bx
        unique (username)
);
