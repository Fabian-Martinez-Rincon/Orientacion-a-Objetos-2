package ar.edu.info.unlp.ejercicioDemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwitterTest {
	Twitter twitter;
	Usuario pepe;
	Usuario maria;
	
	Tweet tweetPepe;
	Tweet tweetMaria;
	
	ReTweet retweetPepe;
	ReTweet retweetMaria;
	
	@BeforeEach
	void setUp() throws Exception{
		twitter = new Twitter();
		
		pepe = new Usuario("Pepe");
		maria = new Usuario("Maria");
		
		
		tweetPepe = new Tweet("Esto no es un juego");
		tweetMaria = new Tweet("Pugliese publiese pugliese");
		
		pepe.agregarTweet(tweetPepe);
		maria.agregarTweet(tweetMaria);
		
		
		pepe.agregarReTweet(new ReTweet(tweetMaria));

		
		twitter.agregarUsuario(pepe);
		twitter.agregarUsuario(maria);
		
	}
	
	@Test
	public void testTweets() {
		assertEquals(1, pepe.cantidadTweets());
		assertEquals(1, pepe.cantidadReTweets());
		assertEquals(1, maria.cantidadTweets());
		
		twitter.eliminarUsuario(maria);
		
		assertEquals(1, pepe.cantidadTweets());
		assertEquals(0, pepe.cantidadReTweets());
		assertEquals(0, maria.cantidadTweets());
		
	}
}
