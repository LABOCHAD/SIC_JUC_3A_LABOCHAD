/*
Tabelle Players 
(int player_id  (PK) auto increment, varchar(50) player_name NOT null) oder User(s)
Tabelle Games 
(int game_id (PK) auto increment, player_ID (FK), int score (min 0, max 200)! NOT null, 
datetime timeOfGame, int duration_In_Seconds), Zeiten optional
*/
drop database if exists MemoryGame;
create database MemoryGame;
use MemoryGame;

create table Players(
	player_id int auto_increment primary key,
    player_name varchar(50) not null
);

create table Games(
	game_id int auto_increment primary key,
	player_id int, -- references Players(player_id) without foreign key (player_id) is not enough
		foreign key (player_id) references Players(player_id)
		on delete cascade on update cascade, -- FK
    score int check(score >= 0 AND score <= 200) not null,
    
    -- optional params
		timeOfGame datetime, -- 'YYYY-MM-DD hh:mm:ss' 
			-- https://dev.mysql.com/doc/refman/8.4/en/datetime.html
		duration_In_Seconds int -- check(duration_In_Seconds <= 100) 
			-- in case we make the game been lost, when score is 0
);