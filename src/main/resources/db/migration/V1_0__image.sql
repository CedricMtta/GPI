CREATE TABLE image (
	id BIGINT AUTO_INCREMENT,
	file BLOB,
	titre VARCHAR(255),
	id_utilisateur BIGINT,
	date DATE,
	PRIMARY KEY(id)
)
