package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

class IPokedexFactoryTest {

    @Test
    public void test() {
        IPokedexFactory mockIPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider mockMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory mockPokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex mockIPokedex = Mockito.mock(IPokedex.class);
        when(mockIPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory)).thenReturn(mockIPokedex);

        assertEquals(mockIPokedex, mockIPokedexFactory.createPokedex(mockMetadataProvider, mockPokemonFactory));
    }
}