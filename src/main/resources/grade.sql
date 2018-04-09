--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;

CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `code` varchar(10) NOT NULL DEFAULT '0',
  `nbHeuresBase` decimal(50, 2) NOT NULL DEFAULT '0',
  `tauxBase` decimal(50, 2) NOT NULL DEFAULT '0'
);