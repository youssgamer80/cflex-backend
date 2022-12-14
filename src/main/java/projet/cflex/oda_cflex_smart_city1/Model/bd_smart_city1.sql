-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 19 mai 2022 à 10:59
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
  `statut` tinyint(1) NOT NULL,
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
  `id` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `id_point_arret_fk` int NOT NULL,
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `borne_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `borne`
--

INSERT INTO `borne` (`id`, `libelle`, `id_point_arret_fk`, `statut`) VALUES
(1, '', 0, 0),
(2, '', 0, 0),
(3, '', 0, 0),
(4, '', 0, 0);

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
  `telephone` varchar(10) DEFAULT NULL,
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
  `statut` tinyint(1) NOT NULL,
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
  `code_demande` varchar(255) DEFAULT NULL,
  `etat` tinyint(1) DEFAULT NULL,
  `id_proprietaire_fk` int UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_zone_fk` int UNSIGNED NOT NULL,
  `id_type_transport_fk` int UNSIGNED NOT NULL,
  `immatriculation` varchar(255) NOT NULL,
  `marque` varchar(255) NOT NULL,
  `model` varchar(255) NOT NULL,
  `nb_place` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `proprietaire-demande` (`id_proprietaire_fk`),
  KEY `demande-zone` (`id_zone_fk`)
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
  `statut` tinyint(1) NOT NULL,
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
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_trajet` (`id_trajet_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `itineraire`
--

INSERT INTO `itineraire` (`id`, `temps`, `tarif`, `distance`, `id_trajet_fk`, `statut`) VALUES
(3, '2022-05-17 11:11:05', 100, 10, 2, 1),
(4, '2022-05-17 11:11:05', 750, 48, 1, 1),
(5, '2022-05-17 11:32:48', 0, 0, 1, 1),
(6, '2022-05-17 11:32:48', 0, 0, 2, 1),
(7, '2022-05-17 11:32:48', 250, 11, 1, 1),
(8, '2022-05-17 11:32:48', 250, 11, 1, 1),
(9, '2022-05-17 11:32:48', 150, 11, 1, 1),
(10, '2022-05-18 11:07:32', 100, 20, 2, 1);

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
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicule-ligne-ibfk` (`id_type_transport_fk`),
  KEY `ligne-zone-ibfk` (`id_zone_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `ligne`
--

INSERT INTO `ligne` (`id`, `nom`, `depart`, `arrivee`, `id_type_transport_fk`, `id_zone_fk`, `statut`) VALUES
(1, 'ljpolijpl', 'ljoijooii', 'ljlhhoii', 4, 1, 1);

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
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Structure de la table `point_arret`
--

