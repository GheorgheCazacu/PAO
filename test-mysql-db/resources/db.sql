CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `cnp` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--- insert an user

INSERT INTO `store`.`users`
(
`username`,
`name`,
`date_of_birth`,
`cnp`)
VALUES
(
'seconduser',
'second user',
'2016-10-12',
'1234567890123');

