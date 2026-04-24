CREATE TABLE consertos (
     id BIGINT NOT NULL AUTO_INCREMENT,
     data_entrada VARCHAR(255) NOT NULL,
     data_saida VARCHAR(255),

     marca VARCHAR(100),
     modelo VARCHAR(100),
     ano INT,

     nome VARCHAR(100),
     anos_experiencia INT,

     PRIMARY KEY (id)
);