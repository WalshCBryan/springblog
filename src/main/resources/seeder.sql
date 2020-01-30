# drop database deimos_spring_db;
#
use deimos_spring_db;

insert into users (username, email, password) values
('testUser1','randomemail1@mail.com','password1'),
('testUser2','randomemail2@mail.com','password2'),
('testUser3','randomemail3@mail.com','password3'),
('testUser4','randomemail4@mail.com','password4');

insert into posts (title, body, post_details_id) values ('Undertow (Contracorriente)', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', 1);
insert into posts (title, body, post_details_id) values ('House of the Dead, The', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', 2);
insert into posts (title, body, post_details_id) values ('Classe américaine, La (a.k.a. Le grand détournement)', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 3);
insert into posts (title, body, post_details_id) values ('Age of Ignorance, The (a.k.a. Days of Darkness) (L''âge des ténèbres)', 'In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', 4);
insert into posts (title, body, post_details_id) values ('Frozen Ghost, The', 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', 5);

insert into post_details (history_of_post, is_awesome, topic_description) values
('a brief history of briefs', false, 'underpants'),
('Napoleon, man or great man?', false, 'shorties'),
('ghosts and stuff', false, 'spookiness'),
('the best laid plans...', false, 'books'),
('ken\'s headphones', false, 'electronics');



