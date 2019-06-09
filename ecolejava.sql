-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 09 juin 2019 à 14:27
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
) ENGINE=InnoDB AUTO_INCREMENT=2022 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `annee`
--

INSERT INTO `annee` (`ID`) VALUES
(1819),
(1920),
(2021);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`ID`, `IDInscription`, `IDTrimestre`, `Appreciation`) VALUES
(1, 1, 1, 'Bon eleve'),
(2, 1, 2, 'Bon eleve encore'),
(3, 1, 3, 'bon eleve x3');

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDNiveau` int(11) NOT NULL,
  `IDAnnee` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDNiveau` (`IDNiveau`),
  KEY `IDAnnee` (`IDAnnee`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`ID`, `IDNiveau`, `IDAnnee`, `Nom`) VALUES
(3, 1, 1819, 'TD01'),
(4, 2, 1819, 'TD02'),
(5, 3, 1819, 'TD03');

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDEnseignement` int(11) NOT NULL,
  `IDBulletin` int(11) NOT NULL,
  `Coefficient` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDEnseignement` (`IDEnseignement`),
  KEY `IDBulletin` (`IDBulletin`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`ID`, `IDEnseignement`, `IDBulletin`, `Coefficient`, `Appreciation`) VALUES
(1, 1, 1, 2, 'Bon en math'),
(2, 2, 2, 3, 'Bon'),
(3, 1, 3, 1, 'Bon');

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`ID`, `Nom`) VALUES
(1, 'Mathématiques'),
(2, 'Français'),
(3, 'Anglais'),
(4, 'Informatique');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDClasse` int(11) NOT NULL,
  `IDDiscipline` int(11) NOT NULL,
  `IDEnseignant` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDClasse` (`IDClasse`),
  KEY `IDDiscipline` (`IDDiscipline`),
  KEY `IDProfesseur` (`IDEnseignant`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`ID`, `IDClasse`, `IDDiscipline`, `IDEnseignant`) VALUES
(1, 3, 1, 4),
(2, 4, 1, 4),
(3, 5, 1, 4);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `IDDetailBulletin` int(11) NOT NULL,
  `Note` int(11) NOT NULL,
  `Coefficient` int(11) NOT NULL,
  `Appreciation` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDDetailBulletin` (`IDDetailBulletin`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`ID`, `IDDetailBulletin`, `Note`, `Coefficient`, `Appreciation`) VALUES
(1, 1, 20, 2, ''),
(2, 1, 19, 3, ''),
(3, 1, 18, 1, ''),
(4, 2, 15, 3, 'Pas mal'),
(5, 2, 19, 1, 'tres bon'),
(6, 2, 11, 2, 'assez bien'),
(7, 3, 7, 3, 'insuffisant'),
(8, 3, 13, 2, 'bien'),
(9, 3, 20, 2, 'excellent');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`ID`, `IDEtudiant`, `IDClasse`) VALUES
(1, 1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`ID`, `Nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3'),
(4, 'ING4'),
(5, 'ING5');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Prenom` varchar(255) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Type` set('Etudiant','Enseignant','Directeur','') NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`ID`, `Prenom`, `Nom`, `Type`) VALUES
(1, 'Nathan', 'Lancman', 'Etudiant'),
(2, 'Stan', 'StanFam', 'Etudiant'),
(3, 'Directeur', 'DirFam', 'Directeur'),
(4, 'ProfMath', 'Math', 'Enseignant'),
(5, 'ProfFr', 'Francais', 'Enseignant'),
(6, 'ProfAn', 'Anglais', 'Enseignant'),
(7, 'ProfInfo', 'Info', 'Enseignant'),
(8, 'Pierre', 'Feuille', 'Etudiant'),
(9, 'Pala', 'Polo', 'Etudiant'),
(10, 'Pala', 'Polo', 'Etudiant');

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`ID`, `IDAnnee`, `Numero`, `Debut`, `Fin`) VALUES
(1, 1819, 1, '2018-09-03', '2018-11-30'),
(2, 1819, 2, '2018-12-03', '2019-03-15'),
(3, 1819, 3, '2019-03-18', '2019-06-07'),
(4, 1920, 1, '2019-09-02', '2019-11-29'),
(5, 1920, 2, '2019-12-02', '2020-03-13'),
(6, 1920, 3, '2020-03-16', '2020-06-05'),
(7, 2021, 1, '2020-09-07', '2020-12-04'),
(8, 2021, 2, '2020-12-07', '2021-03-19'),
(9, 2021, 3, '2021-03-22', '2021-06-11');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `FK_INSCRIPTION_BULLETIN` FOREIGN KEY (`IDInscription`) REFERENCES `inscription` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_TRIMESTRE_BULLETIN` FOREIGN KEY (`IDTrimestre`) REFERENCES `trimestre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK_ANNEE_CLASSE` FOREIGN KEY (`IDAnnee`) REFERENCES `annee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_NIVEAU_CLASSE` FOREIGN KEY (`IDNiveau`) REFERENCES `niveau` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `FK_BULLETIN_DETAIL` FOREIGN KEY (`IDBulletin`) REFERENCES `bulletin` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_ENSEIGNEMENT_DETAIL` FOREIGN KEY (`IDEnseignement`) REFERENCES `enseignement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `FK_CLASSE_ENSEIGNEMENT` FOREIGN KEY (`IDClasse`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_DISCIPLINE_ENSEIGNEMENT` FOREIGN KEY (`IDDiscipline`) REFERENCES `discipline` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_PROFESSEUR_ENSEIGNEMENT` FOREIGN KEY (`IDEnseignant`) REFERENCES `personne` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FK_DETAIL_EVALUATION` FOREIGN KEY (`IDDetailBulletin`) REFERENCES `detailbulletin` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `historique`
--
ALTER TABLE `historique`
  ADD CONSTRAINT `FK_ETUDIANT_HISTORIQUE` FOREIGN KEY (`IDEtudiant`) REFERENCES `personne` (`ID`);

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK_CLASSE_ETUDIANT` FOREIGN KEY (`IDEtudiant`) REFERENCES `personne` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_CLASSE_INSCRIPTION` FOREIGN KEY (`IDClasse`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `FK_ANNEE_TRIMESTRE` FOREIGN KEY (`IDAnnee`) REFERENCES `annee` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
