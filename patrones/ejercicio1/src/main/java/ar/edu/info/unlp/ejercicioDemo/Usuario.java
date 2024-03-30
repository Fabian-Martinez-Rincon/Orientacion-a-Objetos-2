package ar.edu.info.unlp.ejercicioDemo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String screenName;
	private List<Tweet> tweets = new ArrayList<>();
	private List<ReTweet> re_tweets = new ArrayList<>();
	
	// Se supone que el screen name es unico
	public Usuario(String screenName) {
		this.screenName = screenName;
	}
	
	public void agregarTweet(Tweet T) {
		this.tweets.add(T);
	}
	
	public void agregarReTweet(ReTweet RT) {
		this.re_tweets.add(RT);
	}
	
	public List<Tweet> devolverTweets(){
		return this.tweets;
	}
	
	public int cantidadTweets() {
		return this.tweets.size();
	}
	
	public int cantidadReTweets() {
		return this.re_tweets.size();
	}
	
	public void eliminarReTweets(){
		this.re_tweets.clear();
	}
	
	public void eliminarTweets(){
		this.tweets.clear();
	}
	
	public boolean tieneReTweetsDelTweet(Tweet t) {
		return this.re_tweets.stream()
				.anyMatch(retweet -> retweet.esOrigen(t));
	}
	
	public void eliminarReTweetsReferenciados(Tweet t) {
		this.re_tweets.removeIf(rt -> rt.esOrigen(t));
	}
}