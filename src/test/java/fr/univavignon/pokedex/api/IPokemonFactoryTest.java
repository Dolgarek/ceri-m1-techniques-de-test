package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class IPokemonFactoryTest {

    /*@Test
    public void test() {
        IPokemonFactory mockIPokemonFactory = Mockito.mock(IPokemonFactory.class);
        Pokemon pokemon = new Pokemon(0, "test", 1, 1, 1, 1, 1, 1, 1, 0);
        when(mockIPokemonFactory.createPokemon(anyInt(),eq(1),eq(1),eq(1),eq(1))).thenAnswer(input -> {
            int index = input.getArgument(0);
            if(index < 0 || index > 150) {
                throw new PokedexException("Index invalide");
            }
            return pokemon;
        });

        assertEquals(pokemon, mockIPokemonFactory.createPokemon(0,1,1,1,1));
        assertThrows(PokedexException.class,() -> mockIPokemonFactory.createPokemon(-1,1,1,1,1));
        assertThrows(PokedexException.class,() -> mockIPokemonFactory.createPokemon(151,1,1,1,1));
    }*/

    IPokemonFactory pokemonFactory = new PokemonFactory();
    Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 1, 1, 1, 1, 0);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetPokemon() throws PokedexException {
        Pokemon bulbizarreFromFactory = pokemonFactory.createPokemon(0,1,1,1,1);

        assertEquals(bulbizarreFromFactory.getIndex(), bulbizarre.getIndex());
        assertEquals(bulbizarreFromFactory.getCp(), bulbizarre.getCp());
        assertEquals(bulbizarreFromFactory.getHp(), bulbizarre.getHp());
        assertEquals(bulbizarreFromFactory.getDust(), bulbizarre.getDust());
        assertEquals(bulbizarreFromFactory.getCandy(), bulbizarre.getCandy());
        assertEquals(bulbizarreFromFactory.getName(), bulbizarre.getName());
        assertEquals(bulbizarreFromFactory.getAttack(), bulbizarre.getAttack());
        assertEquals(bulbizarreFromFactory.getDefense(), bulbizarre.getDefense());
        assertEquals(bulbizarreFromFactory.getStamina(), bulbizarre.getStamina());
        assertEquals(50, bulbizarre.getIv(), 50);
    }

    @Test
    public void shouldThrowPokedexExceptionWhenNegativeValue() {
        assertThrows(PokedexException.class,() -> pokemonFactory.createPokemon(-1,1,1,1,1));
    }

    @Test
    public void shouldThrowPokedexExceptionWhenOutOfBOund() {
        assertThrows(PokedexException.class,() -> pokemonFactory.createPokemon(151,1,1,1,1));
    }
}