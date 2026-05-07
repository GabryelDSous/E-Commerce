CREATE TABLE tb_products (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(150) NOT NULL UNIQUE,
    description VARCHAR(200) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    seller_name VARCHAR(100) NOT NULL,
    stock INTEGER,
    status VARCHAR(30)
);