-- Author:  jhamil
-- Created: Nov 8, 2016

-- TYPE INDICATOR
INSERT INTO `yakukawsay`.`type_indicator` (`id`, `type`, `unity`) VALUES ('1', 'temperatura', 'grados');
INSERT INTO `yakukawsay`.`type_indicator` (`id`, `type`, `unity`) VALUES ('2', 'humedad', 'grados');
-- INSERT INTO `yakukawsay`.`type_indicator` (`id`, `type`, `unity`) VALUES ('3', 'nivelAgua', 'grados');

-- DEVICES
INSERT INTO `yakukawsay`.`device` (`id`, `model`, `date`, `latitude`, `longitude`, `lastValue`, `type_indicator_id`) VALUES ('1', 'DHT11', '2016-11-11', '-12,12312', '-16,1231', NULL, '1');
INSERT INTO `yakukawsay`.`device` (`id`, `model`, `date`, `latitude`, `longitude`, `lastValue`, `type_indicator_id`) VALUES ('2', 'DHT11', '2016-11-11', '-12,12312', '-16,1231', NULL, '2');
