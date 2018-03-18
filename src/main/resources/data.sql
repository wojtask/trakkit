INSERT INTO user (id, username, password_hash)
  VALUES (1, 'chris', 'password');
INSERT INTO video_game (id, title, date_released, developer, publisher, summary)
  VALUES (1, 'Super Mario Bros.', parsedatetime('13 Sep 1985', 'dd MMM yyyy'), 'Nintendo Creative Department', 'Nintendo', 'In Super Mario Bros., the player controls Mario as he travels through the Mushroom Kingdom to rescue Princess Toadstool from the antagonist, Bowser.');
INSERT INTO video_game (id, title, date_released, developer, publisher, summary)
  VALUES (2, 'Tetris', parsedatetime('6 Jun 1984', 'dd MMM yyyy'), 'Alexey Pajitnov', 'Various', NULL);
INSERT INTO video_game_status (id, user_id, video_game_id, status, timestamp)
  VALUES (1, 1, 1, 'BACKLOG', parsedatetime('18 Mar 2018 00:00:00', 'dd MMM yyyy HH:mm:ss'));
INSERT INTO video_game_status (id, user_id, video_game_id, status, timestamp)
  VALUES (2, 1, 2, 'BACKLOG', parsedatetime('18 Mar 2018 02:00:00', 'dd MMM yyyy HH:mm:ss'));
INSERT INTO video_game_status (id, user_id, video_game_id, status, timestamp)
  VALUES (3, 1, 1, 'IN_PROGRESS', parsedatetime('18 Mar 2018 03:00:00', 'dd MMM yyyy HH:mm:ss'));
INSERT INTO video_game_status (id, user_id, video_game_id, status, timestamp)
  VALUES (4, 1, 1, 'COMPLETED', parsedatetime('18 Mar 2018 21:37:20', 'dd MMM yyyy HH:mm:ss'));
