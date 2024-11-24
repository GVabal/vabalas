CREATE TABLE sample
(
    id         uuid PRIMARY KEY,
    some_value varchar(255) NOT NULL,
    created_at timestamp    NOT NULL DEFAULT now(),
    updated_at timestamp    NOT NULL DEFAULT now()
);

CREATE UNIQUE INDEX sample_idx ON sample (id);

INSERT INTO sample (id, some_value)
VALUES ('f81db69e-be93-43fc-97d2-6312f94a77ac', 'The'),
       ('79326b66-9c92-4cc1-8a2d-04edcd7f3203', 'Big'),
       ('ff664959-b382-4446-b42e-dd4a2682fc44', 'Brown'),
       ('487ca8d0-c373-4583-a851-3775178069fb', 'Fox'),
       ('6643a874-58f1-492a-b62b-3bade896a4ff', 'Jumped'),
       ('6c10e1af-5ccd-4528-a502-50357c367e81', 'Over'),
       ('0ca629e3-fdcf-469b-93ce-296557d45123', 'A'),
       ('49d89f4b-128d-48bb-a639-d58124f628b1', 'Very'),
       ('ea29366e-0d7a-44fa-980e-b21d9516693e', 'Lazy'),
       ('d02a9eba-0030-4745-989d-3394922a525e', 'Dog');
