/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author matheus
 */
public class BancoJPA {

    public static EntityManagerFactory conexao = null;
    public EntityManager sessao;
    
    private final String nomeArqPersistence = "JPADuasTaPU";

    public BancoJPA() throws Exception {
        try {
            if ((conexao == null) || (!conexao.isOpen())) {
                conexao = Persistence.createEntityManagerFactory(nomeArqPersistence);
            }
            sessao = conexao.createEntityManager();
    
        } catch (Exception ex) {
            throw new Exception("Erro de conexão: " + ex.getMessage());
        }
    }

}
