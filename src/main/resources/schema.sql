CREATE TABLE biblioteca (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            titulo VARCHAR(255) NOT NULL,
                            descripcion TEXT,
                            url TEXT
);


CREATE TABLE consejo (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL,
                         descripcion TEXT
);

CREATE TABLE microleccion (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              tema VARCHAR(255) NOT NULL,
                              descripcion TEXT,
                              contenido TEXT
);
CREATE TABLE quiz (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      texto VARCHAR(500) NOT NULL,
                      correcta VARCHAR(255) NOT NULL,
                      recomendacion TEXT,
                      imagen TEXT
);

CREATE TABLE quiz_opciones (
                               id BIGINT AUTO_INCREMENT PRIMARY KEY,
                               quiz_id BIGINT NOT NULL,
                               opcion VARCHAR(255) NOT NULL,
                               FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON DELETE CASCADE
);
