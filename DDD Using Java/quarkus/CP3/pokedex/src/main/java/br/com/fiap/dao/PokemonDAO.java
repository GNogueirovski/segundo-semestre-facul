package br.com.fiap.dao;

import br.com.fiap.to.PokemonTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonDAO {
    public ArrayList<PokemonTO> findAll() {
        ArrayList<PokemonTO> pokemons = new ArrayList<>();
        PokemonTO pokemon = new PokemonTO(1L, "Pikachu", 0.4, 6.0, "Elétrico", LocalDate.parse("2024-10-03"));
        pokemons.add(pokemon);
        pokemon = new PokemonTO(2L, "Onix", 8.8, 210.0, "Pedra", LocalDate.parse("2023-10-03"));
        pokemons.add(pokemon);
        pokemon = new PokemonTO(3L, "Charizard", 1.7, 90.5, "Fogo/Voador", LocalDate.parse("2024-05-15"));
        pokemons.add(pokemon);
        pokemon = new PokemonTO(4L, "Bulbasaur", 0.7, 6.9, "Planta/Veneno", LocalDate.parse("2023-08-21"));
        pokemons.add(pokemon);
        return pokemons;
    }


    public PokemonTO save(PokemonTO pokemon){

        String sql = "insert into ddd_pokedex (nome, altura, peso, categoria, data_de_captura) values (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)){
            ps.setString(1, pokemon.getNome());
            ps.setDouble(2, pokemon.getAltura());
            ps.setDouble(3, pokemon.getPeso());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDaCaptura()));
            if (ps.executeUpdate() > 0){
                return pokemon;
            }else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
