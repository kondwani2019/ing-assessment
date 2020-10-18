--  Addresses
insert into address (id,address_line_1, city, state, postal_code) values (1, '14 Brown Street', 'Chatswood', 'NSW', '2067');
insert into address (id,address_line_1, city, state, postal_code) values (2, '10 George Street', 'Sydney', 'NSW', '2000');
insert into address (id,address_line_1, city, state, postal_code) values (3, '13 Victoria Avenue', 'Chatswood', 'NSW', '2067');
insert into address (id,address_line_1, city, state, postal_code) values (4, '12 Pacific Highway', 'St Leonards', 'NSW', '2057');
insert into address (id,address_line_1, city, state, postal_code) values (5, '55 Pacific Highway', 'Artamon', 'NSW', '2058');
insert into address (id,address_line_1, city, state, postal_code) values (6, '234 George Street', 'Sydney', 'NSW', '2000');
insert into address (id,address_line_1, city, state, postal_code) values (7, '132 George Street', 'Sydney', 'NSW', '2000');

--  Persons

insert into person (id,first_name, last_name, gender, address_id) values (1, 'Frank', 'Smith', 'MALE', 1);
insert into person (id,first_name, last_name, gender, address_id) values (2, 'Betty', 'Smith', 'FEMALE', 1);
insert into person (id,first_name, last_name, gender, address_id) values (3, 'John', 'Dow', 'MALE', 2);
insert into person (id,first_name, last_name, gender, address_id) values (4, 'Rose', 'Harris', 'FEMALE', 3);
insert into person (id,first_name, last_name, gender, address_id) values (5, 'Harry', 'Davidson', 'MALE', 3);
insert into person (id,first_name, last_name, gender, address_id) values (6, 'George', 'Kastanza', 'MALE', 4);
insert into person (id,first_name, last_name, gender, address_id) values (7, 'Jane', 'Kastanza', 'FEMALE', 4);
insert into person (id,first_name, last_name, gender, address_id) values (8, 'Jill', 'Scott', 'FEMALE', 5);
insert into person (id,first_name, last_name, gender, address_id) values (9, 'Ben', 'Simmons', 'MALE', 6);
insert into person (id,first_name, last_name, gender, address_id) values (10, 'Steph', 'Curry', 'MALE', 7);

--  Users Attached to Persons

insert into users (id,user_name, password, person_id) values (1, 'franks', '1234', 1);
insert into users (id,user_name, password, person_id) values (2, 'bettys', '1234', 2);
insert into users (id,user_name, password, person_id) values (3, 'johnd', '1234', 3);
insert into users (id,user_name, password, person_id) values (4, 'rohse', '1234', 4);
insert into users (id,user_name, password, person_id) values (5, 'harryd', '1234', 5);
insert into users (id,user_name, password, person_id) values (6, 'georgek', '1234', 6);
insert into users (id,user_name, password, person_id) values (7, 'janek', '1234', 7);
insert into users (id,user_name, password, person_id) values (8, 'jills', '1234', 8);
insert into users (id,user_name, password, person_id) values (9, 'bensim', '1234', 9);
insert into users (id,user_name, password, person_id) values (10, 'stepcur', '1234', 10);
