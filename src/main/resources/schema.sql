CREATE TABLE biblioteca (
                            id BIGINT PRIMARY KEY,
                            titulo VARCHAR(255),
                            descripcion TEXT,
                            url TEXT
);

CREATE TABLE consejo (
                         id BIGINT PRIMARY KEY,
                         titulo VARCHAR(255),
                         descripcion TEXT
);

CREATE TABLE microleccion (
                              id BIGINT PRIMARY KEY,
                              tema VARCHAR(255),
                              contenido TEXT,
                              nivel VARCHAR(50)
);

CREATE TABLE quiz (
                      id BIGINT PRIMARY KEY,
                      texto TEXT,
                      correcta VARCHAR(255),
                      recomendacion TEXT,
                      imagen TEXT
);

CREATE TABLE quiz_opciones (
                               quiz_id BIGINT,
                               opciones VARCHAR(255),
                               FOREIGN KEY (quiz_id) REFERENCES quiz(id)
);
