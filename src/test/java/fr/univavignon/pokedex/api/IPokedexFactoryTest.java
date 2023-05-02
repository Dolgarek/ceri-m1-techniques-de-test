package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {

    /*@Test
    public void test() {
        IPokedexFactory mockIPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider mockMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
        when(mockIPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory)).thenReturn(mockIPokedex);

        assertEquals(mockIPokedex, mockIPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory));
    }*/

    IPokedexFactory pokedexFactory = new PokedexFactory();
    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    IPokemonFactory pokemonFactory = new PokemonFactory();
    IPokedex pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void shouldBePokedex() {
        assertEquals(pokedex.getClass(), pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass());
    }

    @Test
    public void shouldPokedexBeNull() {
        assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}