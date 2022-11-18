DROP TABLE IF EXISTS `credit_card`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `purchase`;

CREATE SEQUENCE IF NOT EXISTS hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE `user` (
      `id` BIGINT NOT NULL PRIMARY KEY,
      `username` VARCHAR(50) NOT NULL,
      `password` VARCHAR(50) NOT NULL,
      `enabled` BOOLEAN NOT NULL
);

CREATE TABLE `credit_card` (
     `id` BIGINT NOT NULL PRIMARY KEY,
     `description` VARCHAR(50) NOT NULL,
     `last_numbers` INTEGER NULL,
     `user_id` BIGINT NOT NULL,
     FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);


CREATE TABLE `purchase`
(
    id                          BIGINT NOT NULL,
    description                 VARCHAR(255),
    amount                      DECIMAL,
    installments_quantity       BIGINT,
    purchase_date               date,
    invoice_first_payment_month date
);

delete from `user` where `username` = 'admin';
insert into `user` (`id`, `username`, `password`, `enabled`) values (1 , 'admin', '123456', true);