CREATE TABLE IF NOT EXISTS brand
(
    id SERIAL,
    brand_name  varchar(100) NOT NULL,
    CONSTRAINT brand_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tariff
(
    id SERIAL,
    tariff_name  varchar(100) NOT NULL,
    CONSTRAINT tariff_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product
(
    id SERIAL,
    product_name  varchar(100) NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS prices
(
    id SERIAL,
    brand_id integer NOT NULL,
    product_id  integer NOT NULL,
    tariff_id  integer NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    priority integer NOT NULL,
    price decfloat(5) NOT NULL,
    currency varchar(10) NOT NULL,
    CONSTRAINT prices_pkey PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES brand(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (tariff_id) REFERENCES tariff(id)

);
