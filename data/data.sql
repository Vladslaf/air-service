INSERT INTO air_companies (company_type, founded_at, name)
VALUES ('BUSINESS', '1985-05-05', 'SpaceX');
INSERT INTO air_companies (company_type, founded_at, name)
VALUES ('HOLDING', '1996-05-05', 'Cosmos');
INSERT INTO airplanes (factory_serial_number, name, air_company_id, number_of_flights,
                       flight_distance, fuel_capacity, type, created_at)
VALUES ('123654 123', 'Congo', '1','0', '3000', '2000','JET', '2015-05-05');
INSERT INTO airplanes (factory_serial_number, name, air_company_id, number_of_flights,
                       flight_distance, fuel_capacity, type, created_at)
VALUES ('123654 12398', 'Tiger', '2','15', '2000', '1000','REGIONAL', '2003-05-05');
INSERT INTO flights (flight_status, airplane_id, air_company_id, departure_country,
                     destination_country, distance,
                     estimated_flight_time, started_at, ended_at, delay_started_at, created_at)
VALUES ('COMPLETED', '1', '1','Egipt', 'Ephiopia', '1500','180', '2022-05-05T13:34:00.000',
        '2022-05-05T19:13:00.000', null, '2022-04-05T23:15:00.000');
INSERT INTO flights (flight_status, airplane_id, air_company_id, departure_country,
                     destination_country, distance,
                     estimated_flight_time, started_at, ended_at, delay_started_at, created_at)
VALUES ('ACTIVE', '2', '2','Israel', 'Chili', '7000','430', SUBTIME(CURRENT_TIMESTAMP, '25:0:0.000000'),
        null, null, '2022-04-05T23:15:00.000');
