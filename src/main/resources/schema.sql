CREATE TABLE 'services'.'endereco' (
  'id' INT NOT NULL AUTO_INCREMENT,
  'rua' VARCHAR(250) NOT NULL,
  'cep' VARCHAR(8) NOT NULL,
  'cidade' VARCHAR(250) NULL,
  'estado' VARCHAR(50) NOT NULL,
  'numero' VARCHAR(30) NOT NULL,
  'bairro' VARCHAR(200) NULL,
  'complemento' VARCHAR(200) NULL,
  PRIMARY KEY ('id'));