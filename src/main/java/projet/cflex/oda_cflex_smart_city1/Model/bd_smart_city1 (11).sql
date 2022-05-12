-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le : jeu. 12 mai 2022 à 09:30
-- Version du serveur :  5.7.34
-- Version de PHP : 7.4.21

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

CREATE TABLE `appartenir` (
  `id_ligne_fk` int(10) UNSIGNED NOT NULL,
  `id_troncon_fk` int(10) UNSIGNED NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `avoir`
--

CREATE TABLE `avoir` (
  `id_itineraire_fk` int(10) UNSIGNED DEFAULT NULL,
  `id_mode_deplacement_fk` int(10) UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `borne`
--

CREATE TABLE `borne` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_point_arret_fk` int(10) UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `chauffeur`
--

CREATE TABLE `chauffeur` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `cni` varchar(255) DEFAULT NULL,
  `permis` varchar(255) DEFAULT NULL,
  `taux_commission` double DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  `genre` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `conduire`
--

CREATE TABLE `conduire` (
  `id_vehicule` int(10) UNSIGNED DEFAULT NULL,
  `id_chauffeur` int(10) UNSIGNED DEFAULT NULL,
  `date` date NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `constituer`
--

CREATE TABLE `constituer` (
  `id_itineraire_fk` int(10) UNSIGNED NOT NULL,
  `id_troncon_fk` int(10) UNSIGNED NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE `demande` (
  `id` int(10) UNSIGNED NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `etat` tinyint(1) DEFAULT NULL,
  `id_proprietaire_fk` int(10) UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  `id_type_transport_fk` int(10) UNSIGNED NOT NULL,
  `id_zone_fk` int(10) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `demander_itineraire`
--

CREATE TABLE `demander_itineraire` (
  `id_itineraire_fk` int(10) UNSIGNED NOT NULL,
  `id_usager_fk` int(10) UNSIGNED NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `emprunter`
--

CREATE TABLE `emprunter` (
  `id_troncon_fk` int(10) UNSIGNED NOT NULL,
  `id_vehicule_fk` int(10) UNSIGNED NOT NULL,
  `date_arrivee` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_depart` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_usager_fk` int(10) UNSIGNED NOT NULL,
  `date` datetime NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `itineraire`
--

CREATE TABLE `itineraire` (
  `id` int(10) UNSIGNED NOT NULL,
  `temps` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `tarif` double DEFAULT NULL,
  `distance` int(11) DEFAULT NULL,
  `id_trajet_fk` int(10) UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ligne`
--

CREATE TABLE `ligne` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) NOT NULL,
  `depart` varchar(255) NOT NULL,
  `arrivee` varchar(255) NOT NULL,
  `id_type_transport_fk` int(10) UNSIGNED NOT NULL,
  `id_zone_fk` int(10) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mode_deplacement`
--

CREATE TABLE `mode_deplacement` (
  `id` int(10) UNSIGNED NOT NULL,
  `mode_deplacement` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `permission`
--

CREATE TABLE `permission` (
  `id` int(10) UNSIGNED NOT NULL,
  `permission` varchar(255) NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `point_arret`
--

CREATE TABLE `point_arret` (
  `id` int(10) UNSIGNED NOT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `position` varchar(255) NOT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `posseder`
--

CREATE TABLE `posseder` (
  `periode` datetime NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_vehicule_fk` int(10) UNSIGNED NOT NULL,
  `id_trackergps_fk` int(10) UNSIGNED NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `piece_identite` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  `permis` varchar(255) DEFAULT NULL,
  `genre` varchar(2) NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` varchar(255) NOT NULL,
  `lieu_residence` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` int(10) UNSIGNED NOT NULL,
  `role` varchar(255) NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `role-permission` (
  `id_role_fk` int(10) UNSIGNED NOT NULL,
  `id_permission_fk` int(10) UNSIGNED NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `stationner`
--

CREATE TABLE `stationner` (
  `id_vehicule_fk` int(10) UNSIGNED DEFAULT NULL,
  `id_point_arret_fk` int(10) UNSIGNED DEFAULT NULL,
  `date` datetime NOT NULL,
  `id_usager_fk` int(10) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `type_utilisateur` varchar(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `trackergps`
--

CREATE TABLE `trackergps` (
  `id` int(10) UNSIGNED NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_vehicule_fk` int(10) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `trajet`
--

CREATE TABLE `trajet` (
  `id` int(10) UNSIGNED NOT NULL,
  `depart` varchar(255) DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `troncon`
--

CREATE TABLE `troncon` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) NOT NULL,
  `id_point_arret_A_fk` int(10) UNSIGNED NOT NULL,
  `id_point_arret_B_fk` int(10) UNSIGNED NOT NULL,
  `distance` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `tarif` decimal(10,2) NOT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_ligne_fk` int(10) UNSIGNED DEFAULT NULL,
  `rang` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type_transport`
--

CREATE TABLE `type_transport` (
  `id` int(10) UNSIGNED NOT NULL,
  `libelle_type_transport` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `type_zone`
--

CREATE TABLE `type_zone` (
  `id` int(10) UNSIGNED NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

CREATE TABLE `usager` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(10) UNSIGNED NOT NULL,
  `nom_utilisateur` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `id_role_fk` int(10) UNSIGNED NOT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id` int(10) UNSIGNED NOT NULL,
  `immatriculation` varchar(255) DEFAULT NULL,
  `marque` varchar(255) DEFAULT NULL,
  `modele` varchar(255) DEFAULT NULL,
  `id_proprietaire_fk` int(10) UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL,
  `id_type_transport_fk` int(10) UNSIGNED DEFAULT NULL,
  `nb_place` int(11) DEFAULT NULL,
  `id_zone_fk` int(10) UNSIGNED NOT NULL,
  `carte_grise` varchar(255) NOT NULL,
  `id_demande_fk` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `zone`
--

CREATE TABLE `zone` (
  `id` int(10) UNSIGNED NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `id_type_zone_fk` int(10) UNSIGNED NOT NULL,
  `zoneparent` int(10) UNSIGNED DEFAULT NULL,
  `statut` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `zone`
--

INSERT INTO `zone` (`id`, `libelle`, `id_type_zone_fk`, `zoneparent`, `statut`) VALUES
(1, 'Abidjan', 1, NULL, 0),
(2, 'San-pedro', 1, NULL, 0),
(3, 'abobo', 3, 1, 0),
(4, 'koumassi', 3, 1, 0);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `appartenir`
--
ALTER TABLE `appartenir`
  ADD PRIMARY KEY (`id`),
  ADD KEY `trancon-ligne-ibfk1` (`id_ligne_fk`),
  ADD KEY `troncon-ligne-ibfk2` (`id_troncon_fk`);

--
-- Index pour la table `avoir`
--
ALTER TABLE `avoir`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_itineraire` (`id_itineraire_fk`),
  ADD KEY `id_mode_deplacement` (`id_mode_deplacement_fk`);

--
-- Index pour la table `borne`
--
ALTER TABLE `borne`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `borne_id_uindex` (`id`),
  ADD KEY `borne-point_arret_fk` (`id_point_arret_fk`);

--
-- Index pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `conduire`
--
ALTER TABLE `conduire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_chauffeur` (`id_chauffeur`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `constituer`
--
ALTER TABLE `constituer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `troncon-itineraire-ibfk1` (`id_itineraire_fk`),
  ADD KEY `troncon-itineraire-ibfk2` (`id_troncon_fk`);

--
-- Index pour la table `demande`
--
ALTER TABLE `demande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `proprietaire-demande` (`id_proprietaire_fk`),
  ADD KEY `demande-zone_ibfk` (`id_zone_fk`),
  ADD KEY `demande-type_transport_ibfk` (`id_type_transport_fk`);

--
-- Index pour la table `demander_itineraire`
--
ALTER TABLE `demander_itineraire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `demander-itineraire-ibfk` (`id_usager_fk`),
  ADD KEY `demander-client-ibfk` (`id_itineraire_fk`);

--
-- Index pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_itineraire` (`id_troncon_fk`),
  ADD KEY `id_vehicule` (`id_vehicule_fk`),
  ADD KEY `emprunter_ibfk3` (`id_usager_fk`);

--
-- Index pour la table `itineraire`
--
ALTER TABLE `itineraire`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_trajet` (`id_trajet_fk`);

--
-- Index pour la table `ligne`
--
ALTER TABLE `ligne`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vehicule-ligne-ibfk` (`id_type_transport_fk`),
  ADD KEY `ligne-zone-ibfk` (`id_zone_fk`);

--
-- Index pour la table `mode_deplacement`
--
ALTER TABLE `mode_deplacement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `point_arret`
--
ALTER TABLE `point_arret`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `posseder`
--
ALTER TABLE `posseder`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gps-vehicule-ibfk1` (`id_vehicule_fk`),
  ADD KEY `gps-vehicule-ibfk2` (`id_trackergps_fk`);

--
-- Index pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `role-permission`
--
ALTER TABLE `role-permission`
  ADD PRIMARY KEY (`id`),
  ADD KEY `role-permission1` (`id_permission_fk`),
  ADD KEY `role-permission2` (`id_role_fk`);

--
-- Index pour la table `stationner`
--
ALTER TABLE `stationner`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_vehicule` (`id_vehicule_fk`),
  ADD KEY `id_borne` (`id_point_arret_fk`),
  ADD KEY `garer_ibfk3` (`id_usager_fk`);

--
-- Index pour la table `trackergps`
--
ALTER TABLE `trackergps`
  ADD PRIMARY KEY (`id`),
  ADD KEY `gps-vehicule` (`id_vehicule_fk`);

--
-- Index pour la table `trajet`
--
ALTER TABLE `trajet`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `troncon`
--
ALTER TABLE `troncon`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_point_arret_A_fk` (`id_point_arret_A_fk`,`id_point_arret_B_fk`,`id_ligne_fk`),
  ADD KEY `borne-troncon-A` (`id_point_arret_A_fk`),
  ADD KEY `borne-trancon-B` (`id_point_arret_B_fk`),
  ADD KEY `troncon_ligne_ib_fk` (`id_ligne_fk`);

--
-- Index pour la table `type_transport`
--
ALTER TABLE `type_transport`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `type_zone`
--
ALTER TABLE `type_zone`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `usager`
--
ALTER TABLE `usager`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user-role` (`id_role_fk`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_proprietaire` (`id_proprietaire_fk`),
  ADD KEY `id_type_vehicule` (`id_type_transport_fk`),
  ADD KEY `zone-vehicule-ibfk2` (`id_zone_fk`),
  ADD KEY `demande-vehicule_fk` (`id_demande_fk`);

--
-- Index pour la table `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`),
  ADD KEY `typesecteur-zone-ibfk1` (`id_type_zone_fk`),
  ADD KEY `typesecteur-zone-ibfk2` (`zoneparent`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `appartenir`
--
ALTER TABLE `appartenir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `avoir`
--
ALTER TABLE `avoir`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `borne`
--
ALTER TABLE `borne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `chauffeur`
--
ALTER TABLE `chauffeur`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `conduire`
--
ALTER TABLE `conduire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `constituer`
--
ALTER TABLE `constituer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `demande`
--
ALTER TABLE `demande`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `demander_itineraire`
--
ALTER TABLE `demander_itineraire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `emprunter`
--
ALTER TABLE `emprunter`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `itineraire`
--
ALTER TABLE `itineraire`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ligne`
--
ALTER TABLE `ligne`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `mode_deplacement`
--
ALTER TABLE `mode_deplacement`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `permission`
--
ALTER TABLE `permission`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `point_arret`
--
ALTER TABLE `point_arret`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `posseder`
--
ALTER TABLE `posseder`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=500000001;

--
-- AUTO_INCREMENT pour la table `role-permission`
--
ALTER TABLE `role-permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `stationner`
--
ALTER TABLE `stationner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `trackergps`
--
ALTER TABLE `trackergps`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `trajet`
--
ALTER TABLE `trajet`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `troncon`
--
ALTER TABLE `troncon`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `type_transport`
--
ALTER TABLE `type_transport`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `type_zone`
--
ALTER TABLE `type_zone`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `usager`
--
ALTER TABLE `usager`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  ADD CONSTRAINT `demande-zone_ibfk` FOREIGN KEY (`id_zone_fk`) REFERENCES `zone` (`id`),
  ADD CONSTRAINT `proprietaire-demande` FOREIGN KEY (`id_proprietaire_fk`) REFERENCES `proprietaire` (`id`);

--
-- Contraintes pour la table `demander_itineraire`
--
ALTER TABLE `demander_itineraire`
  ADD CONSTRAINT `demander-itineraire-ibfk` FOREIGN KEY (`id_usager_fk`) REFERENCES `usager` (`id`),
  ADD CONSTRAINT `demander-usager-ibfk` FOREIGN KEY (`id_itineraire_fk`) REFERENCES `itineraire` (`id`);

--
-- Contraintes pour la table `emprunter`
--
ALTER TABLE `emprunter`
  ADD CONSTRAINT `emprunter_ibfk3` FOREIGN KEY (`id_usager_fk`) REFERENCES `usager` (`id`),
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
  ADD CONSTRAINT `garer_ibfk3` FOREIGN KEY (`id_usager_fk`) REFERENCES `usager` (`id`),
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
  ADD CONSTRAINT `demande-vehicule_fk` FOREIGN KEY (`id_demande_fk`) REFERENCES `demande` (`id`),
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
