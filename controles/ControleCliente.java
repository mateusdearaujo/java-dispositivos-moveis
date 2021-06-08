package revisaodm2021n.controles;

import java.sql.SQLException;
import java.util.List;
import revisaodm2021n.dados.Cliente;
import revisaodm2021n.modelos.DaoCliente;

public class ControleCliente 
{
    static DaoCliente daoCliente;
    
    public ControleCliente() throws SQLException, ClassNotFoundException 
    {
        this.daoCliente = new DaoCliente();
    }
    
    public Cliente inserir(Cliente eEntrada) throws SQLException 
    {
        return daoCliente.inserir(eEntrada);
    }

    public List<Cliente> listar(Cliente eEntrada) throws SQLException
    {
        return daoCliente.listar(eEntrada);
    }

    public Cliente alterar(Cliente eEntrada) throws SQLException 
    {
        return daoCliente.alterar(eEntrada);
    }

    public Cliente buscar(Cliente eEntrada) throws SQLException 
    {
        return daoCliente.buscar(eEntrada);
    }

    public Cliente excluir(Cliente eEntrada) throws SQLException 
    {
        return daoCliente.excluir(eEntrada);
    }
}
