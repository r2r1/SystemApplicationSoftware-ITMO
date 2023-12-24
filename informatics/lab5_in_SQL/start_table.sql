DROP TABLE IF EXISTS valueName_x;

CREATE TABLE  IF NOT EXISTS valueName_x (
    name VARCHAR(10) PRIMARY KEY,
    value INT
);

DO $$
DECLARE
    A INT := 411;
    C INT := 25531;
BEGIN
    INSERT INTO valueName_x (name, value) VALUES ('X1', A);
    INSERT INTO valueName_x (name, value) VALUES ('X2', C);
    INSERT INTO valueName_x (name, value) VALUES ('X3', A + C);
    INSERT INTO valueName_x (name, value) VALUES ('X4', A + C + C);
    INSERT INTO valueName_x (name, value) VALUES ('X5', C - A);
    INSERT INTO valueName_x (name, value) VALUES ('X6', 65536 - (A + C + C));  
    INSERT INTO valueName_x (name, value) VALUES ('X7', -A);
    INSERT INTO valueName_x (name, value) VALUES ('X8', -C);
    INSERT INTO valueName_x (name, value) VALUES ('X9', -(A + C));
    INSERT INTO valueName_x (name, value) VALUES ('X10', - (A + C + C)  );
    INSERT INTO valueName_x (name, value) VALUES ('X11', -(C - A));
    INSERT INTO valueName_x (name, value) VALUES ('X12', -(65536 - (A + C + C)));
END$$;

SELECT * FROM valueName_x;