create table paths
(
    point_a_x   decimal not null,
    point_a_y   decimal not null,
    point_b_x   decimal not null,
    point_b_y   decimal not null,
    path_json jsonb not null,
    constraint paths_pk primary key (point_a_x, point_a_y, point_b_x, point_b_y)
);