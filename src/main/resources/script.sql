create table paths
(
    id     integer primary key,
    id_1   text  not null,
    id_2   text  not null,
    points jsonb not null,
    constraint paths_pk unique (id_1, id_2)
);
create table types
(
    path_id integer not null,
    type    varchar(255),
    foreign key (path_id) references paths (id)
);
insert into paths (id, id_1, id_2, points)
VALUES (2,
        '23',
        '23',
        '[
          {
            "x": "2",
            "y": "2"
          },
          {
            "x": "3",
            "y": "3"
          }
        ]');
insert into types (path_id, type)
VALUES (2,
        'Привет');
insert into types (path_id, type)
VALUES (2,
        'Пятерка');