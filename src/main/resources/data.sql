-- 📘 BIBLIOTECA
INSERT INTO biblioteca (id, titulo, descripcion, url) VALUES
                                                          (1, 'Presupuesto personal', 'Aprende a crear y mantener un presupuesto efectivo.', 'https://bettermoneyhabits.bankofamerica.com/es/saving-budgeting/creating-a-budget'),
                                                          (2, 'Ahorro inteligente', 'Estrategias para ahorrar y alcanzar tus metas financieras.', 'https://www.viabcp.com/blog-bcp/ahorro-automatico-estrategias-para-ahorrar'),
                                                          (3, 'Inversiones básicas', 'Guía introductoria al mundo de las inversiones.', 'https://www.bbva.com/es/salud-financiera/que-son-las-inversiones-financieras-y-que-tipos-existen/');

-- 💡 CONSEJOS
INSERT INTO consejo (id, titulo, descripcion) VALUES
                                                  (1, 'Ahorra primero', 'Destina una parte de tus ingresos al ahorro antes de gastar.'),
                                                  (2, 'Evita gastos hormiga', 'Pequeños gastos diarios pueden afectar tu presupuesto mensual.');

-- 🎓 MICROLECCIONES
INSERT INTO microleccion (id, tema, contenido, nivel) VALUES
                                                          (1, 'Diferencia entre activos y pasivos', 'Un activo pone dinero en tu bolsillo, un pasivo lo saca.', 'BASICO'),
                                                          (2, 'Interés simple vs compuesto', 'El interés compuesto genera intereses sobre intereses.', 'INTERMEDIO');

-- 🧠 QUIZZES
INSERT INTO quiz (id, texto, correcta, recomendacion, imagen) VALUES
    (1, '¿Qué es el interés compuesto?', 'Interés sobre interés', 'Recuerda que el interés compuesto es cuando ganas intereses sobre intereses acumulados.', 'https://www.bbva.com/wp-content/uploads/2020/01/interes-compuesto.jpg');

-- Opciones del quiz 1
INSERT INTO quiz_opciones (quiz_id, opciones) VALUES
                                                  (1, 'Un impuesto'),
                                                  (1, 'Interés sobre interés'),
                                                  (1, 'Gasto fijo');
