CREATE TABLE user (
                      id INT PRIMARY KEY,
                      bio TEXT,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      email VARCHAR(255) NOT NULL UNIQUE,
                      password VARCHAR(255) NOT NULL,
                      username VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE user_follow (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             follower_id INT NOT NULL,
                             followed_id INT NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (follower_id) REFERENCES user(id),
                             FOREIGN KEY (followed_id) REFERENCES user(id),
                             UNIQUE (follower_id, followed_id)  -- Prevent duplicates
);
CREATE TABLE article (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT NOT NULL,
                         content TEXT NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         description TEXT,
                         title VARCHAR(255) NOT NULL,

                         FOREIGN KEY (user_id) REFERENCES user(id)
);
CREATE TABLE tag (
                     name VARCHAR(50) PRIMARY KEY,
                     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE article_tag (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             article_id INT NOT NULL,
                             tag_name VARCHAR(50) NOT NULL,
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             FOREIGN KEY (article_id) REFERENCES article(id),
                             FOREIGN KEY (tag_name) REFERENCES tag(name)
);
CREATE TABLE article_comment (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 article_id INT NOT NULL,
                                 user_id INT NOT NULL,
                                 content TEXT NOT NULL,
                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 FOREIGN KEY (article_id) REFERENCES article(id),
                                 FOREIGN KEY (user_id) REFERENCES user(id)
);
CREATE TABLE article_favorite (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  article_id INT NOT NULL,
                                  user_id INT NOT NULL,
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (article_id) REFERENCES article(id),
                                  FOREIGN KEY (user_id) REFERENCES user(id),
                                  UNIQUE (article_id, user_id)  -- Prevent duplicate favorites
);


-- CREATE TABLE user_followers (
--                                 follower_id INT NOT NULL,
--                                 followed_id INT NOT NULL,
--                                 PRIMARY KEY (follower_id, followed_id),
--                                 FOREIGN KEY (follower_id) REFERENCES users(id),
--                                 FOREIGN KEY (followed_id) REFERENCES users(id)
-- );