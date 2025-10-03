package br.com.fiap.bo;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.to.PokemonTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonBO {
    private PokemonDAO pokemonDAO;

    public ArrayList<PokemonTO> findAll() {
        pokemonDAO = new PokemonDAO();
        // aqui se implementa as regras de negócios
        return pokemonDAO.findAll();
    }
    public PokemonTO save (PokemonTO pokemonTO){
        pokemonDAO = new PokemonDAO();

        // verifica se a data de captura está no futuro
        if (pokemonTO.getDataDaCaptura().isAfter(LocalDate.now())){
            return null;
        }
        return pokemonDAO.save(pokemonTO);
    }

}
