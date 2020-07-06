DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS employee;

CREATE TABLE department(
    id int PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

CREATE TABLE employee(
    id VARCHAR(250) PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    birthday date NOT NULL,
    phone VARCHAR(12) NOT NULL,
    email VARCHAR(250) NOT NULL,
    id_dep int NOT NULL,
CONSTRAINT FK_EM_DE FOREIGN KEY(id_dep) REFERENCES department(id) ON DELETE CASCADE
);

INSERT INTO department (id, name) VALUES
    (1, 'phong ban 1'),
    (2, 'phong ban 2'),
    (3, 'phong ban 3'),
    (4, 'phong ban 4'),
    (5, 'phong ban 5'),
    (6, 'phong ban 6');

INSERT INTO employee (id, name, birthday, phone, email, id_dep) VALUES
    ('ep01', 'nhan vien 1', 19981106, '0123456781', 'ep01@gmail.com', 1),
    ('ep02', 'nhan vien 2', 19981006, '0123456782', 'ep02@gmail.com', 2),
    ('ep03', 'nhan vien 3', 19980906, '0123456783', 'ep03@gmail.com', 3),
    ('ep04', 'nhan vien 4', 19980806, '0123456784', 'ep04@gmail.com', 4),
    ('ep05', 'nhan vien 5', 19980606, '0123456785', 'ep05@gmail.com', 5),
    ('ep06', 'nhan vien 6', 19980306, '0123456786', 'ep06@gmail.com', 6);
