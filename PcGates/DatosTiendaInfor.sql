
insert into Clientes values ('APampin', 'Alberto Pampin', 'ap', 'Bar de Arriba', 'alberto.pampin@rai.usc.es', '678 98 09 12');
insert into Clientes values ('ASande', 'Antonio Sande', 'as' ,'Avda de Villagarcia', 'antonio.sande@rai.usc.es', '671 23 45');
insert into Clientes values ('FSaa', 'Francisco Saa','fs', 'Monte da Condesa', 'fran.saa@rai.usc.es', '654 34 23 12');
insert into Clientes values ('DSoler', 'David Soler', 'ds', 'Rua da Rosa', 'david.soler@rai.usc.es', '673 45 67 98');
insert into Clientes values ('MVentoso','Miguel Ventoso', 'mv', 'Ruta', 'miguel.ventoso@rai.usc.es', '689 93 45 12');
insert into Clientes values ('GVilarino', 'Gabriel Vilarino', 'gv', 'Rua de San Clemente', 'gv69@actimel.com', '689 90 67 12');


insert into Empleados values ('46092244Z', 'Alberto Pampin', 'ap', 'Bar de Arriba', 'alberto.pampin@rai.usc.es', '678 98 09 12', '2000', 'FALSE', 'FALSE', 'TRUE');
insert into Empleados values ('1234568X', 'Antonio Sande', 'as' ,'Avda de Villagarcia', 'antonio.sande@rai.usc.es', '671 23 45', '2000',  'TRUE', 'TRUE', 'FALSE');
insert into Empleados values ('98765432Y', 'Francisco Saa','fs', 'Monte da Condesa', 'fran.saa@rai.usc.es', '654 34 23 12', '2000',  'TRUE', 'TRUE', 'FALSE');
insert into Empleados values ('45362789W', 'David Soler', 'ds', 'Rua da Rosa', 'david.soler@rai.usc.es', '673 45 67 98', '2000', 'TRUE', 'TRUE', 'FALSE');
insert into Empleados values ('09890981V','Miguel Ventoso', 'mv', 'Rua de Alfredo', 'miguel.ventoso@rai.usc.es', '689 93 45 12', '2000',  'TRUE', 'TRUE', 'FALSE');
insert into Empleados values ('19827364T', 'Gabriel Vilarino', 'gv', 'Rua de San Clemente', 'gv69@actimel.com', '689 90 67 12', '2000',  'TRUE', 'FALSE', 'FALSE');


insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);
insert into PCs(id) values (DEFAULT);

insert into EjemplaresVenta (pc, nombre, precio, fechaCreacion, cliente, empleado, fechaCompraPc) values ('1', 'XiaomiPro', '1500', '2018-11-11', 'ASande', '19827364T',  '2018-11-12');
insert into EjemplaresVenta (pc, nombre, precio, fechaCreacion, cliente, empleado, fechaCompraPc) values ('2', 'MacPro', '9500', '2018-11-21', 'GVilarino', '45362789W',  '2018-11-22');
insert into EjemplaresVenta (pc, nombre, precio, fechaCreacion) values ('3', 'HPPerron', '2500', '2018-11-21');
insert into AReparar (pc, descripcion, cliente, fechaIngreso, empleadoIngreso) values ('4','MorteDePC', 'MVentoso', '2018-11-21', '19827364T');
insert into AReparar (pc, descripcion, cliente, fechaIngreso, fechaRetirada, empleadoIngreso, empleadoRetirada) values ('5','MorteDePC', 'DSoler', '2019-01-21', '2019-02-21', '45362789W',  '1234568X');
insert into AReparar (pc, descripcion, cliente, fechaIngreso, empleadoIngreso) values ('7','Funciona mal', 'DSoler', '2019-01-21', '45362789W');


