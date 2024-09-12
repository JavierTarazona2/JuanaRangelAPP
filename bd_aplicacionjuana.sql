-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-09-2024 a las 18:58:33
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_aplicacionjuana`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `balance`
--

CREATE TABLE `balance` (
  `id` int(11) NOT NULL,
  `detalle` tinytext NOT NULL,
  `cantidad` float NOT NULL,
  `fecha` date NOT NULL,
  `tipo_balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `balance`
--

INSERT INTO `balance` (`id`, `detalle`, `cantidad`, `fecha`, `tipo_balance`) VALUES
(1, 'Venta para lkxlsfsd', 4000, '2024-08-07', 2),
(2, 'Venta para lkxlsfsd', 4000, '2024-08-07', 2),
(3, 'Pedido Realizado a Cristian Torres', 20000, '2024-08-07', 1),
(5, 'Venta para lkxlsfsd', 4000, '2024-08-07', 2),
(6, 'Pedido Realizado a Petro Ramirez', 3500, '2024-08-07', 1),
(7, 'Pedido realizado por Sena', 19000, '2024-08-07', 2),
(8, 'Venta para lkxlsfsd', 4000, '2024-08-07', 2),
(9, 'Sueldos de los empleados', 1500000, '2024-08-08', 1),
(10, 'Peido realizado por Sena', 16000, '2024-08-26', 2),
(11, 'Peido realizado por Sena', 56000, '2024-08-26', 2),
(12, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-26', 1),
(13, 'Pedido Realizado a Petro Ramirez', 35000, '2024-08-30', 1),
(14, 'Peido realizado por Sena', 16000, '2024-08-30', 2),
(15, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(16, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(17, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(18, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(19, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(20, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(21, 'Pedido Realizado a Petro Ramirez', 65000, '2024-08-30', 1),
(22, 'Peido realizado por Sena', 56000, '2024-08-30', 2),
(23, 'Venta realizado para Cristian Torres', 2000, '2024-09-02', 2),
(24, 'Pedido Realizado a Iverson Tarazona', 10000, '2024-09-02', 1),
(25, 'Pedido realizado por Cristian Torres', 12500, '2024-09-02', 2),
(26, 'Pedido Realizado a Jesus Toloza', 2000, '2024-09-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`) VALUES
(1, 'Tienda'),
(2, 'Insumo'),
(3, 'Panaderia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `correo` varchar(250) NOT NULL,
  `numero` varchar(59) NOT NULL,
  `identificacion` int(15) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `correo`, `numero`, `identificacion`, `direccion`) VALUES
(1, 'Cristian Torres', 'cristiantorrescarrero@gmail.com', '+57 310 5818437', 1323321, 'La mierda'),
(2, 'NA', 'NADÑC', '213', 21312, 'AS'),
(3, 'Sena', 'Sena@gmail.com', '123456789', 1232894, 'pescadero-Cucuta'),
(4, 'NA', 'NADÑC', '213', 21312, 'AS'),
(5, 'lkxlsfsd', '123123', 'cxzcxzzcx', 1323321, 'klllk');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `identificacion` int(11) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `sueldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`id`, `nombre`, `telefono`, `correo`, `identificacion`, `direccion`, `fecha_ingreso`, `fecha_nacimiento`, `estado`, `sueldo`) VALUES
(1, 'Santiago Tarazona', '920213455', 'santiagotarazona@gmail.com', 901212, 'kjasj1wk', '2024-08-08', '2015-03-10', 1, 1500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_proveedor`
--

CREATE TABLE `pedido_proveedor` (
  `id` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `codigo` varchar(50) NOT NULL,
  `valor` double NOT NULL,
  `fecha_entrega` date NOT NULL,
  `fecha_realizacion` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pedido_proveedor`
--

INSERT INTO `pedido_proveedor` (`id`, `id_proveedor`, `codigo`, `valor`, `fecha_entrega`, `fecha_realizacion`, `estado`) VALUES
(5, 2, 'Codigo factura', 20000, '2024-08-09', '2024-08-07', 1),
(6, 3, 'j1ln3s', 10000, '2024-09-10', '2024-08-07', 1),
(7, 5, 'j2he12l', 1500, '2024-09-07', '2024-08-07', 0),
(8, 5, 'LAS192N', 65000, '2024-09-01', '2024-08-26', 1),
(9, 5, 'HLa2O3', 35000, '2024-09-05', '2024-08-30', 1),
(10, 1, 'AnmIpm21', 2000, '2024-09-07', '2024-09-01', 1),
(11, 1, 'sas', 1500, '2024-12-12', '2024-09-01', 0),
(12, 1, 'sas', 1500, '2024-12-12', '2024-09-01', 0),
(13, 1, 'SSG42456C', 1500, '2024-09-05', '2024-09-01', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `codigo` varchar(200) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `medida` varchar(200) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `precio_entrada` double NOT NULL,
  `precio_venta` double NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `codigo`, `nombre`, `medida`, `id_categoria`, `precio_entrada`, `precio_venta`, `fecha_vencimiento`, `fecha_ingreso`, `cantidad`) VALUES
(6, '1', 'Azucar', 'Empaque 1 kilogramo, Marca caña', 1, 2000, 3000, '2034-12-10', '2024-08-07', 0),
(7, '2', 'Arroz', 'Empaque de 1 kilogramo Marca Roa', 1, 2000, 4000, '2034-12-12', '2024-08-07', 4),
(8, '3', 'Sal', 'Paquete de 1 libra Marca Refisal', 1, 1500, 3000, '2034-10-01', '2024-08-07', 0),
(9, '4', 'Panela', 'unidad de kilo', 1, 1000, 3000, '2034-12-12', '2024-08-12', -1),
(10, '6', 'Pan de cascarita', 'pequeñp', 3, 300, 500, '2024-09-03', '2024-09-01', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_proveedor`
--

CREATE TABLE `producto_proveedor` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto_proveedor`
--

INSERT INTO `producto_proveedor` (`id`, `id_pedido`, `id_producto`, `cantidad_producto`) VALUES
(5, 5, 6, 10),
(6, 6, 7, 5),
(9, 7, 8, 1),
(10, 8, 6, 10),
(11, 8, 7, 12),
(12, 8, 8, 14),
(13, 9, 6, 10),
(14, 9, 8, 10),
(15, 10, 6, 1),
(16, 13, 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_venta`
--

CREATE TABLE `producto_venta` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `id_venta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto_venta`
--

INSERT INTO `producto_venta` (`id`, `id_producto`, `cantidad_producto`, `id_venta`) VALUES
(6, 6, 2, 7),
(7, 6, 2, 8),
(8, 6, 2, 9),
(9, 6, 2, 10),
(10, 8, 10, 10),
(11, 6, 1, 11),
(12, 7, 1, 11),
(13, 6, 1, 12),
(14, 7, 2, 12),
(15, 7, 2, 13),
(16, 9, 2, 13),
(17, 7, 1, 14),
(18, 9, 1, 14),
(19, 7, 1, 15),
(20, 6, 2, 16),
(21, 7, 2, 16),
(22, 6, 2, 17),
(23, 8, 2, 17),
(24, 9, 2, 17),
(25, 7, 5, 17),
(26, 6, 4, 18),
(27, 8, 4, 18),
(28, 7, 4, 18),
(29, 9, 4, 18),
(30, 6, 1, 19),
(31, 7, 1, 20),
(32, 8, 1, 21),
(33, 8, 1, 22),
(34, 8, 1, 23),
(35, 9, 1, 23),
(36, 8, 1, 24),
(37, 7, 1, 25),
(38, 8, 1, 26),
(39, 8, 1, 27),
(40, 8, 1, 28),
(41, 7, 1, 29),
(42, 6, 1, 30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `nombre`, `telefono`, `correo`) VALUES
(1, 'Jesus Toloza', '3102978512', 'jesustoloza@gmail.com'),
(2, 'Cristian Torres', '3105818437', 'cristiantorres@gmail.com'),
(3, 'Iverson Tarazona', '1023887125', 'Iversontarazona@gmail.com'),
(4, 'Mariet Perpinan', '1234567890', 'marietperpinan'),
(5, 'Petro Ramirez', '124358', 'ColombiaFc'),
(6, 'James Rodriguez', '1234567890', 'jamesrodriguez@gmail.com'),
(7, 'Jesus Toloza', '3102978512', 'jesustoloza@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte`
--

CREATE TABLE `reporte` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `detalle` tinytext NOT NULL,
  `codigo` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reporte`
--

INSERT INTO `reporte` (`id`, `id_producto`, `cantidad_producto`, `detalle`, `codigo`, `fecha`) VALUES
(4, 8, 1, 'Se mojo el empaque', 1, '2024-08-10'),
(5, 7, 2, 'mn', 2, '2024-07-20'),
(6, 9, 1, 'waswdsadasaadsadas', 3, '2024-09-01'),
(7, 8, 1, 'waswdsadasaadsadas', 3, '2024-09-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_balance`
--

CREATE TABLE `tipo_balance` (
  `id` int(11) NOT NULL,
  `nombre` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_balance`
--

INSERT INTO `tipo_balance` (`id`, `nombre`) VALUES
(1, 'Gasto'),
(2, 'Ingreso');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_venta`
--

CREATE TABLE `tipo_venta` (
  `id` int(11) NOT NULL,
  `tipo` varchar(7) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_venta`
--

INSERT INTO `tipo_venta` (`id`, `tipo`) VALUES
(1, 'Pedido'),
(2, 'Venta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `id_empleado` int(11) DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `user`, `contraseña`, `correo`, `id_empleado`, `estado`) VALUES
(1, 'JavierTarazona', '123456789', 'javierdariotarazonatarazona2@gmail.com', NULL, 1),
(2, 'DarioTarazona', '123456789', 'dariotarazona10@gmail.com', NULL, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fecha_realizacion` date NOT NULL,
  `detalles` tinytext DEFAULT NULL,
  `valor` double NOT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `id_tipo` int(11) NOT NULL,
  `codigo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id`, `id_cliente`, `fecha_entrega`, `fecha_realizacion`, `detalles`, `valor`, `estado`, `id_tipo`, `codigo`) VALUES
(7, 1, NULL, '2024-08-07', NULL, 4000, 1, 2, 'asd'),
(8, 1, '2024-12-10', '2024-08-07', 'jgxfjjcgghyfhghg', 4000, 0, 1, 'asj,kd'),
(9, 1, NULL, '2024-08-07', NULL, 4000, 1, 2, 'adwc'),
(10, 3, '2024-12-12', '2024-08-07', 'lksadasñdkl', 19000, 1, 1, 'asd2az'),
(11, 1, NULL, '2024-08-07', NULL, 4000, 1, 2, 'saasde'),
(12, 3, '2024-08-29', '2024-08-26', 'Realizar una torta de kilo por el valor de 50.000 pesos, detalles\n  El valor agregado por la realizacion del pedido es de: 50000', 56000, 1, 1, 'COD2024082220'),
(13, 3, '2024-09-05', '2024-08-30', 'REALIZO ALGO POR 20000  El valor agregado por la realizacion del pedido es de: 10000', 16000, 1, 1, 'COD2024081538'),
(14, 2, NULL, '2024-08-30', NULL, 3000, 1, 2, 'COD2024081550'),
(15, 1, '2024-08-31', '2024-08-30', 'Realizar pastel   El valor agregado por la realizacion del pedido es de: 20000', 22000, 0, 1, 'COD2024081551'),
(16, 1, NULL, '2024-08-30', NULL, 8000, 1, 2, 'COD2024081701'),
(17, 1, NULL, '2024-08-31', NULL, 19000, 1, 2, 'COD2024081634'),
(18, 1, NULL, '2024-08-31', NULL, 26000, 1, 2, 'COD2024081636'),
(19, 1, NULL, '2024-08-31', NULL, 2000, 1, 2, 'COD2024081639'),
(20, 1, NULL, '2024-08-31', NULL, 2000, 1, 2, 'COD2024081657'),
(21, 1, NULL, '2024-08-31', NULL, 1500, 1, 2, 'COD2024081719'),
(22, 3, '2024-10-10', '2024-09-01', 'El valor del pedido es   El valor agregado por la realizacion del pedido es de: 20000', 21500, 0, 1, 'COD2024091755'),
(23, 1, '2024-09-05', '2024-09-01', 'asjdashsakjdaskj  El valor agregado por la realizacion del pedido es de: 10000', 12500, 1, 1, 'COD2024092037'),
(24, 1, '2024-09-07', '2024-09-02', 'shdñfsklcadsjksc  El valor agregado por la realizacion del pedido es de: 20000', 21500, 0, 1, 'COD2024090855'),
(25, 1, NULL, '2024-09-02', NULL, 2000, 1, 2, 'COD2024090855'),
(26, 1, '2024-09-07', '2024-09-02', 'sadsasdda  El valor agregado por la realizacion del pedido es de: 10000', 11500, 0, 1, 'COD2024090922'),
(27, 1, '2024-09-07', '2024-09-02', 'sadsadasd  El valor agregado por la realizacion del pedido es de: 10000', 11500, 0, 1, 'COD2024090925'),
(28, 1, '2024-12-10', '2024-09-02', 'asddsads  El valor agregado por la realizacion del pedido es de: 10', 1510, 0, 1, 'COD2024090931'),
(29, 1, '2024-10-12', '2024-09-02', 'xzzxzxzx  El valor agregado por la realizacion del pedido es de: 100', 2100, 0, 1, 'COD2024091436'),
(30, 1, '2024-10-10', '2024-09-02', 'jkkjjkkj  El valor agregado por la realizacion del pedido es de: 1000', 3000, 0, 1, 'COD2024091715');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_balance` (`tipo_balance`);

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cate` (`id_categoria`);

--
-- Indices de la tabla `producto_proveedor`
--
ALTER TABLE `producto_proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `producto` (`id_producto`),
  ADD KEY `pedido` (`id_pedido`);

--
-- Indices de la tabla `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `venta` (`id_venta`),
  ADD KEY `productos` (`id_producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reporte`
--
ALTER TABLE `reporte`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_balance`
--
ALTER TABLE `tipo_balance`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_venta`
--
ALTER TABLE `tipo_venta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `empleado` (`id_empleado`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cliente` (`id_cliente`),
  ADD KEY `tipo_venta` (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `balance`
--
ALTER TABLE `balance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pedido_proveedor`
--
ALTER TABLE `pedido_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `producto_proveedor`
--
ALTER TABLE `producto_proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `producto_venta`
--
ALTER TABLE `producto_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `reporte`
--
ALTER TABLE `reporte`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `tipo_balance`
--
ALTER TABLE `tipo_balance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tipo_venta`
--
ALTER TABLE `tipo_venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `balance`
--
ALTER TABLE `balance`
  ADD CONSTRAINT `tipo_balance` FOREIGN KEY (`tipo_balance`) REFERENCES `tipo_balance` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `cate` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `producto_proveedor`
--
ALTER TABLE `producto_proveedor`
  ADD CONSTRAINT `pedido` FOREIGN KEY (`id_pedido`) REFERENCES `pedido_proveedor` (`id`),
  ADD CONSTRAINT `producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `producto_venta`
--
ALTER TABLE `producto_venta`
  ADD CONSTRAINT `productos` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `venta` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id`);

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `tipo_venta` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_venta` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
