# drop database deimos_spring_db;
# #
use deimos_spring_db;

insert into users (username, email, password) values
('testUser1','randomemail1@mail.com','password1'),
('testUser2','randomemail2@mail.com','password2'),
('testUser3','randomemail3@mail.com','password3'),
('testUser4','randomemail4@mail.com','password4');

insert into post_details (history_of_post, is_awesome, topic_description) values
('a brief history of briefs', false, 'underpants'),
('Napoleon, man or great man?', false, 'shorties'),
('ghosts and stuff', false, 'spookiness'),
('the best laid plans...', false, 'books'),
('ken\'s headphones', false, 'electronics');

# truncate post_images;
insert into tags (name) values ('silly');
insert into tags (name) values ('funny');
insert into tags (name) values ('humor');

insert into posts (title, body, post_details_id, user_id) values ('Undertow (Contracorriente)', 'Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', 1, 1);
insert into posts (title, body, post_details_id, user_id) values ('House of the Dead, The', 'Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', 2, 2);
insert into posts (title, body, post_details_id, user_id) values ('Classe américaine, La (a.k.a. Le grand détournement)', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat. Praesent blandit. Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', 3, 3);
insert into posts (title, body, post_details_id, user_id) values ('Age of Ignorance, The (a.k.a. Days of Darkness) (L''âge des ténèbres)', 'In congue. Etiam justo. Etiam pretium iaculis justo. In hac habitasse platea dictumst. Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius. Nulla facilisi. Cras non velit nec nisi vulputate nonummy.', 4, 4);
insert into posts (title, body, post_details_id, user_id) values ('Frozen Ghost, The', 'Suspendisse accumsan tortor quis turpis. Sed ante. Vivamus tortor. Duis mattis egestas metus. Aenean fermentum. Donec ut mauris eget massa tempor convallis. Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', 5, 4);

insert into post_images(image_url, post_id) values ('https://i.redd.it/5uhl1h1xwkpx.jpg', 2);
insert into post_images(image_url, post_id) values ('https://s3.amazonaws.com/lowres.cartoonstock.com/travel-tourism-vacation-holiday-day_out-beach-pollution-rhan1196_low.jpg', 1);
insert into post_images(image_url, post_id) values ('https://o.aolcdn.com/images/dims?quality=85&image_uri=https%3A%2F%2Fo.aolcdn.com%2Fimages%2Fdims%3Fresize%3D2000%252C2000%252Cshrink%26image_uri%3Dhttps%253A%252F%252Fs.yimg.com%252Fos%252Fcreatr-uploaded-images%252F2019-10%252Fbe1bb990-e6c3-11e9-bfeb-f01b1546ebb0%26client%3Da1acac3e1b3290917d92%26signature%3D64e564ea7c582661e7ca9876df9b3a46549fc331&client=amp-blogside-v2&signature=20b140806f1c684496937aa18bde314376d382d5', 1);
insert into post_images(image_url, post_id) values ('https://upload.wikimedia.org/wikipedia/en/0/08/House_Of_The_Dead%2C_Thelogo.png', 2);
insert into post_images(image_url, post_id) values ('https://image.made-in-china.com/2f0j00qGnYPOfJlskB/Hot-Sale-Exciting-Arcade-House-of-The-Dead-4-Gun-Shooting-Game-Machine.jpg', 2);
insert into post_images(image_url, post_id) values ('https://upload.wikimedia.org/wikipedia/en/0/08/House_Of_The_Dead%2C_Thelogo.png', 2);
insert into post_images(image_url, post_id) values ('https://e.snmc.io/i/300/w/d26e0c83af0b0d2168d11859634e1641/1151183', 3);
insert into post_images(image_url, post_id) values ('https://posterspy.com/wp-content/uploads/2019/06/La-classe-am%C3%A9ricaine-1500x2143.jpg', 3);
insert into post_images(image_url, post_id) values ('https://e.snmc.io/i/300/w/d26e0c83af0b0d2168d11859634e1641/1151183', 3);
insert into post_images(image_url, post_id) values ('https://images-na.ssl-images-amazon.com/images/I/91%2B6LJTjUYL._SY445_.jpg', 4);
insert into post_images(image_url, post_id) values ('https://i.pinimg.com/originals/4f/e0/5c/4fe05c0a2d170a2261e6501618f913bd.png', 5);
insert into post_images(image_url, post_id) values ('https://m.media-amazon.com/images/M/MV5BMTgyMjQyNjkwMl5BMl5BanBnXkFtZTgwNDk5ODIwMjE@._V1_SY1000_CR0,0,657,1000_AL_.jpg', 5);

insert into post_tag (post_id, tag_id) values
(1,1),
(1,2),
(2,3),
(3,1),
(3,2),
(3,3),
(4,2),
(5,3),
(5,2);



