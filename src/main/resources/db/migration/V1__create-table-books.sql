create table books (
                         id bigint not null auto_increment,
                         name varchar(100) not null,
                         isbn varchar(100) not null,
                         genre varchar(100) not null unique,
                         author varchar(100) not null,

                         primary key(id)
);