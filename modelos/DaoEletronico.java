package revisaodm2021n.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import revisaodm2021n.dados.Eletronico;
import revisaodm2021n.util.ConexaoDb;

public class DaoEletronico 
{
    private final Connection c;
   
    public DaoEletronico() throws SQLException, ClassNotFoundException 
    {
        this.c = new ConexaoDb().getConnection();
    }
    
    public Eletronico buscar(Eletronico e) throws SQLException
    {
        String sql = "select * from eletronico WHERE ele_id = ?";
        Eletronico retorno;
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {

        stmt.setInt(1,e.getId());
        
        ResultSet rs = stmt.executeQuery();
            retorno = null;
            while (rs.next()) {
                
                retorno = new Eletronico(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
            }
         
        }        
        c.close();        
        return retorno;
    }
    
    public Eletronico inserir(Eletronico e) throws SQLException
    {
        String sql = "insert into eletronico (ele_nome, ele_descricao, ele_valor, ele_ano_de_lancamento, ele_quantidade, ele_ativo, ele_marca, ele_modelo) values (?,?,?,?,?,?,?,?)";
    
        try (
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getDescricao());
            stmt.setDouble(3, e.getValor());
            stmt.setString(4, e.getAno_de_lancamento());
            stmt.setInt(5, e.getQuantidade());
            stmt.setString(6, e.getAtivo());
            stmt.setString(7, e.getMarca());
            stmt.setString(8, e.getModelo()); 
            
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                e.setId(id);
            }
        }
        c.close();
        return e;
    }
    
    public Eletronico alterar (Eletronico e) throws SQLException 
    {
        String sql = "UPDATE eletronico SET ele_nome = ?, ele_descricao = ?, ele_valor = ?, ele_ano_de_lancamento = ?, ele_quantidade = ?, ele_ativo = ?, ele_marca = ?, ele_modelo = ? WHERE ele_id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getDescricao());
            stmt.setDouble(3, e.getValor());
            stmt.setString(4, e.getAno_de_lancamento());
            stmt.setInt(5, e.getQuantidade());
            stmt.setString(6, e.getAtivo());
            stmt.setString(7, e.getMarca());
            stmt.setString(8, e.getModelo()); 
            stmt.setInt(9, e.getId());
            
            stmt.execute();
        }
        return e;
    }
    
    public Eletronico excluir (Eletronico e) throws SQLException 
    {
        String sql = "delete from eletronico WHERE ele_id = ?";

        try (PreparedStatement stmt = c.prepareStatement(sql)) {
            
            stmt.setInt(1,e.getId());
            
            stmt.execute();
        }
        c.close();
        return e;
    }
    
    public List<Eletronico> listar (Eletronico e) throws SQLException
    {
        List<Eletronico> eletronicos = new ArrayList<>();
        String sql = "select * from eletronico where ele_nome like ?";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            
            stmt.setString(1,"%" + e.getNome()+ "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Eletronico eSaida = new Eletronico(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                
                eletronicos.add(eSaida);
            }
            
            rs.close();
        }
               
        return eletronicos;
    }
    
        
    public List<Eletronico> getAll () throws SQLException
    {
        List<Eletronico> eletronicos = new ArrayList<>();
        String sql = "select * from eletronico";
        
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Eletronico eSaida = new Eletronico(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                
                eletronicos.add(eSaida);
            }
            
            rs.close();
        }
        return eletronicos;
    }
}
