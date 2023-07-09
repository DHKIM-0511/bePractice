CREATE SCHEMA IF NOT EXISTS `ssafit_board` DEFAULT CHARACTER SET utf8mb4 ;
USE `ssafit_board`;

-- -----------------------------------------------------
-- Table `ssafit_board`.`Video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_board`.`Video` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `channel_name` VARCHAR(45) NOT NULL,
  `view_cnt` INT NOT NULL,
  `id` VARCHAR(45) NOT NULL,
  `img` VARCHAR(100) NULL,
  PRIMARY KEY (`seq`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ssafit_board`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_board`.`User` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `id` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL DEFAULT 'id',
  `email` VARCHAR(45) NOT NULL,
  `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
  `last_login` TIMESTAMP NULL,
  PRIMARY KEY (`seq`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ssafit_board`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_board`.`Review` (
  `seq` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `content` TEXT(1000) NOT NULL,
  `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
  `mod_date` TIMESTAMP NULL DEFAULT now(),
  `user_seq` INT NOT NULL,
  `video_seq` INT NOT NULL,
  PRIMARY KEY (`seq`),
  INDEX `fk_Review_User2_idx` (`user_seq` ASC) VISIBLE,
  INDEX `fk_Review_Video2_idx` (`video_seq` ASC) VISIBLE,
  CONSTRAINT `fk_Review_User2`
    FOREIGN KEY (`user_seq`)
    REFERENCES `ssafit_board`.`User` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Review_Video2`
    FOREIGN KEY (`video_seq`)
    REFERENCES `ssafit_board`.`Video` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ssafit_board`.`Favorite`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_board`.`Favorite` (
  `reg_date` TIMESTAMP NOT NULL DEFAULT now(),
  `user_seq` INT NOT NULL,
  `video_seq` INT NOT NULL,
  PRIMARY KEY (`user_seq`, `video_seq`),
  INDEX `fk_Favorite_User1_idx` (`user_seq` ASC) VISIBLE,
  INDEX `fk_Favorite_Video1_idx` (`video_seq` ASC) VISIBLE,
  CONSTRAINT `fk_Favorite_User1`
    FOREIGN KEY (`user_seq`)
    REFERENCES `ssafit_board`.`User` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Favorite_Video1`
    FOREIGN KEY (`video_seq`)
    REFERENCES `ssafit_board`.`Video` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `ssafit_board`.`Friend`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit_board`.`Friend` (
  `following_user_seq` INT NOT NULL,
  `followefriendr_user_seq` INT NOT NULL,
  PRIMARY KEY (`following_user_seq`, `follower_user_seq`),
  INDEX `fk_Friend_User1_idx` (`follower_user_seq` ASC) VISIBLE,
  INDEX `fk_Friend_User2_idx` (`following_user_seq` ASC) VISIBLE,
  CONSTRAINT `fk_Friend_User1`
    FOREIGN KEY (`follower_user_seq`)
    REFERENCES `ssafit_board`.`User` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Friend_User2`
    FOREIGN KEY (`following_user_seq`)
    REFERENCES `ssafit_board`.`User` (`seq`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;