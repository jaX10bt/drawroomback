INSERT INTO project.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO project.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO project."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO project."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'kasutaja', '123', 'A');

INSERT INTO project.profile (id, user_id, cover_id, avatar_id) VALUES (DEFAULT, 1, null, null);
INSERT INTO project.profile (id, user_id, cover_id, avatar_id) VALUES (DEFAULT, 2, null, null);
