create table paths
(
    point_a   decimal not null,
    point_b   decimal not null,
    path_json jsonb not null,
    constraint paths_pk primary key (point_a, point_b)
);