package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class IPokemonTrainerFactoryTest {

    /*@Test
    public void testCreateTrainer() {
        IPokemonTrainerFactory mockIPokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);


        IPokedexFactory iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokedex iPokedex = iPokedexFactory.createPokedex(Mockito.mock(IPokemonMetadataProvider.class), Mockito.mock(IPokemonFactory.class));
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Test",Team.INSTINCT, iPokedex);

        when(mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory)).thenReturn(pokemonTrainer);

        assertEquals(pokemonTrainer, mockIPokemonTrainerFactory.createTrainer("Test", Team.INSTINCT, iPokedexFactory));

    }*/

    IPokemonTrainerFactory pokemonTrainerFactory = new PokemonTrainerFactory();
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    PokemonTrainer pokemonTrainer;

    @BeforeEach
    public void setUp() {
        pokedexFactory = new PokedexFactory();
        IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
        pokemonTrainer = new PokemonTrainer("Red", Team.INSTINCT, pokedex);
    }

    @Test
    public void shouldGetTrainer() {
        PokemonTrainer comparingTrainer = pokemonTrainerFactory.createTrainer("Red", Team.INSTINCT, pokedexFactory);

        assertEquals(pokemonTrainer.getName(), comparingTrainer.getName());
        assertEquals(pokemonTrainer.getTeam(), comparingTrainer.getTeam());
        assertEquals(pokemonTrainer.getPokedex().size(), comparingTrainer.getPokedex().size());
        assertEquals(pokemonTrainer.getPokedex().getPokemons(), comparingTrainer.getPokedex().getPokemons());
    }
}