create table conversion (
                            id bigint not null auto_increment,
                            name varchar(255),
                            conversion_type varchar(255),
                            converter varchar(255),
                            source_unit varchar(255),
                            destination_unit varchar(255),
                            to_rate double precision,
                            from_rate double precision,
                            primary key (id)
) engine=InnoDB;

insert into conversion (name, conversion_type, converter, source_unit, destination_unit, to_rate, from_rate) values
('f to c', 'FORMULA', 'com.github.sechanakira.metrictoimperialconverter.persistence.service.fomula.FareinheitCelciusConverter', 'f', 'c', null, null);

insert into conversion (name, conversion_type, converter, source_unit, destination_unit, to_rate, from_rate) values
('cm to in', 'RATE', null, 'cm', 'in', 0.3937, 2.54);

insert into conversion (name, conversion_type, converter, source_unit, destination_unit, to_rate, from_rate) values
('m to ft', 'RATE', null, 'm', 'ft', 3.2808, 0.3048);

insert into conversion (name, conversion_type, converter, source_unit, destination_unit, to_rate, from_rate) values
('m to in', 'RATE', null, 'm', 'in', 39.37, 0.0254);

insert into conversion (name, conversion_type, converter, source_unit, destination_unit, to_rate, from_rate) values
('sq m to sq ft', 'RATE', null, 'm', 'in', 10.76, 0.0929);
