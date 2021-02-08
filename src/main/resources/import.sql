INSERT INTO customers (id, name, surname, email, create_at) VALUES (1, 'Jhon Eyder', 'Marin Villa', 'jhoneider.mv@gmail.com', '1993-04-20');
INSERT INTO customers (id, name, surname, email, create_at) VALUES (2, 'Manuela', 'Atehortua Hurtado', 'manuatehortua28@gmail.com', '1996-11-09');

INSERT INTO products (name, price, create_at) VALUES ('Panasonic pantalla LCD', 259990, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Sony Camara Digital DsC-W320B', 123490, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Apple ipod shuffle', 14999990, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Sony Notebook Z110', 37990, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Hewlett Packard Muntifuncional F2280', 69990, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Bianchi bicicleta rin 26', 259990, NOW());
INSERT INTO products (name, price, create_at) VALUES ('Mica comoda 5 cajones', 299990, NOW());

INSERT INTO invoices (description, observation, customer_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());
INSERT INTO item_invoices (quantity, invoice_id, product_id) VALUES(1, 1, 1);
INSERT INTO item_invoices (quantity, invoice_id, product_id) VALUES(2, 1, 4);
INSERT INTO item_invoices (quantity, invoice_id, product_id) VALUES(1, 1, 5);
INSERT INTO item_invoices (quantity, invoice_id, product_id) VALUES(1, 1, 7);

INSERT INTO invoices (description, observation, customer_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO item_invoices (quantity, invoice_id, product_id) VALUES(3, 2, 6);