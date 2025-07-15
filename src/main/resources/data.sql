CREATE PROCEDURE IF NOT EXISTS cargar_datos_iniciales()
BEGIN
    IF NOT EXISTS(SELECT * FROM categorias)
    THEN

        INSERT INTO estados_rastreo (codigo, descripcion) VALUES
            (1, 'Pedido realizado'),
            (2, 'En preparacion'),
            (3, 'En camino'),
            (4, 'Entregado');

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
            ('juan123', 'Juan Gracia', 'abc123', 'juan@example.com'), 
            ('ana456', 'Ana Perez', '321cba', 'ana@example.com'), 
            ('pedro123', 'Pedro Rodriguez','123abc', 'pedro@example.com'), 
            ('jorge123', 'Jorge Gutierrez','cba321', 'jorge@example.com'), 
            ('nico789', 'Nicolas Lopez', '456abc', 'nicolas@example.com'),
            ('empleado1', 'Rodrigo Chagas','abc456', 'empleado1@example.com'),
            ('empleado2', 'Carla Suarez','cba456', 'empleado2@example.com'),
            ('empleado3', 'Romina Herazo','456cba', 'empleado3@example.com'),
            ('empleado4', 'Gonzalo Petit','654abc', 'empleado4@example.com'),
            ('empleado5', 'Magali Coates','abc654', 'empleado5@example.com'),
            ('Lucas123', 'Lucas Morales','cba654', 'lucas@example.com'),
            ('Felipe123', 'Felipe Carballo','654cba', 'felipe@example.com');

        INSERT INTO clientes (cedula, domicilio, telefono, nombre_usuario) VALUES 
            ('12345678', 'Calle Falsa 123', '099123456', 'juan123'), 
            ('23456789', 'Calle Falsa 123', '099123456', 'pedro123'), 
            ('97564216', 'Calle Falsa 123', '099123456', 'jorge123'), 
            ('87654321', 'Av. Siempre Viva 742', '099654321', 'ana456');

        INSERT INTO usuarios_roles (nombre_usuario, nombre_rol) VALUES
            ('juan123', 'Cliente'),
            ('ana456', 'Cliente'),
            ('pedro123', 'Cliente'),
            ('jorge123', 'Cliente'),
            ('nico789', 'Empleado'),
            ('empleado1', 'Empleado'),
            ('empleado2', 'Empleado'),
            ('empleado3', 'Empleado'),
            ('empleado4', 'Empleado'),
            ('empleado5', 'Empleado'),
            ('Lucas123', 'Administrador'),
            ('Felipe123', 'Administrador');

        INSERT INTO tipo_producto (nombre_tipo) VALUES
            (1, 'Cafe'),
            (2, 'Accesorio');

        INSERT INTO productos (codigo, nombre, descripcion, disponible, precio, cantidad, tipo_producto) VALUES
            (1, 'Cafe Uno', 'blah blah blah blah blah', 1, 300, 1, 1), 
            (2, 'Cafe Dos', 'blah blah blah blah blah', 1, 350, 1, 1),
            (3, 'Cafe Tres', 'blah blah blah blah blah', 2, 400, 1, 1),  
            (4, 'Cafe Cuatro', 'blah blah blah blah blah', 1, 300, 1, 1), 
            (5, 'Cafe Cinco', 'blah blah blah blah blah', 2, 500, 1, 1), 
            (6, 'Maquina Moka', 'blah blah blah blah blah', 1, 2000, 1, 2), 
            (7, 'Maquina Espresso', 'blah blah blah blah blah', 1, 2500, 1, 2), 
            (6, 'Maquina Filtrado', 'blah blah blah blah blah', 1, 3000, 1, 2), 
            (8, 'Filtros V60', 'blah blah blah blah blah', 2, 700, 1, 2), 
            (9, 'Jarra Cuello de Cisne', 'blah blah blah blah blah', 2, 2300, 1, 2),
            (10, 'V60 vidrio', 'blah blah blah blah blah', 1, 4000, 1, 2);

        INSERT INTO cafes (codigo, origen) VALUES 
            (1, "Brasil"),
            (2, "Colombia"),
            (3, "Peru"),
            (4, "El salvador"),
            (5, "Mexico");

        




