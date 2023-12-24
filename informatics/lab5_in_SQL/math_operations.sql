DROP TABLE IF EXISTS  x_bits;

CREATE TABLE IF NOT EXISTS x_bits (
    name VARCHAR(10) PRIMARY KEY,
    bin_value text,
    int_value text
    );
DO $$
DECLARE
  b1  text;
  b2  text;
  b3  text;
  b4  text;
  b5  text;
  b6  text;
  b7  text;
  b8  text;
  b9  text;
  b10 text;
  b11 text;
  b12 text;

BEGIN
    SELECT value INTO b1 FROM valueName_b WHERE name = 'b1';
    SELECT value INTO b2 FROM valueName_b WHERE name = 'b2';
    SELECT value INTO b3 FROM valueName_b WHERE name = 'b3';
    SELECT value INTO b4 FROM valueName_b WHERE name = 'b4';
    SELECT value INTO b5 FROM valueName_b WHERE name = 'b5';
    SELECT value INTO b6 FROM valueName_b WHERE name = 'b6';
    SELECT value INTO b7 FROM valueName_b WHERE name = 'b7';
    SELECT value INTO b8 FROM valueName_b WHERE name = 'b8';
    SELECT value INTO b9 FROM valueName_b WHERE name = 'b9';
    SELECT value INTO b10 FROM valueName_b WHERE name = 'b10';
    SELECT value INTO b11 FROM valueName_b WHERE name = 'b11';
    SELECT value INTO b12 FROM valueName_b WHERE name = 'b12';

    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b1 + b2', ((int4(varbit(b1)) + int4(varbit(b2)))::bit(16)), ((int4(varbit(b1)) + int4(varbit(b2)))::text) );
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b2 + b3', (int4(varbit(b2)) + int4(varbit(b3)))::bit(16),  (int4(varbit(b2)) + int4(varbit(b3)) ));
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b2 + b7', ((int4(varbit(b2)) + int4(varbit(b7)))::bit(16)),  (int4(varbit(b2)) + int4(varbit(b7))) );
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b7 + b8', ((int4(varbit(b7)) + int4(varbit(b8)))::bit(16)) , (int4(varbit(b7)) + int4(varbit(b8)))  );
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b8 + b9', ((int4(varbit(b8)) + int4(varbit(b9)))::bit(16)) ,  (int4(varbit(b8)) + int4(varbit(b9))) );
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b1 + b8', ((int4(varbit(b1)) + int4(varbit(b8)))::bit(16)) ,(int4(varbit(b1)) + int4(varbit(b8))) );
    INSERT INTO x_bits (name, bin_value, int_value) VALUES ('b11 + b3', ((int4(varbit(b1)) + int4(varbit(b2)))::bit(16)) ,  (int4(varbit(b1)) + int4(varbit(b2))) );

END$$;

SELECT * FROM x_bits;