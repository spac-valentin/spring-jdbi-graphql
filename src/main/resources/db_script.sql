create table brand(
    id identity,
    name VARCHAR(128) not null,
    country VARCHAR(128) not null
);

create table vehicle(
    id identity,
    brand_id int,
    model_code VARCHAR(128) not null,
    CONSTRAINT fk_brand_vehicle FOREIGN KEY (brand_id)
        REFERENCES brand(id)
);


