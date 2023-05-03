package fr.univavignon.pokedex.api;

/**
 *  PokemonFactory class.
 * */
public class PokemonFactory implements IPokemonFactory {

    public PokemonFactory() {}

    @Override
    public Pokemon createPokemon(
            int index,
            int cp,
            int hp,
            int dust,
            int candy
    ) throws PokedexException {
        PokemonMetadata pokemonMetadata =
                PokemonMetadataProvider.getPokemonMetadataProvider().getPokemonMetadata(index);
        return new Pokemon(
                index,
                pokemonMetadata.getName(),
                pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(),
                pokemonMetadata.getStamina(),
                cp,
                hp,
                dust,
                candy,
                (Math.random() * 100)
        );
    }
}
