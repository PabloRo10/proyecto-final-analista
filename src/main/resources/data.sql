CREATE PROCEDURE IF NOT EXISTS cargar_datos_iniciales()
BEGIN
    IF NOT EXISTS (SELECT * FROM categorias)
    THEN

       INSERT INTO estados_rastreo (codigo, descripcion) VALUES 
            (1, 'en preparación'),
            (2, 'en camino'),
            (3, 'entregado');

       INSERT INTO categorias (id, nombre) VALUES 
            (1, 'En grano'),
            (2, 'Filtrado'),
            (3, 'Espresso'),
            (4, 'Francesa'),
            (5, 'Moka');

        INSERT INTO roles (nombre_rol) VALUES 
            ('Cliente'),
            ('Empleado'),
            ('Administrador');

        INSERT INTO usuarios (nombre_usuario, nombre_completo, clave_acceso, correo_electronico) VALUES
            ('nikolai123', 'Nikolai Cortazza', 'delcafe123', 'nikoilai@example.com'), 
            ('pablo456', 'Pablo Rodriguez', 'delcafe123', 'pablo@example.com'), 
            ('pedro123', 'Pedro Rodriguez','delcafe123', 'pedro@example.com'), 
            ('jorge123', 'Jorge Gutierrez','delcafe123', 'jorge@example.com'), 
            ('nico789', 'Nicolas Lopez', 'delcafe123', 'nicolas@example.com'),
            ('cliente1', 'Rodrigo Chagas','delcafe123', 'empleado1@example.com'),
            ('cliente2', 'Carla Suarez','delcafe123', 'empleado2@example.com'),
            ('cliente3', 'Romina Herazo','delcafe123', 'empleado3@example.com'),
            ('cliente4', 'Gonzalo Petit','delcafe123', 'empleado4@example.com'),
            ('cliente5', 'Magali Coates','delcafe123', 'empleado5@example.com'),
            ('cliente123', 'Lucas Morales','delcafe123', 'lucas@example.com'),
            ('cliente23', 'Felipe Carballo','delcafe123', 'felipe@example.com'),
            ('empleado1', 'Paula Herazo','delcafe123', 'pau@example.com'),
            ('empleado2', 'Ruben Petit','delcafe123', 'ruben@example.com'),
            ('empleado3', 'Nicol Coates','delcafe123', 'nico@example.com'),
            ('empleado4', 'Sebastian Morales','delcafe123', 'seba@example.com'),
            ('empleado5', 'Macarena Carballo','delcafe123', 'macarena@example.com');
            
        INSERT INTO administradores (nombre_usuario) VALUES 
            ('nikolai123'), 
            ('pablo456');

        INSERT INTO empleados (nombre_usuario) VALUES 
            ('empleado1'),
            ('empleado2'),
            ('empleado3'),
            ('empleado4'),
            ('empleado5');

        INSERT INTO clientes (cedula, domicilio, telefono, nombre_usuario) VALUES 
            ('42345678', 'Calle Falsa 123', '099123456', 'pedro123'), 
            ('23456789', 'Calle Falsa 123', '099123456', 'jorge123'), 
            ('97564216', 'Calle Falsa 123', '099123456', 'nico789'), 
            ('88654321', 'Av. Siempre Viva 742', '099654321', 'cliente1'),
            ('12345678', 'Calle Falsa 123', '099123456', 'cliente2'), 
            ('23457789', 'Calle Falsa 123', '099123456', 'cliente3'), 
            ('97564016', 'Calle Falsa 123', '099123456', 'cliente4'), 
            ('87654321', 'Av. Siempre Viva 742', '099654321', 'cliente5'),
            ('37564216', 'Calle Falsa 123', '099123456', 'cliente123'), 
            ('17654321', 'Av. Siempre Viva 742', '099654321', 'cliente23');

        INSERT INTO usuario_roles (usuario_id, rol_id) VALUES
            ('nikolai123','administrador'), 
            ('pablo456','administrador'),
            ('pedro123', 'cliente'),
            ('jorge123', 'cliente'),
            ('cliente1', 'cliente'),
            ('cliente2', 'cliente'),
            ('nico789', 'cliente'),
            ('cliente3', 'cliente'),
            ('cliente4', 'cliente'),
            ('cliente5', 'cliente'),
            ('cliente123','cliente'),
            ('cliente23','cliente'),
            ('empleado1','empleado'),
            ('empleado2','empleado'),
            ('empleado3','empleado'),
            ('empleado4','empleado'),
            ('empleado5','empleado');

        INSERT INTO eventos (codigo, nombre, descripcion, direccion, cupo) VALUES
            (1,'Cata de Cafés del Mundo', 'Un evento exclusivo donde los participantes podrán degustar variedades de café de distintas regiones del mundo: Colombia, Etiopía, Brasil, Costa Rica y más. Contaremos con baristas especializados que guiarán la experiencia sensorial.','Local Central Café DelCafé, Av. 18 de Julio 1234, Montevideo', 25), 
            (2,'Tarde de Café y Arte', 'Taller creativo donde los asistentes disfrutarán de café artesanal mientras participan en una actividad artística: pintura libre, acuarela o ilustración con café. Ideal para relajarse, compartir y expresarse.', 'Sala Cultural DelCafé, Juan Paullier 567, Montevideo', 15), 
            (3,'Café Run - 5K Recreativa', 'Evento deportivo al aire libre donde los participantes correrán 5 kilómetros por la rambla de Montevideo. Al finalizar, todos podrán disfrutar de un desayuno saludable con café de especialidad, frutas y productos de la marca DelCafé. Ideal para familias y grupos de amigos.', 'Punto de encuentro: Rambla Gandhi esquina 21 de Septiembre, Montevideo', 100);

        INSERT INTO cliente_eventos (cliente_id, evento_id) VALUES
            ('pedro123', 1),
            ('jorge123', 2),
            ('jorge123', 3),
            ('cliente1', 1),
            ('cliente2', 2),
            ('cliente2', 3),
            ('nico789', 3),
            ('cliente3', 1),
            ('cliente4', 2),
            ('cliente5', 3),
            ('cliente123', 2),
            ('cliente23', 1);
        
        INSERT INTO productos (codigo, nombre, descripcion, disponible, precio, cantidad, categoria_id) VALUES
            (1,'Cafe Uno', 'blah blah blah blah blah', b'1', 300, 100, 1),
            (2,'Cafe Dos', 'blah blah blah blah blah', b'1', 350, 100, 2),
            (3,'Cafe Tres', 'blah blah blah blah blah', b'1', 400, 100, 3),  
            (4,'Cafe Cuatro', 'blah blah blah blah blah', b'1', 300, 100, 4), 
            (5,'Cafe Cinco', 'blah blah blah blah blah', b'1', 500, 100, 5), 
            (6,'Maquina Moka', 'blah blah blah blah blah', b'1', 2000, 100, 2), 
            (7,'Maquina Espresso', 'blah blah blah blah blah', b'1', 2500, 100, 2), 
            (8,'Maquina Filtrado', 'blah blah blah blah blah', b'1', 3000, 100, 2), 
            (9,'Filtros V60', 'blah blah blah blah blah', b'1', 700, 100, 2), 
            (10,'Jarra Cuello de Cisne', 'blah blah blah blah blah', b'1', 2300, 100, 2),
            (11,'V60 vidrio', 'blah blah blah blah blah', b'1', 4000, 100, 2);

        INSERT INTO cafes (codigo, origen) VALUES 
            (1, 'Brasil'),
            (2, 'Colombia'),
            (3, 'Peru'),
            (4, 'El salvador'),
            (5, 'Mexico');

        INSERT INTO Accesorios (codigo) VALUES 
            (6),
            (7),
            (8),
            (9),
            (10),
            (11);

        INSERT INTO pedidos (codigo, fecha_hora, cliente_id, estado_rastreo_codigo) VALUES
            (1, '2024-10-01 12:34:56','cliente2',1),
            (2, '2024-10-01 12:34:56','cliente23',2),
            (3, '2024-10-01 12:34:56','nico789',3);
        
       INSERT INTO detalles_pedido (codigo, pedido_id, producto_id, cantidad) VALUES
            (1,2,1,5),
            (2,2,2,8),
            (3,2,3,3),
            (4,2,4,2),
            (5,2,5,1),
            (6,2,6,2),
            (7,3,11,5),
            (8,3,2,8),
            (9,3,9,3),
            (10,3,7,2),
            (11,3,8,1),
            (12,3,6,2),
            (13,3,11,5),
            (14,1,2,50),
            (15,1,6,30),
            (16,1,7,21),
            (17,1,5,11),
            (18,1,2,22);

        INSERT INTO plan_suscripciones (codigo, nombre, precio, descripcion) VALUES
            (1,'Plan Brasil', 790, 'El plan pensado para quienes prefieren recibir un mismo café, fijo, que mantenga sus características mes a mes. Un café que se convierta en parte de tus hábitos, casi sin pensarlo.'),
            (2,'Plan Mundial', 1050, 'El plan pensado para quienes buscan nuevas experiencias cafeteras, mes a mes. Si sos de paladar curiosoy tu perfil como amante del café es el más arriesgado, ésta es la suscripción ideal.'),
            (3,'Plan Decafe', 1060, 'Para aquellos que aman el sabor y la experiencia del café pero prefieren evitar la cafeína, nuestro Plan Decaf es la opción perfecta. Este plan está diseñado para los verdaderos amantes del café que buscan disfrutar de una experiencia completa sin comprometer su descanso.'),
            (4,'Plan Oficina', 2900, 'Un plan creado para abastecer a oficinas y espacios laborales. Un plan con café de Brasil, enviado de la manera más apropiada para el método/máquina que el espacio laboral requiera.');

        INSERT INTO cliente_plansuscripcion (cliente_id, plansuscripcion_id) VALUES
            ('pedro123', 1),
            ('jorge123', 2),
            ('jorge123', 3),
            ('cliente1', 1),
            ('cliente2', 2),
            ('cliente2', 3),
            ('nico789', 4),
            ('cliente3', 1),
            ('cliente4', 2),
            ('cliente5', 3),
            ('cliente123', 4),
            ('cliente23', 1);

    END IF;
END^;

CALL cargar_datos_iniciales()^;

        




