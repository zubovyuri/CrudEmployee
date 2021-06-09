CREATE TABLE IF NOT EXISTS employees
-- ФИО, табельный номер, дата приема, дата увольнения, зарплата
-- service number, date of appointment, date of dismissal, salary
(
    id bigserial,
    name character varying(200) NOT NULL,
    service_number character varying(30),
    date_appointment date NOT NULL,
    date_dismissal date,
    salary bigserial NOT NULL,
    PRIMARY KEY (id)
);