CREATE TABLE product (
    id              UUID PRIMARY KEY,
    name            VARCHAR(256) UNIQUE NOT NULL,
    description     TEXT,
    category        INTEGER REFERENCES product_category(id) NOT NULL,
    created_at      TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product_category (
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(50) UNIQUE NOT NULL
);