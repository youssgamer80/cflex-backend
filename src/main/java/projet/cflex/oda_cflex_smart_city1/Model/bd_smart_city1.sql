-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 04 mai 2022 à 17:56
-- Version du serveur : 8.0.27
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bd_smart_city1`
--

-- --------------------------------------------------------

--
-- Structure de la table `appartenir`
--

DROP TABLE IF EXISTS `appartenir`;
CREATE TABLE IF NOT EXISTS `appartenir` (
  `id_ligne_fk` int UNSIGNED NOT NULL,
  `id_troncon_fk` int UNSIGNED NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `trancon-ligne-ibfk1` (`id_ligne_fk`),
  KEY `troncon-ligne-ibfk2` (`id_troncon_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

DROP TABLE IF EXISTS `avoir`;
CREATE TABLE IF NOT EXISTS `avoir` (
  `id_itineraire_fk` int UNSIGNED DEFAULT NULL,
  `id_mode_deplacement_fk` int UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_itineraire` (`id_itineraire_fk`),
  KEY `id_mode_deplacement` (`id_mode_deplacement_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `borne`
--

DROP TABLE IF EXISTS `borne`;
CREATE TABLE IF NOT EXISTS `borne` (
  `id` int NOT NULL,
  `libelle` int DEFAULT NULL,
  `id_point_arret_fk` int UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `borne_id_uindex` (`id`),
  KEY `borne-point_arret_fk` (`id_point_arret_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

DROP TABLE IF EXISTS `chauffeur`;
CREATE TABLE IF NOT EXISTS `chauffeur` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `cni` varchar(255) DEFAULT NULL,
  `permis` varchar(255) DEFAULT NULL,
  `taux_commission` double DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `conduire`
--

DROP TABLE IF EXISTS `conduire`;
CREATE TABLE IF NOT EXISTS `conduire` (
  `id_vehicule` int UNSIGNED DEFAULT NULL,
  `id_chauffeur` int UNSIGNED DEFAULT NULL,
  `date` date NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_chauffeur` (`id_chauffeur`),
  KEY `id_vehicule` (`id_vehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `constituer`
--

DROP TABLE IF EXISTS `constituer`;
CREATE TABLE IF NOT EXISTS `constituer` (
  `id_itineraire_fk` int UNSIGNED NOT NULL,
  `id_troncon_fk` int UNSIGNED NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `troncon-itineraire-ibfk1` (`id_itineraire_fk`),
  KEY `troncon-itineraire-ibfk2` (`id_troncon_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

DROP TABLE IF EXISTS `demande`;
CREATE TABLE IF NOT EXISTS `demande` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) DEFAULT NULL,
  `etat` tinyint(1) DEFAULT NULL,
  `id_proprietaire_fk` int UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `lieu_residence` varchar(255) NOT NULL,
  `telephone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `cni` varchar(255) NOT NULL,
  `permis` varchar(255) NOT NULL,
  `carte_grise` varchar(255) NOT NULL,
  `assurance` varchar(255) DEFAULT NULL,
  `immatriculation` varchar(8) NOT NULL,
  `modele` varchar(255) NOT NULL,
  `id_type_transport_fk` int UNSIGNED NOT NULL,
  `nbre_place` int NOT NULL,
  `zone_fk` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proprietaire-demande` (`id_proprietaire_fk`),
  KEY `demande-zone_ibfk` (`zone_fk`),
  KEY `demande-type_transport_ibfk` (`id_type_transport_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `demander_itineraire`
--

DROP TABLE IF EXISTS `demander_itineraire`;
CREATE TABLE IF NOT EXISTS `demander_itineraire` (
  `id_itineraire_fk` int UNSIGNED NOT NULL,
  `id_client_fk` int UNSIGNED NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `demander-itineraire-ibfk` (`id_client_fk`),
  KEY `demander-client-ibfk` (`id_itineraire_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `emprunter`
--

DROP TABLE IF EXISTS `emprunter`;
CREATE TABLE IF NOT EXISTS `emprunter` (
  `id_troncon_fk` int UNSIGNED NOT NULL,
  `id_vehicule_fk` int UNSIGNED NOT NULL,
  `date_arrivee` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_depart` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_client_fk` int UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_itineraire` (`id_troncon_fk`),
  KEY `id_vehicule` (`id_vehicule_fk`),
  KEY `emprunter_ibfk3` (`id_client_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `itineraire`
--

DROP TABLE IF EXISTS `itineraire`;
CREATE TABLE IF NOT EXISTS `itineraire` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `temps` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tarif` double DEFAULT NULL,
  `distance` int DEFAULT NULL,
  `id_trajet_fk` int UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_trajet` (`id_trajet_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `ligne`
--

DROP TABLE IF EXISTS `ligne`;
CREATE TABLE IF NOT EXISTS `ligne` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `arrivee` varchar(255) NOT NULL,
  `id_type_transport_fk` int UNSIGNED NOT NULL,
  `id_zone_fk` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicule-ligne-ibfk` (`id_type_transport_fk`),
  KEY `ligne-zone-ibfk` (`id_zone_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `mode_deplacement`
--

DROP TABLE IF EXISTS `mode_deplacement`;
CREATE TABLE IF NOT EXISTS `mode_deplacement` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `mode_deplacement` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `point_arret`
--

DROP TABLE IF EXISTS `point_arret`;
CREATE TABLE IF NOT EXISTS `point_arret` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `longitude` varchar(255) DEFAULT NULL,
  `position` varchar(255) NOT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `posseder`
--

DROP TABLE IF EXISTS `posseder`;
CREATE TABLE IF NOT EXISTS `posseder` (
  `periode` datetime NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_vehicule_fk` int UNSIGNED NOT NULL,
  `id_trackergps_fk` int UNSIGNED NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `gps-vehicule-ibfk1` (`id_vehicule_fk`),
  KEY `gps-vehicule-ibfk2` (`id_trackergps_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

DROP TABLE IF EXISTS `proprietaire`;
CREATE TABLE IF NOT EXISTS `proprietaire` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `cni` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `carte_grise` varchar(255) NOT NULL,
  `permis` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=500000001 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(100, 'azerty'),
(500000000, '');

-- --------------------------------------------------------

--
-- Structure de la table `role-permission`
--

DROP TABLE IF EXISTS `role-permission`;
CREATE TABLE IF NOT EXISTS `role-permission` (
  `id_role_fk` int UNSIGNED NOT NULL,
  `id_permission_fk` int UNSIGNED NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `role-permission1` (`id_permission_fk`),
  KEY `role-permission2` (`id_role_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `stationner`
--

DROP TABLE IF EXISTS `stationner`;
CREATE TABLE IF NOT EXISTS `stationner` (
  `id_vehicule_fk` int UNSIGNED DEFAULT NULL,
  `id_point_arret_fk` int UNSIGNED DEFAULT NULL,
  `date` datetime NOT NULL,
  `id_client_fk` int UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `id_vehicule` (`id_vehicule_fk`),
  KEY `id_borne` (`id_point_arret_fk`),
  KEY `garer_ibfk3` (`id_client_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `trackergps`
--

DROP TABLE IF EXISTS `trackergps`;
CREATE TABLE IF NOT EXISTS `trackergps` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `id_vehicule_fk` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `gps-vehicule` (`id_vehicule_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `trajet`
--

DROP TABLE IF EXISTS `trajet`;
CREATE TABLE IF NOT EXISTS `trajet` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `depart` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `troncon`
--

DROP TABLE IF EXISTS `troncon`;
CREATE TABLE IF NOT EXISTS `troncon` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_point_arret_A_fk` int UNSIGNED NOT NULL,
  `id_point_arret_B_fk` int UNSIGNED NOT NULL,
  `distance` int NOT NULL,
  `duree` int NOT NULL,
  `tarif` decimal(10,2) NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_ligne_fk` int UNSIGNED DEFAULT NULL,
  `rang` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_point_arret_A_fk` (`id_point_arret_A_fk`,`id_point_arret_B_fk`,`id_ligne_fk`),
  KEY `borne-troncon-A` (`id_point_arret_A_fk`),
  KEY `borne-trancon-B` (`id_point_arret_B_fk`),
  KEY `troncon_ligne_ib_fk` (`id_ligne_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `type_transport`
--

DROP TABLE IF EXISTS `type_transport`;
CREATE TABLE IF NOT EXISTS `type_transport` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle_type_transport` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `type_zone`
--

DROP TABLE IF EXISTS `type_zone`;
CREATE TABLE IF NOT EXISTS `type_zone` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `type_zone`
--

INSERT INTO `type_zone` (`id`, `libelle`) VALUES
(1, 'ville'),
(2, 'region'),
(3, 'commune'),
(4, 'quartier');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom_utilisateur` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `id_role_fk` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user-role` (`id_role_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `immatriculation` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `id_proprietaire_fk` int UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `id_type_transport_fk` int UNSIGNED DEFAULT NULL,
  `nb_place` int DEFAULT NULL,
  `id_zone_fk` int UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_proprietaire` (`id_proprietaire_fk`),
  KEY `id_type_vehicule` (`id_type_transport_fk`),
  KEY `zone-vehicule-ibfk2` (`id_zone_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `zone`
--

DROP TABLE IF EXISTS `zone`;
CREATE TABLE IF NOT EXISTS `zone` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `id_type_zone_fk` int UNSIGNED NOT NULL,
  `zoneparent` int UNSIGNED DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `typesecteur-zone-ibfk1` (`id_type_zone_fk`),
  KEY `typesecteur-zone-ibfk2` (`zoneparent`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `zone`
--

INSERT INTO `zone` (`id`, `libelle`, `id_type_zone_fk`, `zoneparent`) VALUES
(1, 'Abidjan', 1, NULL),
(2, 'San-pedro', 1, NULL),
(3, 'abobo', 3, 1),
(4, 'koumassi', 3, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD CONSTRAINT `trancon-ligne-ibfk1` FOREIGN KEY (`id_ligne_fk`) REFERENCES `ligne` (`id`),
  ADD CONSTRAINT `troncon-ligne-ibfk2` FOREIGN KEY (`id_troncon_fk`) REFERENCES `troncon` (`id`);

--
-- Contraintes pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD CONSTRAINT `avoir_ibfk_1` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`),
  ADD CONSTRAINT `avoir_ibfk_2` FOREIGN KEY (`id_mode_deplacement_fk`) REFERENCES `mode_deplacement` (`id`),
  ADD CONSTRAINT `avoir_ibfk_3` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`),
  ADD CONSTRAINT `avoir_ibfk_4` FOREIGN KEY (`id_mode_deplacement_fk`) REFERENCES `mode_deplacement` (`id`);

--
-- Contraintes pour la table `borne`
--
ALTER TABLE `borne`
  ADD CONSTRAINT `borne-point_arret_fk` FOREIGN KEY (`id_point_arret_fk`) REFERENCES `point_arret` (`id`);

--
-- Contraintes pour la table `conduire`
--
ALTER TABLE `conduire`
  ADD CONSTRAINT `conduire_ibfk_1` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `conduire_ibfk_2` FOREIGN KEY (`id_chauffeur`) REFERENCES `chauffeur` (`id`);

--
-- Contraintes pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD CONSTRAINT `troncon-itineraire-ibfk1` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`),
  ADD CONSTRAINT `troncon-itineraire-ibfk2` FOREIGN KEY (`id_troncon_fk`) REFERENCES `troncon` (`id`);

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `demande-type_transport_ibfk` FOREIGN KEY (`id_type_transport_fk`) REFERENCES `type_transport` (`id`),
  ADD CONSTRAINT `demande-zone_ibfk` FOREIGN KEY (`zone_fk`) REFERENCES `zone` (`id`),
  ADD CONSTRAINT `proprietaire-demande` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`);

--
-- Contraintes pour la table `demander_itineraire`
--
ALTER TABLE `demander_itineraire`
  ADD CONSTRAINT `demander-client-ibfk` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`),
  ADD CONSTRAINT `demander-itineraire-ibfk` FOREIGN KEY (`id_client_fk`) REFERENCES `client` (`id`);

--
-- Contraintes pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD CONSTRAINT `emprunter_ibfk3` FOREIGN KEY (`id_client_fk`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `emprunter_ibfk_1` FOREIGN KEY (`id_troncon_fk`) REFERENCES `troncon` (`id`),
  ADD CONSTRAINT `emprunter_ibfk_2` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`);

--
-- Contraintes pour la table `itineraire`
--
ALTER TABLE `itineraire`
  ADD CONSTRAINT `itineraire_ibfk_1` FOREIGN KEY (`id_trajet_fk`) REFERENCES `trajet` (`id`);

--
-- Contraintes pour la table `ligne`
--
ALTER TABLE `ligne`
  ADD CONSTRAINT `ligne-zone-ibfk` FOREIGN KEY (`id_zone_fk`) REFERENCES `zone` (`id`),
  ADD CONSTRAINT `typevehicule-ligne-ibfk` FOREIGN KEY (`id_type_transport_fk`) REFERENCES `type_transport` (`id`);

--
-- Contraintes pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD CONSTRAINT `gps-vehicule-ibfk1` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `gps-vehicule-ibfk2` FOREIGN KEY (`id_trackergps_fk`) REFERENCES `trackergps` (`id`);

--
-- Contraintes pour la table `role-permission`
--
ALTER TABLE `role-permission`
  ADD CONSTRAINT `role-permission1` FOREIGN KEY (`id_permission_fk`) REFERENCES `permission` (`id`),
  ADD CONSTRAINT `role-permission2` FOREIGN KEY (`id_role_fk`) REFERENCES `role` (`id`);

--
-- Contraintes pour la table `stationner`
--
ALTER TABLE `stationner`
  ADD CONSTRAINT `garer_ibfk3` FOREIGN KEY (`id_client_fk`) REFERENCES `client` (`id`),
  ADD CONSTRAINT `stationner_ibfk_1` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `stationner_ibfk_2` FOREIGN KEY (`id_point_arret_fk`) REFERENCES `point_arret` (`id`);

--
-- Contraintes pour la table `trackergps`
--
ALTER TABLE `trackergps`
  ADD CONSTRAINT `gps-vehicule` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`);

--
-- Contraintes pour la table `troncon`
--
ALTER TABLE `troncon`
  ADD CONSTRAINT `borne-trancon-B` FOREIGN KEY (`id_point_arret_B_fk`) REFERENCES `point_arret` (`id`),
  ADD CONSTRAINT `borne-troncon-A` FOREIGN KEY (`id_point_arret_A_fk`) REFERENCES `point_arret` (`id`),
  ADD CONSTRAINT `troncon_ligne_ib_fk` FOREIGN KEY (`id_ligne_fk`) REFERENCES `ligne` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `user-role` FOREIGN KEY (`id_role_fk`) REFERENCES `role` (`id`);

--
-- Contraintes pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD CONSTRAINT `vehicule_ibfk_1` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `vehicule_ibfk_3` FOREIGN KEY (`id_type_transport_fk`) REFERENCES `type_transport` (`id`),
  ADD CONSTRAINT `zone-vehicule-ibfk2` FOREIGN KEY (`id_zone_fk`) REFERENCES `zone` (`id`);

--
-- Contraintes pour la table `zone`
--
ALTER TABLE `zone`
  ADD CONSTRAINT `typesecteur-zone-ibfk1` FOREIGN KEY (`id_type_zone_fk`) REFERENCES `type_zone` (`id`),
  ADD CONSTRAINT `typesecteur-zone-ibfk2` FOREIGN KEY (`zoneparent`) REFERENCES `zone` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
