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

-- insert 10 cars
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Polo',
                                                                              'Volkswagen',
                                                                              'https://image.shutterstock.com/image-photo/prague-czech-republic-20-1-600w-1313309792.jpg',
                                                                              12500,
                                                                              1.2,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Golf',
                                                                              'Volkswagen',
                                                                              'https://image.shutterstock.com/image-photo/riga-lv-jun-10-2020-600w-1753534913.jpg',
                                                                              17500,
                                                                              2.0,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'A4',
                                                                              'Audi',
                                                                              'https://image.shutterstock.com/image-photo/frankfurt-germany-sep-10-2019-600w-1527523121.jpg',
                                                                              28500,
                                                                              2.4,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'A3',
                                                                              'Audi',
                                                                              'https://image.shutterstock.com/image-photo/2nd-may-2018-audi-a3-260nw-1117058711.jpg',
                                                                              20500,
                                                                              1.6,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Clio',
                                                                              'Renault',
                                                                              'https://image.shutterstock.com/image-photo/warsaw-poland-11212019-new-renault-260nw-1567905157.jpg',
                                                                              14500,
                                                                              1.6,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Megane',
                                                                              'Renault',
                                                                              'https://image.shutterstock.com/image-photo/montmelo-spainseptember-29-2019-20062010-600w-1547407967.jpg',
                                                                              18800,
                                                                              1.6,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Scenic',
                                                                              'Renault',
                                                                              'https://image.shutterstock.com/image-photo/geneva-switzerland-march-05-2019-600w-1343503553.jpg',
                                                                              17000,
                                                                              1.9,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Astra',
                                                                              'Vauxhall',
                                                                              'https://image.shutterstock.com/image-photo/brussels-belgium-jan-09-2020-260nw-1667782387.jpg',
                                                                              18800,
                                                                              1.6,
                                                                              5
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'MX-5',
                                                                              'Mazda',
                                                                              'https://image.shutterstock.com/image-photo/brussels-belgium-jan-09-2020-600w-1619987485.jpg',
                                                                              16800,
                                                                              1.3,
                                                                              2
                                                                          );
insert into cars.models (modelname, brand, photo, price, cc, seats) values(
                                                                              'Supra',
                                                                              'Toyota',
                                                                              'https://image.shutterstock.com/image-photo/brussels-belgium-jan-09-2020-600w-1639268338.jpg',
                                                                              21250,
                                                                              1.7,
                                                                              4
                                                                          );

-- insert 1 admin
insert into cars.sellers (username, password, email, photo) values (
    'bart',
    '123456',
    'bart@simpson.com',
    'https://randomuser.me/api/portraits/men/32.jpg'
);