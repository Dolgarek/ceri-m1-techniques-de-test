package fr.univavignon.pokedex.api;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Pokedex implements IPokedex{

    private List<Pokemon> pokemons;

    private IPokemonMetadataProvider iPokemonMetadataProvider;

    private IPokemonFactory iPokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.iPokemonMetadataProvider = metadataProvider;
        this.iPokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        return this.pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < this.pokemons.size()) {
            return this.pokemons.get(id);
        }
        else {
            throw new PokedexException("Aucun pokemon avec cet index dans le Pokedex !");
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(this.pokemons);
        sortedPokemons.sort(order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return this.iPokemonFactory.createPokemon(index, cp, hp,  dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.iPokemonMetadataProvider.getPokemonMetadata(index);
    }
}
