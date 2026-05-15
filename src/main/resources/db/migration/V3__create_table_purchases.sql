CREATE TABLE tb_purchases (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),

    user_id UUID NOT NULL,
    user_name VARCHAR(190) NOT NULL,

    product_id UUID NOT NULL,
    product_name VARCHAR(150) NOT NULL,

    purchase_date TIMESTAMP NOT NULL,
    quantity INTEGER,

    CONSTRAINT fk_purchase_user
    FOREIGN KEY (user_id)
    REFERENCES tb_users(id)
    ON DELETE CASCADE,

    CONSTRAINT fk_purchase_product
    FOREIGN KEY (product_id)
    REFERENCES tb_products(id)
);