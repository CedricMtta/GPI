CREATE TABLE image (
	id INTEGER AUTO_INCREMENT,
	file BLOB,
	titre VARCHAR(255),
	id_utilisateur INTEGER,
	date DATE,
	PRIMARY KEY(id)
)
