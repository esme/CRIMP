DROP TABLE IF EXISTS crimp_data CASCADE;

CREATE TABLE crimp_data (
	c_id VARCHAR(5) PRIMARY KEY,
	c_name TEXT NOT NULL,
	c_category VARCHAR(3) NOT NULL,

	q01_judge TEXT,
	q01_raw TEXT,
	q01_top SMALLINT,
	q01_bonus SMALLINT,

	q02_judge TEXT,
	q02_raw TEXT,
	q02_top SMALLINT,
	q02_bonus SMALLINT,

	q03_judge TEXT,
	q03_raw TEXT,
	q03_top SMALLINT,
	q03_bonus SMALLINT,

	q04_judge TEXT,
	q04_raw TEXT,
	q04_top SMALLINT,
	q04_bonus SMALLINT,

	q05_judge TEXT,
	q05_raw TEXT,
	q05_top SMALLINT,
	q05_bonus SMALLINT,

	q06_judge TEXT,
	q06_raw TEXT,
	q06_top SMALLINT,
	q06_bonus SMALLINT,

	f01_judge TEXT,
	f01_raw TEXT,
	f01_top SMALLINT,
	f01_bonus SMALLINT,

	f02_judge TEXT,
	f02_raw TEXT,
	f02_top SMALLINT,
	f02_bonus SMALLINT,

	f03_judge TEXT,
	f03_raw TEXT,
	f03_top SMALLINT,
	f03_bonus SMALLINT,

	f04_judge TEXT,
	f04_raw TEXT,
	f04_top SMALLINT,
	f04_bonus SMALLINT
);

INSERT INTO crimp_data (c_id, c_name, c_category, q01_raw, q01_top, q01_bonus) VALUES
('NM001', 'Andy', 'NMQ', '111B1T', 6, 4),
('NM002', 'Ben', 'NMQ', '11T', 3, 3),
('NM003', 'Charlie', 'NMQ', '111111BT', 8, 7),
('NM004', 'David', 'NMQ', 'B111', 0, 1),
('NM005', 'Ethan', 'NMQ', 'T', 1, 1),
('NM006', 'Florine', 'NMQ', '1B', 0, 1),
('NM007', 'Glen', 'NMQ', '1111', 0, 0),
('NW001', 'Anna', 'NWQ', '1111111111B', 11, 0),
('NW002', 'Brenda', 'NWQ', 'T', 1, 1),
('NW003', 'Cathy', 'NWQ', 'B', 0, 1),
('NW004', 'Dorothy', 'NWQ', 'BBBBT', 1, 0),
('NW005', 'Erica', 'NWQ', '1111B', 0, 5),
('NW006', 'Felicia', 'NWQ', '11T', 3, 3),
('NW007', 'Ginny', 'NWQ', '11B', 0, 3);