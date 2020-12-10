create table BOOK(
 id long auto_increment primary key,
 title varchar(200) not null,
 isbn int not null,
 author varchar(200) not null
);

create table Publisher(
    id long auto_increment primary key,
    aname varchar(200) not null,
    age long not null,
    books int not null
);

