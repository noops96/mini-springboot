create table account(id serial primary key,
email varchar(255),password varchar(255),is_active Boolean,
created_at timestamp);

create table seller(id serial primary key,
name varchar(255),no_ktp varchar(255), account_id integer,created_at timestamp,
CONSTRAINT fk FOREIGN KEY (account_id) REFERENCES account(id));
 
create table buyer(id serial primary key,
name varchar(255), account_id integer,created_at timestamp,
CONSTRAINT fk FOREIGN KEY (account_id) REFERENCES account(id));
