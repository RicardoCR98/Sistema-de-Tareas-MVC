Script Xampp Database: 
```sql
-- Crear base de datos
CREATE DATABASE IF NOT EXISTS gestorpersonasstmvc;
USE gestorpersonasstmvc;

-- Tabla de personas
CREATE TABLE IF NOT EXISTS persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    esadmin BOOLEAN NOT NULL DEFAULT 0
);

-- Tabla de tareas
CREATE TABLE IF NOT EXISTS tarea (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    idresponsable INT NOT NULL,
    estado INT NOT NULL,
    FOREIGN KEY (idresponsable) REFERENCES persona(id) ON DELETE CASCADE
);

-- Datos de ejemplo para la tabla persona
INSERT INTO persona (nombre, password, esadmin) VALUES
('Luis', 'Luis123', true),
('Pepe', 'Pepe123', false),
('Maria', 'Maria123', false),
('Mariana', 'Mariana123', false);

-- Datos de ejemplo para la tabla tarea
INSERT INTO tarea (nombre, idresponsable, estado) VALUES
('Pagar salarios', 1, 1),
('Becas por excelencia', 3, 1),
('Pagos 1', 1, 1),
('Pagos 2', 1, 1),
('Pagos 3', 1, 1),
('Becas 2', 3, 1),
('Becas 3', 3, 1);

-- Consultas de ejemplo
SELECT * FROM persona;
SELECT * FROM tarea;

```
