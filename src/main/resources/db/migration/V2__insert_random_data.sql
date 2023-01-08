INSERT INTO brand (id, brand_name)
VALUES (1, 'zara'),
       (2, 'test_brand2');

INSERT INTO tariff (id, tariff_name)
VALUES (1, 'test_price1'),
       (2, 'test_price2'),
       (3, 'test_price3'),
       (4, 'test_price4');

INSERT INTO product (id, product_name)
VALUES (1, 'test_product1'),
       (2, 'test_product2'),
       (35455, 'test_product35455');


INSERT INTO prices (brand_id, product_id, tariff_id, start_date, end_date, priority, price, currency)
values ((SELECT b.id from brand as b where b.brand_name = 'zara'),
        (SELECT p.id from product as p where p.product_name = 'test_product35455'),
        (SELECT pr.id from tariff as pr where pr.tariff_name = 'test_price1'),
        '2020-06-14 00:00:0',
        '2020-12-31 23:59:59',
        0,
        35.50,
        'EUR'),
       ((SELECT b.id from brand as b where b.brand_name = 'zara'),
        (SELECT p.id from product as p where p.product_name = 'test_product35455'),
        (SELECT pr.id from tariff as pr where pr.tariff_name = 'test_price2'),
        '2020-06-14 15:00:00',
        '2020-06-14 18:30:00',
        1,
        25.45,
        'EUR'),
       ((SELECT b.id from brand as b where b.brand_name = 'zara'),
        (SELECT p.id from product as p where p.product_name = 'test_product35455'),
        (SELECT pr.id from tariff as pr where pr.tariff_name = 'test_price3'),
        '2020-06-15 00:00:00',
        '2020-06-15 11:00:00',
        1,
        30.50,
        'EUR'),
       ((SELECT b.id from brand as b where b.brand_name = 'zara'),
        (SELECT p.id from product as p where p.product_name = 'test_product35455'),
        (SELECT pr.id from tariff as pr where pr.tariff_name = 'test_price4'),
        '2020-06-15 16:00:00',
        '2020-12-31 23:59:59',
        1,
        38.95,
        'EUR');
