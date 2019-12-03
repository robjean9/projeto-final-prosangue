CREATE TABLE `PROSANGUE`.`Doador` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `endereco` VARCHAR(200) NULL,
  `nascimento` DATE NOT NULL,
  `nome_pai` VARCHAR(100) NULL,
  `nome_mae` VARCHAR(100) NULL,
  `CPF` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `CPF_UNIQUE` (`CPF` ASC) VISIBLE);

CREATE TABLE `PROSANGUE`.`Doacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data_hora` DATETIME NOT NULL,
  `doador_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `doador_id`
    FOREIGN KEY (`doador_id`)
    REFERENCES `PROSANGUE`.`Doador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `PROSANGUE`.`Tipo_exame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `PROSANGUE`.`Exame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `resultado` VARCHAR(50) NOT NULL,
  `doacao_id` INT NOT NULL,
  `tipo_exame_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `doacao_id`
    FOREIGN KEY (`doacao_id`)
    REFERENCES `PROSANGUE`.`Doacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tipo_exame_id`
    FOREIGN KEY (`tipo_exame_id`)
    REFERENCES `PROSANGUE`.`Tipo_exame` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `PROSANGUE`.`Entrevista` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `doacao_id` INT NOT NULL,
  `data_hora` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `entrevista_doacao`
    FOREIGN KEY (`doacao_id`)
    REFERENCES `PROSANGUE`.`Doacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `PROSANGUE`.`Questao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `questao` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `PROSANGUE`.`Entrevista_Questao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `entrevista_id` INT NOT NULL,
  `questao_id` INT NOT NULL,
  `resposta` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `entrevista_questao_questao_idx` (`questao_id` ASC) VISIBLE,
  INDEX `entrevista_questao_entrevista_idx` (`entrevista_id` ASC) VISIBLE,
  CONSTRAINT `entrevista_questao_questao`
    FOREIGN KEY (`questao_id`)
    REFERENCES `PROSANGUE`.`Questao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `entrevista_questao_entrevista`
    FOREIGN KEY (`entrevista_id`)
    REFERENCES `PROSANGUE`.`Entrevista` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `PROSANGUE`.`Usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `PROSANGUE`.`Consulta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `doador_id` INT NOT NULL,
  `diagnostico` LONGTEXT NOT NULL,
  `data_hora` DATETIME NOT NULL,
  `usuario_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `consulta_doador_idx` (`doador_id` ASC) VISIBLE,
  INDEX `consulta_usuario_idx` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `consulta_doador`
    FOREIGN KEY (`doador_id`)
    REFERENCES `PROSANGUE`.`Doador` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `consulta_usuario`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `PROSANGUE`.`Usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);