--GPUs
insert into Componentes values ('GTX_2080', 'ASUS', '1200', 'GPU ideal para el Fornite');
insert into Componentes values ('GTX_2070', 'MSI', '1000', 'GPU ideal para el Minecraft');
insert into Componentes values ('GTX_1080', 'NVIDIA', '800', 'GPU ideal para COGA');

insert into GPUs values ('GTX_2080', '88', '1200', '12');
insert into GPUs values ('GTX_2070', '68', '900', '12');
insert into GPUs values ('GTX_1080', '18', '100', '12');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_2080', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_2080', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_2080', '2019-01-11');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_2070', '2019-01-11');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_2070', '2019-01-13');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GTX_1080', '2019-01-11');
insert into EjemplaresComponente (componente, cliente, empleado, fechaTiendaCompraEjemplar, fechaClienteCompraEjemplar) values ( 'GTX_2080', 'ASande', '1234568X', '2019-01-21', '2019-02-21');
insert into EjemplaresComponente (componente, cliente, empleado, fechaTiendaCompraEjemplar, fechaClienteCompraEjemplar) values ( 'GTX_2070', 'FSaa', '45362789W', '2019-01-11', '2019-02-01');

--CPUs
insert into Componentes values ('i3-8100', 'Intel', '119.99', 'CPU versatil, calidad-precio optimos');
insert into CPUs values ('i3-8100', '1150', '4', '8', '2.3','65.2', 'Coffee Lake');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i3-8100', '2018-10-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i3-8100', '2018-01-23');


insert into Componentes values ('i5-8400', 'Intel', '193.99', 'CPU versatil, calidad-precio optimos');
insert into CPUs values ('i5-8400', '1151', '6', '12', '2.8','85.2', 'Coffee Lake');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i5-8400', '2018-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i5-8400', '2018-11-23');


insert into Componentes values ('i7-7700K', 'Intel', '385.99', 'CPU de maxima velocidad');
insert into CPUs values ('i7-7700K', '1151', '6', '12', '4.2','91', 'Kaby Lake');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i7-7700K', '2018-04-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('i7-7700K', '2018-05-13');


insert into Componentes values ('Extreme i9-9980XE', 'Intel', '2099', 'CPU con el mayor rendimiento del mercado');
insert into CPUs values ('Extreme i9-9980XE', '2066', '18', '36', '3.0','170', 'Kaby Lake');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Extreme i9-9980XE', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Extreme i9-9980XE', '2019-04-13');


insert into Componentes values ('Ryzen5 2600', 'AMD', '185.99', 'CPU de alto rendimiento');
insert into CPUs values ('Ryzen5 2600', 'AM3', '4', '8', '3.4','61', 'Zen');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Ryzen5 2600', '2019-07-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Ryzen5 2600', '2019-02-13');


insert into Componentes values ('Ryzen7 1800X', 'AMD', '385.99', 'CPU de alto rendimiento');
insert into CPUs values ('Ryzen7 1800X', 'FM2', '8', '16', '3.6','81', 'Zen');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Ryzen7 1800X', '2019-04-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Ryzen7 1800X', '2019-05-13');


insert into Componentes values ('Threadripper 2990WX', 'AMD', '1850.99', 'CPU mas potente del mercado');
insert into CPUs values ('Threadripper 2990WX', 'AMTR4', '32', '64', '3.2','250', 'Zen');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Threadripper 2990WX', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Threadripper 2990WX', '2019-04-13');

--Placas Base
insert into Componentes values ('GA-B360M DS3H', 'Gigabyte', '75.96', 'Placa base con gran relacion calidad-precio');
insert into PlacasBase values ('GA-B360M DS3H', 'Intel B360', '12.23');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GA-B360M DS3H', '2018-07-03');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('GA-B360M DS3H', '2019-01-13');


insert into Componentes values ('Z370-A Pro', 'MSI', '105.96', 'Placa base con luces LED en color blanco.');
insert into PlacasBase values ('Z370-A Pro', 'Intel Z370 Chipset', '12.23');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z370-A Pro', '2019-06-11');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z370-A Pro', '2019-03-13');


