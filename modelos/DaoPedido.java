package revisaodm2021n.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import revisaodm2021n.dados.Pedido;
import revisaodm2021n.util.ConexaoDb;

public class DaoPedido 
{
    private final Connection c;
   
    public DaoPedido() throws SQLException, ClassNotFoundException 
    {
        this.c = new ConexaoDb().getConnection();
    }
    
    public Pedido buscar(Pedido pedido) throws SQLException
    {
        String sql = "select * from pedido where pe_id = ?";
        Pedido retorno;
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getId());
            ResultSet rs = stmt.executeQuery();            
            retorno = null;           
            while (rs.next()) {
                retorno = new Pedido(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4)); 
            }
            c.close();
            return retorno;         
        }
    }
    
    public Pedido inserir(Pedido pedido) throws SQLException
    {
        String sql = "insert into pedido (pe_ele_id, pe_cli_id, pe_data) values (?,?,?)";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, pedido.getEle_id());
            stmt.setInt(2, pedido.getCli_id());
            stmt.setString(3, pedido.getData());
             
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();            
          
            if (rs.next()) {
                int id = rs.getInt(1);
                pedido.setId(id);
            }
            
            c.close();
            return pedido;
        }
    }
    
    public Pedido alterar(Pedido pedido) throws SQLException
    {
        String sql = "update pedido set pe_ele_id = ?, pe_cli_id = ?, pe_data = ? where pe_id = ?";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, pedido.getEle_id());
            stmt.setInt(2, pedido.getCli_id());
            stmt.setString(3, pedido.getData());
            stmt.setInt(4, pedido.getId());
            stmt.execute();
        }
        c.close();
        return pedido;
    }
    
    public Pedido excluir(Pedido pedido) throws SQLException
    {
        String sql = "delete from pedido WHERE pe_id = ?";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {           
            stmt.setInt(1, pedido.getId());            
            stmt.execute();
        }
        
        c.close();
        return pedido;
    }
    
    public List<Pedido> listar (Pedido pedido) throws SQLException
    {
        List<Pedido> pedidos = new ArrayList<>();
        String sql = "select * from pedido where pe_data like ?";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            
            stmt.setString(1,"%" + pedido.getData()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Pedido cSaida = new Pedido(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4));
                
                pedidos.add(cSaida);
            }
            
            c.close();
        }
               
        return pedidos;
    }
}
