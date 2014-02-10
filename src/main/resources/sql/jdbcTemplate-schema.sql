use spring_example;
drop table if exists contact;
create table contact (
    id bigint unsigned not null auto_increment primary key,
    first_name varchar(40) not null,
    last_name varchar(40) not null,
    email varchar(80),
    unique index contact_idx1 (last_name, first_name)
) engine = InnoDB;