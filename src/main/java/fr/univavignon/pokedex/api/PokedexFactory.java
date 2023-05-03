package fr.univavignon.pokedex.api;

/**
 *  PokemonFactory class.
 * */
public class PokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(
            IPokemonMetadataProvider metadataProvider,
            IPokemonFactory pokemonFactory
    ) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
