package revisaodm2021n.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import revisaodm2021n.dados.Cliente;
import revisaodm2021n.util.ConexaoDb;

public class DaoCliente
{
    private final Connection c;
   
    public DaoCliente() throws SQLException, ClassNotFoundException 
    {
        this.c = new ConexaoDb().getConnection();
    }
    
    public Cliente buscar(Cliente cliente) throws SQLException
    {
        String sql = "select * from cliente where cli_id = ?";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            stmt.setInt(1, cliente.getId());
            ResultSet rs = stmt.executeQuery();
            c.close();
            return new Cliente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3));          
        }
    }
    
    public Cliente inserir(Cliente cliente) throws SQLException
    {
        String sql = "insert into cliente (cli_nome, cli_idade) values (?,?)";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
             
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int id = rs.getInt(1);
            cliente.setId(id);
            c.close();
            return cliente;
        }
    }
    
    public Cliente alterar(Cliente cliente) throws SQLException
    {
        String sql = "update cliente set cli_nome = ?, cli_idade = ? where cli_id = ?";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getIdade());
            stmt.setInt(3, cliente.getId());
            stmt.execute();
        }
        c.close();
        return cliente;
    }
    
    public Cliente excluir(Cliente cliente) throws SQLException
    {
        String sql = "delete from cliente WHERE cli_id = ?";
        
        try (PreparedStatement stmt = c.prepareStatement(sql)) {           
            stmt.setInt(1, cliente.getId());            
            stmt.execute();
        }
        
        c.close();
        return cliente;
    }
    
    public List<Cliente> listar (Cliente cliente) throws SQLException
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "select * from cliente where cli_nome like ?";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            
            stmt.setString(1,"%" + cliente.getNome()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Cliente cSaida = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3));
                
                clientes.add(cSaida);
            }
            
            c.close();
        }
               
        return clientes;
    }
}
