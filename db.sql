create table cars.brands (
                             id int not null generated always as identity (start with 1, increment by 1),
                             brandname varchar(255) not null,
                             country varchar(255) not null,
                             logo varchar(999) not null,
                             primary key(id)
);

create table cars.models (
                             id int not null generated always as identity (start with 1, increment by 1),
                             modelname varchar(255) not null,
                             brand varchar(255) not null,
                             photo varchar(999),
                             price decimal not null,
                             cc decimal not null,
                             seats int not null,
                             primary key(id)
);

create table cars.sellers (
                              id int not null generated always as identity (start with 1, increment by 1),
                              username varchar(255) not null,
                              password varchar(255) not null,
                              email varchar(999) not null,
                              photo varchar(999),
                              primary key(id)
);

-- insert 3 brands
insert into cars.brands(brandname, country, logo) values (
    'Mercedes',
    'Germany',
    'https://image.shutterstock.com/image-photo/valencia-spain-march-27-2017-600w-617716007.jpg'
);
insert into cars.brands(brandname, country, logo) values (
    'BMW',
    'Germany',
    'https://image.shutterstock.com/image-photo/kiev-ukraine-march-21-2015-600w-269735093.jpg'
);
insert into cars.brands(brandname, country, logo) values (
    'Volkswagen',
    'Germany',
    'https://image.shutterstock.com/image-photo/kiev-ukraine-march-21-2015-600w-269735078.jpg'
);

-- insert 3 cars
insert into cars.models (modelname, brand, photo, price, cc, seats) values (
    'M3',
    'BMW',
    'https://image.shutterstock.com/image-photo/la-california-february-26-2018-600w-1035959809.jpg',
    36500,
    3,
    4
);
insert into cars.models (modelname, brand, photo, price, cc, seats) values (
    'Golf',
    'Volkswagen',
    'https://image.shutterstock.com/image-photo/riga-lv-jun-10-2020-600w-1753534913.jpg',
    17500,
    2.0,
    5
);
insert into cars.models (modelname, brand, photo, price, cc, seats) values (
    'c63 AMG',
    'Mercedes',
    'https://image.shutterstock.com/image-photo/oradearomania-mercedesbenz-c63-s-coupe-600w-1404613571.jpg',
    41500,
    4.0,
    4
);

-- insert 1 admin
insert into cars.sellers (username, password, email, photo) values (
    'bart',
    '123456',
    'bart@simpson.com',
    'https://randomuser.me/api/portraits/men/32.jpg'
);