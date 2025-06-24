-- 📘 BIBLIOTECA
INSERT INTO biblioteca (titulo, descripcion, url) VALUES
                                                      ('Presupuesto personal', 'Aprende a crear y mantener un presupuesto efectivo.', 'https://bettermoneyhabits.bankofamerica.com/es/saving-budgeting/creating-a-budget'),
                                                      ('Ahorro inteligente', 'Estrategias para ahorrar y alcanzar tus metas financieras.', 'https://www.viabcp.com/blog-bcp/ahorro-automatico-estrategias-para-ahorrar'),
                                                      ('Inversiones básicas', 'Guía introductoria al mundo de las inversiones.', 'https://www.bbva.com/es/salud-financiera/que-son-las-inversiones-financieras-y-que-tipos-existen/');
-- 💡 CONSEJOS
INSERT INTO consejo (titulo, descripcion) VALUES
                                              ('Ahorra primero', 'Destina una parte de tus ingresos al ahorro antes de gastar.'),
                                              ('Evita gastos hormiga', 'Pequeños gastos diarios pueden afectar tu presupuesto mensual.');-- 🎓 MICROLECCIONES
INSERT INTO microleccion (tema, descripcion, contenido) VALUES
                                                            ('Diferencia entre activos y pasivos', 'Concepto financiero básico', 'Un activo pone dinero en tu bolsillo, un pasivo lo saca.'),
                                                            ('Interés simple vs compuesto', 'Diferencias entre tipos de interés', 'El interés compuesto genera intereses sobre intereses.');
INSERT INTO quiz (texto, correcta, recomendacion, imagen)
VALUES (
           '¿Qué es el interés compuesto?',
           'Interés sobre interés',
           'Te recomendamos ahorrar e invertir temprano.',
           'https://www.bbva.com/wp-content/uploads/2020/01/interes-compuesto.jpg'
       );

-- Guarda el ID insertado
SET @quiz_id = LAST_INSERT_ID();

-- Inserta las opciones del quiz
INSERT INTO quiz_opciones (quiz_id, opcion) VALUES
                                                (@quiz_id, 'Un impuesto'),
                                                (@quiz_id, 'Interés sobre interés'),
                                                (@quiz_id, 'Gasto fijo');
