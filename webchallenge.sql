-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 20 Novembre 2018 à 21:13
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `webchallenge`
--

-- --------------------------------------------------------

--
-- Structure de la table `shop`
--

CREATE TABLE IF NOT EXISTS `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_shop` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `shop`
--

INSERT INTO `shop` (`id`, `nom_shop`) VALUES
(1, 'Shop Name 1'),
(2, 'Shop Name 2'),
(3, 'Shop Name 3'),
(4, 'Shop Name 4'),
(5, 'Shop Name 5'),
(6, 'Shop Name 6'),
(7, 'Shop Name 7'),
(8, 'Shop Name 8');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `login_user` varchar(255) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`login_user`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`login_user`, `nom`, `password`, `prenom`) VALUES
('amin@gmail.com', 'mohamed amine', '1995', 'traibi'),
('mohamed@gmail.com', 'mohamed', '1995', 'amine');

-- --------------------------------------------------------

--
-- Structure de la table `user_shop`
--

CREATE TABLE IF NOT EXISTS `user_shop` (
  `description` varchar(255) DEFAULT NULL,
  `login_user` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`login_user`),
  KEY `FKkv5aenw1m7yjbt61sdf7c8hqr` (`login_user`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_shop`
--

INSERT INTO `user_shop` (`description`, `login_user`, `id`) VALUES
('add to my favorite', 'amin@gmail.com', 2),
('add to my favorite', 'amin@gmail.com', 4),
('add to my favorite', 'amin@gmail.com', 7);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
