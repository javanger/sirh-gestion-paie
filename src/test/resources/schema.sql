      


-- Export de la structure de la table sirh_paie. grade
DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `code` varchar(50) NOT NULL DEFAULT '0',
  `nb_heures_base` decimal(10,0) NOT NULL DEFAULT '0',
  `taux_base` decimal(10,0) NOT NULL DEFAULT '0'
);
