CREATE TABLE IF NOT EXISTS Ingredient (
  id VARCHAR(4) PRIMARY KEY,
  name VARCHAR(25) NOT NULL,
  type VARCHAR(10) NOT NULL
);
DROP TABLE IF EXISTS  Taco;
create table if not exists Taco (
  id identity primary key,
  name varchar(50) not null,
  createdAt timestamp
);

CREATE TABLE IF NOT EXISTS Taco_Ingredients (
  taco BIGINT NOT NULL,
  ingredient VARCHAR(4) NOT NULL,
  PRIMARY KEY (taco, ingredient),
  FOREIGN KEY (taco) REFERENCES Taco(id),
  FOREIGN KEY (ingredient) REFERENCES Ingredient(id)
);

DROP TABLE IF EXISTS Taco_Order;

CREATE TABLE IF NOT EXISTS Taco_Order (
    id IDENTITY PRIMARY KEY,
    deliveryName VARCHAR(50) NOT NULL,
    deliveryStreet VARCHAR(50) NOT NULL,
    deliveryCity VARCHAR(50) NOT NULL,
    deliveryState VARCHAR(300) NOT NULL,
    deliveryZip VARCHAR(10) NOT NULL,
    ccNumber VARCHAR(16) NOT NULL,
    ccExpiration VARCHAR(5) NOT NULL,
    ccCVV VARCHAR(3) NOT NULL,
    placedAt TIMESTAMP NOT NULL
);
DROP TABLE IF EXISTS Taco_Order_Tacos;

CREATE TABLE IF NOT EXISTS Taco_Order_Tacos (
    tacoOrder BIGINT NOT NULL,
    taco BIGINT NOT NULL,
    PRIMARY KEY (tacoOrder, taco),
    FOREIGN KEY (tacoOrder) REFERENCES Taco_Order(id),
    FOREIGN KEY (taco) REFERENCES Taco(id)
);