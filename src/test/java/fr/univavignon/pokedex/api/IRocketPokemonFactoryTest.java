package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IRocketPokemonFactoryTest {
    IPokemonFactory pokemonFactory = new PokemonFactory();
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 1, 1, 1, 1, 0);

    RocketPokemonFactory rocketPokemonFactory = new RocketPokemonFactory();

    @Test
    public void shouldGetPokemonWithWrongMetadata() throws PokedexException {
        Pokemon bulbizarreFromFactory = rocketPokemonFactory.createPokemon(0,1,1,1,1);

        assertEquals(bulbizarreFromFactory.getIndex(), bulbizarre.getIndex());
        assertEquals(bulbizarreFromFactory.getCp(), bulbizarre.getCp());
        assertEquals(bulbizarreFromFactory.getHp(), bulbizarre.getHp());
        assertEquals(bulbizarreFromFactory.getDust(), bulbizarre.getDust());
        assertEquals(bulbizarreFromFactory.getCandy(), bulbizarre.getCandy());
        assertNotEquals(bulbizarreFromFactory.getName(), bulbizarre.getName());
        assertNotEquals(bulbizarreFromFactory.getAttack(), bulbizarre.getAttack());
        assertNotEquals(bulbizarreFromFactory.getDefense(), bulbizarre.getDefense());
        assertNotEquals(bulbizarreFromFactory.getStamina(), bulbizarre.getStamina());
        assertTrue(bulbizarre.getIv() == 0 || bulbizarre.getIv() == 1 );
    }

    @Test
    public void shouldThrowErrorButDont() {
        assertNotNull(rocketPokemonFactory.createPokemon(-1,1,1,1,1));
        assertNotNull(rocketPokemonFactory.createPokemon(151,1,1,1,1));
    }
}
