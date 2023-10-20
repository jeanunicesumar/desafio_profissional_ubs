INSERT INTO address (city, district, `number`, street_address, uf, zip_code) VALUES
  ('Maringá', 'Jardim Bertioga', '123A', 'Rua Universo', 'PR', '75806-375'),
  ('Maringá', 'Outro Bairro', '456B', 'Rua Outra Rua', 'PR', '75806-123'),
  ('Maringá', 'Outro Bairro 2', '457B', 'Rua Outra Rua 2', 'PR', '75806-124'),
  ('Maringá', 'Outro Bairro 4', '458B', 'Rua Outra Rua 2', 'PR', '75806-125'),
	('Maringá', 'Outro Bairro 5', '459B', 'Rua Outra Rua 3', 'PR', '75806-225'),
   ('Maringá', 'Outro Bairro 6', '460B', 'Rua Outra Rua 4', 'PR', '75806-325');
     
INSERT INTO specialty (description) VALUES
  ('Cardiologia'),
  ('Dermatologia'),
  ('Ortopedia'),
  ('Pediatria'),
  ('Oncologia');

INSERT INTO ubs (`name`, address_id) VALUES
  ('UBS Maringá 1', 1),
  ('UBS Maringá 2', 2);
  
INSERT INTO person (`active`, birth_city, birth_date, birth_uf, cpf, ddd, email, father_name, gender, mother_name, `name`, `password`, phone, address_id, ubs_id)
VALUES
  (1, 'Maringá', '1980-05-10', 'PR', '12345678901', '41', 'person1@email.com', 'Pai 1', 1, 'Mãe 1', 'Person 1', 'senha123', '987654321', 1, 1),
  (1, 'Maringá', '1975-03-15', 'PR', '23456789012', '41', 'person2@email.com', 'Pai 2', 0, 'Mãe 2', 'Person 2', 'senha456', '876543210', 2, 2),
  (1, 'Maringá', '1975-03-16', 'PR', '23456789013', '41', 'person3@email.com', 'Pai 3', 1, 'Mãe 2', 'Person 3', 'senha456', '876543211', 3, 1),
  (1, 'Maringá', '1975-03-17', 'PR', '23456789014', '41', 'person4@email.com', 'Pai 4', 0, 'Mãe 2', 'Person 4', 'senha456', '876543211', 4, 2),
  (1, 'Maringá', '1975-03-18', 'PR', '23456789015', '41', 'person5@email.com', 'Pai 5', 1, 'Mãe 2', 'Person 5', 'senha456', '876543211', 5, 1),
  (1, 'Maringá', '1975-03-19', 'PR', '23456789016', '41', 'person6@email.com', 'Pai 6', 0, 'Mãe 2', 'Person 6', 'senha456', '876543211', 6, 2);

INSERT INTO medical_record (`date`, `description`) VALUES
  ('2023-01-10', 'Consulta de rotina para Paciente 1'),
  ('2023-02-15', 'Lesão na pele para Paciente 2'),
  ('2023-03-20', 'Consulta ortopédica para Paciente 2'),
  ('2023-04-25', 'Check-up para Paciente 1'),
  ('2023-05-30', 'Consulta pediátrica para Paciente 1');
  
INSERT INTO doctor (crm, id) VALUES
  (12345, 1),
  (54321, 2);
  
INSERT INTO patient (sus_code, id) VALUES
  (12345, 3),
  (54321, 4);
  
INSERT INTO admin (id) VALUES (5);

INSERT INTO doctor_specialty (doctor_id, specialty_id) VALUES
  (1, 1),
  (1, 3),
  (2, 2),
  (2, 4);

INSERT INTO appointment (`date`, end_time, start_time, `status`, doctor_id, medical_record_id, patient_id) VALUES
  ('2023-06-05', '2023-06-05 10:00:00', '2023-06-05 09:00:00', 1, 1, 1, 3),
  ('2023-06-10', '2023-06-10 14:30:00', '2023-06-10 13:30:00', 2, 2, 2, 3),
  ('2023-06-15', '2023-06-15 11:15:00', '2023-06-15 10:15:00', 0, 1, 3, 4),
  ('2023-06-20', '2023-06-20 16:45:00', '2023-06-20 15:45:00', 1, 2, 4, 4),
  ('2023-06-25', '2023-06-25 13:00:00', '2023-06-25 12:00:00', 2, 1, 5, 4);
  