-- MySQL Script generated by MySQL Workbench
-- Tue Aug 22 15:54:14 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ESFOT-CARE
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `ESFOT-CARE` ;

-- -----------------------------------------------------
-- Schema ESFOT-CARE
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ESFOT-CARE` DEFAULT CHARACTER SET utf8 ;
USE `ESFOT-CARE` ;

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Productos` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Productos` (
  `codigo_prod` VARCHAR(15) NOT NULL,
  `nombre_prod` VARCHAR(100) NOT NULL,
  `gramaje_prod` VARCHAR(25) NULL,
  `presentacion_prod` VARCHAR(45) NULL,
  `categoria_prod` VARCHAR(45) NULL,
  `stock_prod` INT NOT NULL,
  `valcompra_prod` DECIMAL(4,2) NOT NULL,
  `valventa_prod` DECIMAL(4,2) NOT NULL,
  `iva_prod` TINYINT NOT NULL,
  PRIMARY KEY (`codigo_prod`),
  check (`iva_prod` in (1,0)),
  check (`categoria_prod` in ('Medicinas','Tratamientos y Salud','Cuidado Personal','Cuidado Infantil','Vitaminas y Suplementos')))
ENGINE = InnoDB;

insert into `ESFOT-CARE`.`Productos`
values
('ECUM6800','Ecumox ECU','250mg/5ml','Suspension','Medicinas',15,1.60,2.00,1),
('CUTA637S','Cutanit','5mg x 50mg','Unguento','Medicinas',2,20.75,21.25,1),
('BASS7012','Jabon Bassa','90g','Unica','Tratamientos y Salud',6,3.15,3.51,1),
('ENJU2364','Enjuage Bucal Cool Mint','500ml','Unica','Cuidado Personal',11,2.90,3.14,1),
('PEDI7961','Pediasure Triplesure Chocolate en polvo','400g','Unica','Cuidado Infantil',4,19.45,20.79,1),
('DENS6654','Densibone','1500mg x 300UI','Tabletas','Vitaminas y Suplementos',6,11.56,12.95,1),
('MASC9068','Mascarilla Quirurgica Descartable',null,'Unica','Tratamientos y Salud',50,0.06,0.15,0),
('NOTU4535','Notusin','100mg','Jarabe','Cuidado Infantil',8,6.48,7.00,1);

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Administradores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Administradores` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Administradores` (
  `codigo_admin` VARCHAR(45) NOT NULL,
  `nombre_admin` VARCHAR(45) NOT NULL,
  `apellido_admin` VARCHAR(45) NOT NULL,
  `ci_admin` VARCHAR(10) NOT NULL,
  `telefono_admin` VARCHAR(10) NULL,
  `email_admin` VARCHAR(80) NOT NULL,
  `direccion_admin` VARCHAR(45) NULL,
  `password_admin` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`codigo_admin`))
ENGINE = InnoDB;

/*
insert into `ESFOT-CARE`.`Administradores`
values
('R8G613','Rayan','García','1700997430','0948542047','rayan@gmail.com','Lumbisi','8vx61l'),
('L4X315','Lorena','Xu','1701147670','0957310021','lorexu@gmail.com','La Primavera','ih35dn');
-- ('G6M486','Gemma','Cantero','1711806498','0977107932','gemma@gmail.com','Vicentina','s9ba6x'),
-- ('M2S301','Melany','Sangucho','1753650389','0996364236','melany01-03@hotmail.com','Monjas','gd9d16'),
-- ('V9N112','Vanessa','Navas','1760347403','0977359178','nessa@hotmail.com','El Tejar','lj8sa2');
*/

-- insert usando hash para proteccion de contraseñas
insert into `ESFOT-CARE`.`Administradores`
values
('R8G613','Rayan','García','1700997430','0948542047','rayan@gmail.com','Lumbisi',sha2('8vx61l',256)),
('L4X315','Lorena','Xu','1701147670','0957310021','lorexu@gmail.com','La Primavera',sha2('ih35dn',256));

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Cajeros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Cajeros` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Cajeros` (
  `codigo_caj` VARCHAR(45) NOT NULL,
  `nombre_caj` VARCHAR(45) NOT NULL,
  `apellido_caj` VARCHAR(45) NOT NULL,
  `ci_caj` VARCHAR(10) NOT NULL,
  `telefono_caj` VARCHAR(10) NULL,
  `email_caj` VARCHAR(80) NULL,
  `direccion_caj` VARCHAR(100) NULL,
  `password_caj` VARCHAR(64) NOT NULL,
  `Administradores_codigo_admin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_caj`),
  CONSTRAINT `fk_Cajeros_Administradores1`
    FOREIGN KEY (`Administradores_codigo_admin`)
    REFERENCES `ESFOT-CARE`.`Administradores` (`codigo_admin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cajeros_Administradores1_idx` ON `ESFOT-CARE`.`Cajeros` (`Administradores_codigo_admin` ASC) VISIBLE;

/*
insert into `ESFOT-CARE`.`Cajeros`
values
('I1V658','Ines','Vilar','1788274926','0958861495','ines@hotmail.com','Miravalle','d35sd','L4X315'),
('G2S156','Graciela','Sastre','1719858499','0960133309','graciela@hotmail.com','Villa Vega','8hd6h','R8G613'),
('J3F186','Javier','Ferre','1787163923','0986103085','javi@gmail.com','El Arenal','86tr6','L4X315'),
('P4S135','Paola','Suarez','1784380830','0979696941','pao@gmail.com','La Viña','jyt35','R8G613'),
('D5S251','David','Gaspar','1710837469','0994701543','davo@hotmail.com','La Armenia','95hd5a','R8G613');
*/

-- insert usando hash para proteccion de contraseñas sha2('8vx61l',256) 
insert into `ESFOT-CARE`.`Cajeros`
values
('I1V658','Ines','Vilar','1788274926','0958861495','ines@hotmail.com','Miravalle',sha2('d35sd',256),'L4X315'),
('G2S156','Graciela','Sastre','1719858499','0960133309','graciela@hotmail.com','Villa Vega',sha2('8hd6h',256),'R8G613'),
('J3F186','Javier','Ferre','1787163923','0986103085','javi@gmail.com','El Arenal',sha2('86tr6',256),'L4X315'),
('P4S135','Paola','Suarez','1784380830','0979696941','pao@gmail.com','La Viña',sha2('jyt35',256),'R8G613'),
('D5S251','David','Gaspar','1710837469','0994701543','davo@hotmail.com','La Armenia',sha2('95hd5a',256),'R8G613');

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Clientes` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Clientes` (
  `ci_cli` VARCHAR(13) NOT NULL,
  `nombre_cli` VARCHAR(45) NOT NULL,
  `apellido_cli` VARCHAR(45) NOT NULL,
  `telefono_cli` VARCHAR(10) NULL,
  `email_cli` VARCHAR(80) NOT NULL,
  `direccion_cli` VARCHAR(100) NULL,
  PRIMARY KEY (`ci_cli`))
ENGINE = InnoDB;

insert into `ESFOT-CARE`.`Clientes`
values
('1785071533','Melany','Sangucho','0953832886','melany01-03@hotmail.com','Monjas'),
('0984531598','Maria','Paredes','0996512513','melany03.02.01@gmail.com','Quitumbe');

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Cabecera_Fac`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Cabecera_Fac` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Cabecera_Fac` (
  `num_factura` INT auto_increment NOT NULL,
  `Clientes_ci_cli` VARCHAR(13) NOT NULL,
  `fecha_emision` DATE NOT NULL,
  `Cajeros_codigo_caj` VARCHAR(45) NOT NULL,
  `subtotal_fac` DECIMAL(6,2) NULL,
  `iva_fac` DECIMAL(6,2) NULL,
  `descuento_fac` DECIMAL(6,2) NULL,
  `total_pagar` DECIMAL(8,2) NULL,
  `metodo_pago` VARCHAR(45) NULL,
  check (`metodo_pago` in ('Efectivo','Tarjeta')),
  PRIMARY KEY (`num_factura`),
  CONSTRAINT `fk_Cabecera_Fac_Cajeros1`
    FOREIGN KEY (`Cajeros_codigo_caj`)
    REFERENCES `ESFOT-CARE`.`Cajeros` (`codigo_caj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cabecera_Fac_Clientes1`
    FOREIGN KEY (`Clientes_ci_cli`)
    REFERENCES `ESFOT-CARE`.`Clientes` (`ci_cli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Cabecera_Fac_Cajeros1_idx` ON `ESFOT-CARE`.`Cabecera_Fac` (`Cajeros_codigo_caj` ASC) VISIBLE;

CREATE INDEX `fk_Cabecera_Fac_Clientes1_idx` ON `ESFOT-CARE`.`Cabecera_Fac` (`Clientes_ci_cli` ASC) VISIBLE;

insert into `ESFOT-CARE`.`Cabecera_Fac` (Clientes_ci_cli,fecha_emision,Cajeros_codigo_caj,metodo_pago)
values
('1785071533','2023-08-16','I1V658','Efectivo'),
('0984531598','2023-08-17','D5S251','Tarjeta');

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Detalle_Fac`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Detalle_Fac` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Detalle_Fac` (
  `codigo_det` INT auto_increment NOT NULL,
  `Cabecera_Fac_num_factura` INT NOT NULL,
  `Productos_codigo_prod` VARCHAR(15) NOT NULL,
  `cantidad` INT NOT NULL,
  `valor_venta` DECIMAL(6,2) NULL,
  `total_det` DECIMAL(6,2) NULL,
  PRIMARY KEY (`codigo_det`),
  CONSTRAINT `fk_Detalle_Fac_Productos1`
    FOREIGN KEY (`Productos_codigo_prod`)
    REFERENCES `ESFOT-CARE`.`Productos` (`codigo_prod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Fac_Cabecera_Fac1`
    FOREIGN KEY (`Cabecera_Fac_num_factura`)
    REFERENCES `ESFOT-CARE`.`Cabecera_Fac` (`num_factura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Detalle_Fac_Productos1_idx` ON `ESFOT-CARE`.`Detalle_Fac` (`Productos_codigo_prod` ASC) VISIBLE;

CREATE INDEX `fk_Detalle_Fac_Cabecera_Fac1_idx` ON `ESFOT-CARE`.`Detalle_Fac` (`Cabecera_Fac_num_factura` ASC) VISIBLE;

insert into `ESFOT-CARE`.`Detalle_Fac`(Cabecera_Fac_num_factura,Productos_codigo_prod,cantidad)
values
(1,'NOTU4535',1),
(1,'MASC9068',10),
(2,'DENS6654',1);

-- -----------------------------------------------------
-- Table `ESFOT-CARE`.`Administradores_has_Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ESFOT-CARE`.`Administradores_has_Productos` ;

CREATE TABLE IF NOT EXISTS `ESFOT-CARE`.`Administradores_has_Productos` (
  `Administradores_codigo_admin` VARCHAR(45) NOT NULL,
  `Productos_codigo_prod` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`Administradores_codigo_admin`, `Productos_codigo_prod`),
  CONSTRAINT `fk_Administradores_has_Productos_Administradores1`
    FOREIGN KEY (`Administradores_codigo_admin`)
    REFERENCES `ESFOT-CARE`.`Administradores` (`codigo_admin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Administradores_has_Productos_Productos1`
    FOREIGN KEY (`Productos_codigo_prod`)
    REFERENCES `ESFOT-CARE`.`Productos` (`codigo_prod`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Administradores_has_Productos_Productos1_idx` ON `ESFOT-CARE`.`Administradores_has_Productos` (`Productos_codigo_prod` ASC) VISIBLE;

CREATE INDEX `fk_Administradores_has_Productos_Administradores1_idx` ON `ESFOT-CARE`.`Administradores_has_Productos` (`Administradores_codigo_admin` ASC) VISIBLE;

insert into `ESFOT-CARE`.`Administradores_has_Productos`
values
('M2S301','ECUM6800'),
('R8G613','BASS7012');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

select * from productos;
select * from administradores;
select * from cajeros;
select * from clientes;
select * from cabecera_fac;
select * from detalle_fac;
select * from administradores_has_productos;
