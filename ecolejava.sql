-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 06 juin 2019 à 23:01
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecolejava`
--

-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDInscription` int(11) NOT NULL,
  `IDTrimestre` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDInscription` (`IDInscription`),
  KEY `IDTrimestre` (`IDTrimestre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDNiveau` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDNiveau` (`IDNiveau`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnseignement` int(11) NOT NULL,
  `IDBulletin` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEnseignement` (`IDEnseignement`),
  KEY `IDBulletin` (`IDBulletin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `enseignent`
--

DROP TABLE IF EXISTS `enseignent`;
CREATE TABLE IF NOT EXISTS `enseignent` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDClasse` int(11) NOT NULL,
  `IDDiscipline` int(11) NOT NULL,
  `IDProfesseur` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDClasse` (`IDClasse`),
  KEY `IDDiscipline` (`IDDiscipline`),
  KEY `IDProfesseur` (`IDProfesseur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDDetailBulletin` int(11) NOT NULL,
  `Note` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDDetailBulletin` (`IDDetailBulletin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEtudiant` int(11) NOT NULL,
  `Type` set('Ajouter','Supprimer','Modifier') NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEtudiant` (`IDEtudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEtudiant` int(11) NOT NULL,
  `IDClasse` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEtudiant` (`IDEtudiant`),
  KEY `IDClasse` (`IDClasse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDClasse` int(11) DEFAULT NULL,
  `IDAnnee` int(11) DEFAULT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Type` set('Etudiant','Enseignant','Directeur','') NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDClasse` (`IDClasse`),
  KEY `IDAnnee` (`IDAnnee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDAnnee` int(11) NOT NULL,
  `Numero` int(11) NOT NULL,
  `Debut` date NOT NULL,
  `Fin` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDAnnee` (`IDAnnee`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `FK_INSCRIPTION_BULLETIN` FOREIGN KEY (`IDInscription`) REFERENCES `inscription` (`ID`),
  ADD CONSTRAINT `FK_TRIMESTRE_BULLETIN` FOREIGN KEY (`IDTrimestre`) REFERENCES `trimestre` (`ID`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK_NIVEAU_CLASSE` FOREIGN KEY (`IDNiveau`) REFERENCES `niveau` (`ID`);

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `FK_BULLETIN_DETAIL` FOREIGN KEY (`IDBulletin`) REFERENCES `bulletin` (`ID`),
  ADD CONSTRAINT `FK_ENSEIGNEMENT_DETAIL` FOREIGN KEY (`IDEnseignement`) REFERENCES `enseignent` (`ID`);

--
-- Contraintes pour la table `enseignent`
--
ALTER TABLE `enseignent`
  ADD CONSTRAINT `FK_CLASSE_ENSEIGNEMENT` FOREIGN KEY (`IDClasse`) REFERENCES `classe` (`ID`),
  ADD CONSTRAINT `FK_DISCIPLINE_ENSEIGNEMENT` FOREIGN KEY (`IDDiscipline`) REFERENCES `discipline` (`ID`),
  ADD CONSTRAINT `FK_PROFESSEUR_ENSEIGNEMENT` FOREIGN KEY (`IDProfesseur`) REFERENCES `personne` (`ID`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK_DETAIL_EVALUATION` FOREIGN KEY (`IDDetailBulletin`) REFERENCES `detailbulletin` (`ID`);

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `FK_ETUDIANT_HISTORIQUE` FOREIGN KEY (`IDEtudiant`) REFERENCES `personne` (`ID`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK_CLASSE_ETUDIANT` FOREIGN KEY (`IDEtudiant`) REFERENCES `personne` (`ID`),
  ADD CONSTRAINT `FK_CLASSE_INSCRIPTION` FOREIGN KEY (`IDClasse`) REFERENCES `classe` (`ID`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `FK_ANNEE_PERSONNE` FOREIGN KEY (`IDAnnee`) REFERENCES `annee` (`ID`),
  ADD CONSTRAINT `FK_CLASSE_PERSONNE` FOREIGN KEY (`IDClasse`) REFERENCES `classe` (`ID`);

--
-- Contraintes pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `FK_ANNEE_TRIMESTRE` FOREIGN KEY (`IDAnnee`) REFERENCES `annee` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
