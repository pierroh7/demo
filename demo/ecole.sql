-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 juin 2019 à 13:16
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
-- Base de données :  `ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID` int(11) NOT NULL,
  `Nom` varchar(255) NOT NULL,
  `Prenom` varchar(255) NOT NULL,
  `Classe` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID`, `Nom`, `Prenom`, `Classe`) VALUES
(1122, 'Miroite', 'Pierre', 'TD1'),
(1123, 'Louis', 'Jean', 'TD 1'),
(1124, 'Lancman', 'Nathan', 'TD 1'),
(1125, 'Zaimi', 'Sihame', 'TD 1'),
(1126, 'Roussel', 'Louis', 'TD 4');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `cle` int(11) NOT NULL AUTO_INCREMENT,
  `ID` int(11) NOT NULL,
  `Matiere` varchar(50) NOT NULL,
  `Semestre` int(11) NOT NULL,
  `DS1` int(11) DEFAULT NULL,
  `DS2` int(11) DEFAULT NULL,
  `NS1` int(11) DEFAULT NULL,
  `NS2` int(11) DEFAULT NULL,
  PRIMARY KEY (`cle`)
) ENGINE=MyISAM AUTO_INCREMENT=1163 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `notes`
--

INSERT INTO `notes` (`cle`, `ID`, `Matiere`, `Semestre`, `DS1`, `DS2`, `NS1`, `NS2`) VALUES
(1131, 1123, 'math', 1, NULL, NULL, NULL, NULL),
(1123, 1122, 'math', 1, 11, 11, 12, 11),
(1124, 1122, 'math', 2, 12, 12, 12, 12),
(1125, 1122, 'elec', 1, 13, 14, 12, 0),
(1126, 1122, 'elec', 2, NULL, NULL, NULL, NULL),
(1127, 1122, 'info', 1, NULL, NULL, NULL, NULL),
(1128, 1122, 'info', 2, NULL, NULL, NULL, NULL),
(1129, 1122, 'lfh', 1, NULL, NULL, NULL, NULL),
(1130, 1122, 'lfh', 2, NULL, NULL, NULL, NULL),
(1132, 1123, 'math', 2, NULL, NULL, NULL, NULL),
(1133, 1123, 'elec', 1, NULL, NULL, NULL, NULL),
(1134, 1123, 'elec', 2, NULL, NULL, NULL, NULL),
(1135, 1123, 'info', 1, NULL, NULL, NULL, NULL),
(1136, 1123, 'info', 2, NULL, NULL, NULL, NULL),
(1137, 1123, 'lfh', 1, NULL, NULL, NULL, NULL),
(1138, 1123, 'lfh', 2, NULL, NULL, NULL, NULL),
(1139, 1124, 'math', 1, NULL, NULL, NULL, NULL),
(1140, 1124, 'math', 2, NULL, NULL, NULL, NULL),
(1141, 1124, 'elec', 1, NULL, NULL, NULL, NULL),
(1142, 1124, 'elec', 2, NULL, NULL, NULL, NULL),
(1143, 1124, 'info', 1, NULL, NULL, NULL, NULL),
(1144, 1124, 'info', 2, NULL, NULL, NULL, NULL),
(1145, 1124, 'lfh', 1, NULL, NULL, NULL, NULL),
(1146, 1124, 'lfh', 2, NULL, NULL, NULL, NULL),
(1147, 1125, 'math', 1, NULL, NULL, NULL, NULL),
(1148, 1125, 'math', 2, NULL, NULL, NULL, NULL),
(1149, 1125, 'elec', 1, NULL, NULL, NULL, NULL),
(1150, 1125, 'elec', 2, NULL, NULL, NULL, NULL),
(1151, 1125, 'info', 1, NULL, NULL, NULL, NULL),
(1152, 1125, 'info', 2, NULL, NULL, NULL, NULL),
(1153, 1125, 'lfh', 1, NULL, NULL, NULL, NULL),
(1154, 1125, 'lfh', 2, NULL, NULL, NULL, NULL),
(1155, 1126, 'math', 1, NULL, NULL, NULL, NULL),
(1156, 1126, 'math', 2, NULL, NULL, NULL, NULL),
(1157, 1126, 'elec', 1, NULL, NULL, NULL, NULL),
(1158, 1126, 'elec', 2, NULL, NULL, NULL, NULL),
(1159, 1126, 'info', 1, NULL, NULL, NULL, NULL),
(1160, 1126, 'info', 2, NULL, NULL, NULL, NULL),
(1161, 1126, 'lfh', 1, NULL, NULL, NULL, NULL),
(1162, 1126, 'lfh', 2, NULL, NULL, NULL, NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
