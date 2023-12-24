DROP TABLE IF  EXISTS valueName_b;
CREATE TABLE IF NOT EXISTS valueName_b (
    name VARCHAR(10) PRIMARY KEY,
    value TEXT
    );
DO $$
DECLARE
arr_name TEXT[] = ARRAY['b1', 'b2', 'b3', 'b4', 'b5', 'b6', 'b7', 'b8', 'b9', 'b10', 'b11', 'b12'];
  arr_value INT [];
  rec_row RECORD;
  i INT := 0;
BEGIN

FOR rec_row IN SELECT name, value FROM valueName_x
                                           LOOP
    i := i + 1;
BEGIN
INSERT INTO valueName_b (name, value)
VALUES (arr_name[i], rec_row.value::bit(16) );

EXCEPTION WHEN unique_violation THEN
END;

END LOOP;

END$$;

SELECT * FROM valueName_b