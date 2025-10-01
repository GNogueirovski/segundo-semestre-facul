package br.com.fiap.bo;

import br.com.fiap.dao.RemedioDAO;
import br.com.fiap.to.RemedioTO;

import java.util.ArrayList;

public class RemedioBO {
    private RemedioDAO remedioDAO;

    public ArrayList<RemedioTO> findAll(){

        return remedioDAO.findAll();
    }

}
