/*
    -- for getting select results
	MySqlCommand cmd = new MySqlCommand(sql, _connection);
	using MySqlDataReader reader = cmd.ExecuteReader(); //using: opened here, closed after try

	-- for building entities from ResultSet
	string sql = "insert into Books(title, author_id, publication_year, genre, isbn) " +
				 "values (@title, @author_id, @publication_year, @genre, @isbn);";
	MySqlCommand cmd = new MySqlCommand(sql, _connection);
	cmd.Parameters.AddWithValue("@title", book.Title);
	...
	cmd.Parameters.AddWithValue("@isbn", book.Isbn);
	cmd.ExecuteNonQuery(); //for non selects;
*/

-- get player
	select * from players where player_name = @player_name;

-- create a player
	insert into players (player_name) values (@player_name);

-- save a game
	-- without optionals
	insert into games (player_id, score) values
    (
		-- pending
    );
    
	-- with optionals
    
-- show a game joined with player