insert into Componentes values ('X399 AORUS Pro', 'Gigabyte', '304.56', 'Placa base para productividad del mundo real o entretenimiento de VR');
insert into PlacasBase values ('X399 AORUS Pro', 'AMD X399', '10.23');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('X399 AORUS Pro', '2018-02-14');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('X399 AORUS Pro', '2019-04-13');


insert into Componentes values ('Z10PE-D16 WS', 'ASUS', '494.56', 'Placa base con potencia gráfica suprema con IPMI 2.0');
insert into PlacasBase values ('Z10PE-D16 WS', 'Intel C612 PCH', '12.36');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z10PE-D16 WS', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z10PE-D16 WS', '2017-01-13');


insert into Componentes values ('Z390 AORUS Xtreme', 'Gigabyte', '1147.99', 'La nueva definición de placa base');
insert into PlacasBase values ('Z390 AORUS Xtreme', 'Intel Z390 Express', '16.33');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z390 AORUS Xtreme', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Z390 AORUS Xtreme', '2017-11-23');


--RAMs
insert into Componentes values ('Crucial 2400', 'Crucial', '52.99', 'RAM optimizada para la siguiente gen de procesadores');
insert into RAMs values ('Crucial 2400', 'DDR4', '8', '2400', 'Sobremesa');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Crucial 2400', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Crucial 2400', '2017-01-13');


insert into Componentes values ('G.Skill Trident Z', 'G.Skill', '149.99', 'RAM que ofrece soluciones para un rendimiento increíble');
insert into RAMs values ('G.Skill Trident Z', 'DDR4', '16', '3200', 'Sobremesa');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('G.Skill Trident Z', '2018-12-29');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('G.Skill Trident Z', '2018-01-03');


insert into Componentes values ('Vengeance LPX', 'Corsair', '95.99', 'RAM diseñada para overclocking de alto rendimiento');
insert into RAMs values ('Vengeance LPX', 'DDR4', '16', '2400', 'Sobremesa');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Vengeance LPX', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Vengeance LPX', '2017-11-23');


insert into Componentes values ('Predator RGB', 'HyperX', '389.99', 'RAM diseñada para overclocking de alto rendimiento');
insert into RAMs values ('Predator RGB', 'DDR4', '32', '2400', 'Sobremesa');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Predator RGB', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Predator RGB', '2018-01-13');
	

insert into Componentes values ('Vengeance RGB PRO', 'Corsair', '959.89', 'La memoria overclockeada de la serie DDR4 ilumina su PC con una fascinante iluminación RGB ');
insert into RAMs values ('Vengeance RGB PRO', 'DDR4', '64', '3600', 'Sobremesa');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Vengeance RGB PRO', '2019-03-02');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('Vengeance RGB PRO', '2018-11-23');


--Discos Duros
insert into Componentes values ('A400', 'Kingston', '30.45', 'SSD de maxima velocidad');
insert into DiscosDuros values ('A400', 'SSD', '120', '500');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('A400', '2019-03-19');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('A400', '2019-01-13');
	

