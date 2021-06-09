package revisaodm2021n.controles;

import java.sql.SQLException;
import java.util.List;
import revisaodm2021n.dados.Pedido;
import revisaodm2021n.modelos.DaoPedido;

public class ControlePedido
{
    static DaoPedido daoPedido;
    
    public ControlePedido() throws SQLException, ClassNotFoundException 
    {
        this.daoPedido = new DaoPedido();
    }
    
    public Pedido inserir(Pedido pedido) throws SQLException 
    {
        return daoPedido.inserir(pedido);
    }

    public List<Pedido> listar(Pedido pedido) throws SQLException
    {
        return daoPedido.listar(pedido);
    }

    public Pedido alterar(Pedido pedido) throws SQLException 
    {
        return daoPedido.alterar(pedido);
    }

    public Pedido buscar(Pedido pedido) throws SQLException 
    {
        return daoPedido.buscar(pedido);
    }

    public Pedido excluir(Pedido pedido) throws SQLException 
    {
        return daoPedido.excluir(pedido);
    }
    
    public List<Pedido> getAll() throws SQLException 
    {
        return daoPedido.getAll();
    }
}
