create schema personalBlog;
CREATE USER 'slawek'@'localhost' IDENTIFIED BY 'slawek';
GRANT ALL PRIVILEGES ON * . * TO 'slawek'@'localhost';
FLUSH PRIVILEGES;