insert into Componentes values ('MG07ACA14TE', 'Toshiba', '669.69', 'HDD de gran capacidad');
insert into DiscosDuros values ('MG07ACA14TE', 'HDD', '14000', '220');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('MG07ACA14TE', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('MG07ACA14TE', '2018-01-13');
	

insert into Componentes values ('860 EVO Basic', 'Samsung', '85.88', 'SSD de maxima velocidad');
insert into DiscosDuros values ('860 EVO Basic', 'SSD', '500', '550');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('860 EVO Basic', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('860 EVO Basic', '2018-01-13');


insert into Componentes values ('BarraCuda', 'Seagate', '65.70', 'HDD Impresionante versatilidad. Fiabilidad inigualable');
insert into DiscosDuros values ('BarraCuda', 'HDD', '2000', '195');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('BarraCuda', '2019-02-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('BarraCuda', '2018-05-16');


insert into Componentes values ('3D Nand', 'WD Blue', '78.90', 'SSD preparada para sus necesidades informáticas de alto rendimiento,');
insert into DiscosDuros values ('3D Nand', 'SSD', '500', '550');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('3D Nand', '2019-03-15');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('3D Nand', '2019-01-03');


insert into Componentes values ('P300', 'Toshiba', '45.80', 'HDD de maxima calidad');
insert into DiscosDuros values ('P300', 'HDD', '1000', '200');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('P300', '2019-01-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('P300', '2018-01-13');


insert into Componentes values ('PlusV3', 'SanDisk', '194.90', 'SSD de maxima velocidad');
insert into DiscosDuros values ('PlusV3', 'SSD', '1000', '620');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('PlusV3', '2019-02-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('PlusV3', '2018-09-17');


--Alimentacion
insert into Componentes values ('VS650', 'Corsair', '50.80', 'Cuenta con la compatibilidad y la fiabilidad que han hecho célebres a CORSAIR');
insert into Alimentacion values ('VS650','650', 'TRUE');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('VS650', '2019-03-03');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('VS650', '2017-01-08');


insert into Componentes values ('RM750X V2', 'Corsair', '120.90', 'Cuenta con la compatibilidad y la fiabilidad que han hecho célebres a CORSAIR');
insert into Alimentacion values ('RM750X V2','750', 'TRUE');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('RM750X V2', '2019-03-11');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('RM750X V2', '2018-06-03');


insert into Componentes values ('MasterWatt 750 V2', 'Cooler Master', '80.90', 'Experimente un funcionamiento sin ruido en las cargas normales de PC con una producción de 15%');
insert into Alimentacion values ('MasterWatt 750 V2','750', 'TRUE');

insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('MasterWatt 750 V2', '2019-03-21');
insert into EjemplaresComponente (componente, fechaTiendaCompraEjemplar) values ('MasterWatt 750 V2', '2018-05-19');


--Refrigeracion
insert into Componentes values ('AndresFrioniesta', 'Kalise', '50', 'Refrigeracion de maxima calidad');
insert into Refrigeracion values ('AndresFrioniesta','CPU', '70');

insert into Componentes values ('XMouseKiller300', 'Razer', '50', 'Raton ultra gaming');
insert into Perifericos values ('XMouseKiller300','Raton');

insert into Componentes values ('MaxiKeyboard', 'Razer', '150', 'Teclado ultra gaming');
insert into Perifericos values ('MaxiKeyboard','Teclado');

insert into Componentes values ('MaxiKeyboardPro', 'Razer', '350', 'Teclado ultra gaming');
insert into Perifericos values ('MaxiKeyboardPro','Teclado');

insert into Componentes values ('AlfombraLolitoFDEZ', 'Razer', '350', 'Alfombrilla ultra gaming');
insert into Perifericos values ('AlfombraLolitoFDEZ','Alfombrilla');


insert into Personalizados (pc, nombre, cliente, placaBase, cpu, gpu, numGPUs, ram, numRAMs, discoDuro1, numDiscoDuro1, alimentacion, refrigeracion1,
			periferico1, periferico2, periferico3) values ('6','BeastModeUltraPC', 'APampin', 'Z390 AORUS Xtreme','Threadripper 2990WX','GTX_2080','4','Vengeance RGB PRO', '4','PlusV3',
			'4','MasterWatt 750 V2','AndresFrioniesta', 'XMouseKiller300',  'MaxiKeyboardPro', 'AlfombraLolitoFDEZ');


insert into Reparar values ('5', '98765432Y', 'GTX_2070', '2019-03-21', '2350');
insert into Reparar values ('4', '09890981V', 'GTX_2070', '2019-03-21', '2350');
















