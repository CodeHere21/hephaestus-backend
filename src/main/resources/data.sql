INSERT INTO POST(TITLE, BODY, AUTHOR, PUBLISHED) VALUES ('does this work','this is our first one', 'first writer', '1987-08-21');
INSERT INTO POST(TITLE, BODY, AUTHOR, PUBLISHED) VALUES ('about tags','Tagtagtagtagtag', 'Tag writer', '1887-08-21');
INSERT INTO POST(TITLE, BODY, AUTHOR, PUBLISHED) VALUES ('About history','History story, history history history', 'history writer', '2001-08-21');
INSERT INTO POST(TITLE, BODY, AUTHOR, PUBLISHED) VALUES ('the story of dragons','DRAGONS BE HERE', 'Someone wrote this', '2009-08-21');




INSERT INTO COMMENT(BODY, AUTHOR, WRITTEN_ON, POST_ID ) VALUES('First!','Someone','1981-01-01',1);
INSERT INTO COMMENT(BODY, AUTHOR, WRITTEN_ON, POST_ID ) VALUES('Phht, what an original comment','SOmeJerk','1981-01-01',1);
INSERT INTO COMMENT(BODY, AUTHOR, WRITTEN_ON, POST_ID ) VALUES('First!','SomeJerk','1981-01-01',2);
INSERT INTO COMMENT(BODY, AUTHOR, WRITTEN_ON, POST_ID ) VALUES('Cmon, leave them alone','WhiteKnighter78','1981-01-01',1);





INSERT INTO TAG(LABEL, POST_ID) VALUES('#Totally', 1);
INSERT INTO TAG(LABEL, POST_ID) VALUES('#Totally', 2);
INSERT INTO TAG(LABEL, POST_ID) VALUES('#Totally', 3);
INSERT INTO TAG(LABEL, POST_ID) VALUES('#Totally', 4);
INSERT INTO TAG(LABEL, POST_ID) VALUES('TestofThree', 1);
INSERT INTO TAG(LABEL, POST_ID) VALUES('TestofThree', 2);
INSERT INTO TAG(LABEL, POST_ID) VALUES('TestofThree', 3);
INSERT INTO TAG(LABEL, POST_ID) VALUES('prometheus', 1);
INSERT INTO TAG(LABEL, POST_ID) VALUES('SuperDuo', 1);
INSERT INTO TAG(LABEL, POST_ID) VALUES('SuperDuo', 2);