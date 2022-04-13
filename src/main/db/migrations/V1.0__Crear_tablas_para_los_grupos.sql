CREATE TABLE grupo
(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    nombre varchar(1000) DEFAULT NULL,
    total decimal(12,2) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE grupo_miembros
(
    grupo_id bigint(20) NOT NULL,
    miembro varchar(255) DEFAULT NULL,
    KEY grupo_miembros_grupo_id (grupo_id),
    CONSTRAINT grupo_miembros_grupo_id FOREIGN KEY (grupo_id) REFERENCES grupo (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;