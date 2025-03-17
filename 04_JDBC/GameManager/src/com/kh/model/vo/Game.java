package com.kh.model.vo;

import java.util.Date;

/**
 * @author user1
 *
 */
public class Game {

	private String game_id ;
	private String title;
	private String genre;
	private String platfrom;
	private Date release_date;
	
	
	
	public Game() {
		super();
	}



	public Game(String game_id, String title, String genre, String platfrom, Date release_date) {
		super();
		this.game_id = game_id;
		this.title = title;
		this.genre = genre;
		this.platfrom = platfrom;
		this.release_date = release_date;
	}



	public String getGame_id() {
		return game_id;
	}



	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getPlatfrom() {
		return platfrom;
	}



	public void setPlatfrom(String platfrom) {
		this.platfrom = platfrom;
	}



	public Date getRelease_date() {
		return release_date;
	}



	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}



	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", title=" + title + ", genre=" + genre + ", platfrom=" + platfrom
				+ ", release_date=" + release_date + "]";
	}
	
	
	
	
	
}
