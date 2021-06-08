/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisaodm2021n.controles;

import java.sql.SQLException;
import java.util.List;
import revisaodm2021n.dados.Eletronico;
import revisaodm2021n.modelos.DaoEletronico;

public class ControleEletronico 
{
    static DaoEletronico daoEletronico;
    
    public ControleEletronico() throws SQLException, ClassNotFoundException 
    {
        daoEletronico = new DaoEletronico();
    }
    
    public Eletronico inserir(Eletronico eEntrada) throws SQLException 
    {
        return daoEletronico.inserir(eEntrada);
    }

    public List<Eletronico> listar(Eletronico eEntrada) throws SQLException
    {
        return daoEletronico.listar(eEntrada);
    }

    public Eletronico alterar(Eletronico eEntrada) throws SQLException 
    {
        return daoEletronico.alterar(eEntrada);
    }

    public Eletronico buscar(Eletronico eEntrada) throws SQLException 
    {
        return daoEletronico.buscar(eEntrada);
    }

    public Eletronico excluir(Eletronico eEntrada) throws SQLException 
    {
        return daoEletronico.excluir(eEntrada);
    }
    
    public List<Eletronico> getAll() throws SQLException 
    {
        return daoEletronico.getAll();
    }
}
