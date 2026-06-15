CREATE TABLE ordenes (
    id              BIGINT         NOT NULL AUTO_INCREMENT,
    usuario_id      BIGINT         NOT NULL,
    total           DECIMAL(10, 2) NOT NULL,
    estado          VARCHAR(20)    NOT NULL DEFAULT 'PENDIENTE',
    fecha_creacion  DATETIME       NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX idx_ordenes_usuario (usuario_id)
);
