DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(25) NOT NULL
);

INSERT INTO users (name) VALUES
  ('UserA'),
  ('UserB'),
  ('UserC');

DROP TABLE IF EXISTS modules;
CREATE TABLE modules (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  module_code VARCHAR(25) NOT NULL,
  module_name VARCHAR(25) NOT NULL
);

INSERT INTO modules (module_code,module_name) VALUES
  ('Promo','PromoCard'),
  ('Category','CategoryCard'),
  ('FlashSale','FlashSaleCard'),
  ('History','HistoryCard'),
  ('News','NewsCard');

DROP TABLE IF EXISTS user_module;
CREATE TABLE user_module (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id INT NOT NULL,
  module_id INT NOT NULL,
  order_section INT NOT NULL
);

INSERT INTO user_module (user_id, module_id,order_section) VALUES
  (1,1,1),
  (1,2,2),
  (1,3,3),
  (1,4,4),
  (1,5,5),
  (2,1,1),
  (2,5,2),
  (2,3,3),
  (2,4,4),
  (2,2,5),
  (3,2,5),
  (3,1,1),
  (3,3,2),
  (3,2,3),
  (3,5,4),
  (3,4,5);
