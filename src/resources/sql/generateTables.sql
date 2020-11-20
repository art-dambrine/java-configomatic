CREATE TABLE `ordinateur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `processeur` int,
  `carte_mere` int,
  `memoire` int,
  `carte_graphique` int,
  `disque_dur` int,
  `prix` double,
  `vendu` boolean,
  `datetime_creation` datetime,
  `datetime_vendu` datetime
);

CREATE TABLE `processeur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `prix` double,
  `nombre_coeurs` int,
  `fabriquant` int
);

CREATE TABLE `carte_mere` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `prix` double,
  `compatibilite_usbc` boolean,
  `port_pci_express` boolean,
  `fabriquant` int
);

CREATE TABLE `carte_graphique` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `prix` double,
  `memoire_graphique_go` int,
  `puissance_tflops` double,
  `fabriquant` int
);

CREATE TABLE `disque_dur` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `prix` double,
  `capacite_go` int,
  `fabriquant` int
);

CREATE TABLE `memoire` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255),
  `prix` double,
  `capacite_go` int,
  `type` varchar(255),
  `fabriquant` int
);

CREATE TABLE `fabriquant` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `nom` varchar(255)
);

ALTER TABLE `disque_dur` ADD FOREIGN KEY (`fabriquant`) REFERENCES `fabriquant` (`id`);

ALTER TABLE `carte_graphique` ADD FOREIGN KEY (`fabriquant`) REFERENCES `fabriquant` (`id`);

ALTER TABLE `memoire` ADD FOREIGN KEY (`fabriquant`) REFERENCES `fabriquant` (`id`);

ALTER TABLE `processeur` ADD FOREIGN KEY (`fabriquant`) REFERENCES `fabriquant` (`id`);

ALTER TABLE `carte_mere` ADD FOREIGN KEY (`fabriquant`) REFERENCES `fabriquant` (`id`);

ALTER TABLE `ordinateur` ADD FOREIGN KEY (`carte_mere`) REFERENCES `carte_mere` (`id`);

ALTER TABLE `ordinateur` ADD FOREIGN KEY (`processeur`) REFERENCES `processeur` (`id`);

ALTER TABLE `ordinateur` ADD FOREIGN KEY (`memoire`) REFERENCES `memoire` (`id`);

ALTER TABLE `ordinateur` ADD FOREIGN KEY (`carte_graphique`) REFERENCES `carte_graphique` (`id`);

ALTER TABLE `ordinateur` ADD FOREIGN KEY (`disque_dur`) REFERENCES `disque_dur` (`id`);
