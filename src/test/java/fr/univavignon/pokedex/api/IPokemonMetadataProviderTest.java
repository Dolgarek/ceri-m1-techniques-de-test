package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    /*IPokemonMetadataProvider metaData = mock(IPokemonMetadataProvider.class);
    PokemonMetadata bulbizarre = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata aquali = new PokemonMetadata(133,"Aquali",186,168,260);

    @Before
    public void setUp(){
        try {
            when(metaData.getPokemonMetadata(0)).thenReturn(bulbizarre);
            when(metaData.getPokemonMetadata(133)).thenReturn(aquali);
        } catch (PokedexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMetaData() {
        try {
            PokemonMetadata testMetaData = metaData.getPokemonMetadata(0);
            assertEquals(0, testMetaData.getIndex());
            assertEquals("Bulbizarre", testMetaData.getName());
            assertEquals(126, testMetaData.getAttack());
            assertEquals(126, testMetaData.getDefense());
            assertEquals(90, testMetaData.getStamina());
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }*/

    IPokemonMetadataProvider pokemonMetadataProvider = PokemonMetadataProvider.getPokemonMetadataProvider();
    PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0,"Bulbizarre",126,126,90);
    PokemonMetadata aqualiMetadata = new PokemonMetadata(133,"Aquali",186,168,260);

    @BeforeEach
    public void setUp() {}

    @Test
    public void shouldGetBulbizarreMetadata() {
        try {
            PokemonMetadata testMetaData = pokemonMetadataProvider.getPokemonMetadata(0);
            assertEquals(bulbizarreMetadata.getIndex(), testMetaData.getIndex());
            assertEquals(bulbizarreMetadata.getName(), testMetaData.getName());
            assertEquals(bulbizarreMetadata.getAttack(), testMetaData.getAttack());
            assertEquals(bulbizarreMetadata.getDefense(), testMetaData.getDefense());
            assertEquals(bulbizarreMetadata.getStamina(), testMetaData.getStamina());
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }

    @Test
    public void shouldGetAqualiMetadata() {
        try {
            PokemonMetadata testMetaData = pokemonMetadataProvider.getPokemonMetadata(133);
            assertEquals(aqualiMetadata.getIndex(), testMetaData.getIndex());
            assertEquals(aqualiMetadata.getName(), testMetaData.getName());
            assertEquals(aqualiMetadata.getAttack(), testMetaData.getAttack());
            assertEquals(aqualiMetadata.getDefense(), testMetaData.getDefense());
            assertEquals(aqualiMetadata.getStamina(), testMetaData.getStamina());
        } catch (PokedexException e){
            e.printStackTrace();
        }
    }
}