DROP TABLE IF EXISTS `point_arret`;
CREATE TABLE IF NOT EXISTS `point_arret` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `longitude` double(10,2) NOT NULL,
  `latitude` double(10,2) NOT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `longitude` (`longitude`,`latitude`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `point_arret`
--

INSERT INTO `point_arret` (`id`, `nom`, `longitude`, `latitude`, `statut`) VALUES
(1, '', 56456.66, 5449.67, 1);

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
-- Structure de la table `posseder-trackergps`
--

DROP TABLE IF EXISTS `posseder-trackergps`;
CREATE TABLE IF NOT EXISTS `posseder-trackergps` (
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
-- Structure de la table `posseder-vehicule`
--

DROP TABLE IF EXISTS `posseder-vehicule`;
CREATE TABLE IF NOT EXISTS `posseder-vehicule` (
  `id_proprietaire_fk` int UNSIGNED NOT NULL,
  `id_vehicule_fk` int UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `proprietaire-vehicule-ibfk1` (`id_proprietaire_fk`),
  KEY `proprietaire-vehicul-ibfk2` (`id_vehicule_fk`)
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
  `statut` tinyint(1) DEFAULT NULL,
  `permis` varchar(255) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `genre` varchar(1) NOT NULL,
  `lieu_naissance` varchar(255) DEFAULT NULL,
  `lieu_residence` varchar(255) NOT NULL,
  `piece_identite` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `nom`, `prenom`, `telephone`, `email`, `statut`, `permis`, `date_naissance`, `genre`, `lieu_naissance`, `lieu_residence`, `piece_identite`) VALUES
(1, NULL, NULL, NULL, NULL, 1, NULL, NULL, '', NULL, '', ''),
(2, NULL, NULL, NULL, NULL, 1, NULL, NULL, '', NULL, '', '');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=500000001 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `role`, `statut`) VALUES
(100, 'azerty', 0),
(500000000, '', 0);

-- --------------------------------------------------------

--
-- Structure de la table `role-permission`
--

DROP TABLE IF EXISTS `role-permission`;
CREATE TABLE IF NOT EXISTS `role-permission` (
  `id_role_fk` int UNSIGNED NOT NULL,
  `id_permission_fk` int UNSIGNED NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `statut` tinyint(1) NOT NULL,
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
-- Structure de la table `token`
--

DROP TABLE IF EXISTS `token`;
CREATE TABLE IF NOT EXISTS `token` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `token` varchar(255) NOT NULL,
  `id_proprietaire_fk` int UNSIGNED NOT NULL,
  `id_vehicule_fk` int UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `vehichule-token` (`id_vehicule_fk`),
  KEY `proprietaire-token` (`id_proprietaire_fk`)
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
  `statut` tinyint(1) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `trajet`
--

INSERT INTO `trajet` (`id`, `depart`, `destination`, `statut`) VALUES
(1, 'rue du commerce', 'odc', 1),
(2, 'odc', 'cnps', 1);

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
  `distance` double(10,2) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `troncon`
--

INSERT INTO `troncon` (`id`, `nom`, `id_point_arret_A_fk`, `id_point_arret_B_fk`, `distance`, `duree`, `tarif`, `statut`, `id_ligne_fk`, `rang`) VALUES
(2, 'ierhfgirghih', 1, 1, 546.00, 254, '545.00', 1, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `type_transport`
--

DROP TABLE IF EXISTS `type_transport`;
CREATE TABLE IF NOT EXISTS `type_transport` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle_type_transport` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `type_transport`
--

INSERT INTO `type_transport` (`id`, `libelle_type_transport`, `statut`) VALUES
(1, 'etrgrg', 1),
(2, 'thgthte', 0),
(3, 'Train', 1),
(4, 'camion', 1),
(5, 'test', 0),
(6, 'test', 0);

-- --------------------------------------------------------

--
-- Structure de la table `type_zone`
--

DROP TABLE IF EXISTS `type_zone`;
CREATE TABLE IF NOT EXISTS `type_zone` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `type_zone`
--

INSERT INTO `type_zone` (`id`, `libelle`, `statut`) VALUES
(1, 'ville', 0),
(2, 'region', 0),
(3, 'commune', 0),
(4, 'quartier', 0);

-- --------------------------------------------------------

--
-- Structure de la table `usager`
--

DROP TABLE IF EXISTS `usager`;
CREATE TABLE IF NOT EXISTS `usager` (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `usager`
--

INSERT INTO `usager` (`id`, `nom`, `prenom`, `telephone`, `statut`) VALUES
(12, NULL, NULL, NULL, NULL),
(13, 'mohaled', NULL, NULL, NULL),
(14, 'konan', 'enock', '0708996955', 1),
(15, 'dghirugr', 'sgsrtgrs', 'gfdfgdf', 0),
(16, 'hgfvgkddk,', 'bdvhjhdgkjhdhvdj', NULL, NULL);

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
  `statut` tinyint(1) NOT NULL,
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
  `carte_grise` varchar(255) NOT NULL,
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
  `statut` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `typesecteur-zone-ibfk1` (`id_type_zone_fk`),
  KEY `typesecteur-zone-ibfk2` (`zoneparent`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

--
-- Déchargement des données de la table `zone`
--

INSERT INTO `zone` (`id`, `libelle`, `id_type_zone_fk`, `zoneparent`, `statut`) VALUES
(1, 'Abidjan', 1, NULL, 0),
(2, 'San-pedro', 1, NULL, 0),
(3, 'abobo', 3, 1, 0),
(4, 'koumassi', 3, 1, 0);

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
  ADD CONSTRAINT `demande-zone` FOREIGN KEY (`id_zone_fk`) REFERENCES `zone` (`id`),
  ADD CONSTRAINT `proprietaire-demande` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`);

--
-- Contraintes pour la table `demander_itineraire`
--
ALTER TABLE `demander_itineraire`
  ADD CONSTRAINT `demander-client-ibfk` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`),
  ADD CONSTRAINT `demander-itineraire-ibfk` FOREIGN KEY (`id_client_fk`) REFERENCES `usager` (`id`);

--
-- Contraintes pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD CONSTRAINT `emprunter_ibfk3` FOREIGN KEY (`id_client_fk`) REFERENCES `usager` (`id`),
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
-- Contraintes pour la table `posseder-vehicule`
--
ALTER TABLE `posseder-vehicule`
  ADD CONSTRAINT `proprietaire-vehicul-ibfk2` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `proprietaire-vehicule-ibfk1` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`);

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
  ADD CONSTRAINT `garer_ibfk3` FOREIGN KEY (`id_client_fk`) REFERENCES `usager` (`id`),
  ADD CONSTRAINT `stationner_ibfk_1` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`),
  ADD CONSTRAINT `stationner_ibfk_2` FOREIGN KEY (`id_point_arret_fk`) REFERENCES `point_arret` (`id`);

--
-- Contraintes pour la table `token`
--
ALTER TABLE `token`
  ADD CONSTRAINT `proprietaire-token` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `vehichule-token` FOREIGN KEY (`id_vehicule_fk`) REFERENCES `vehicule` (`id`);

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
