package revisaodm2021n.telas.eletronico;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import revisaodm2021n.controles.ControleEletronico;
import revisaodm2021n.dados.Eletronico;

public class ManterEletronico 
{
    static int id;
    static String nome;
    static String descricao;
    static double valor;
    static String ano_de_lancamento;
    static int quantidade;
    static String ativo;
    static String marca;
    static String modelo;
    
    static ControleEletronico contEle;
    
    public static void Inserir() throws SQLException, ClassNotFoundException 
    {
        nome = JOptionPane.showInputDialog("NOME");
        descricao = JOptionPane.showInputDialog("DESCRICAO"); 
        valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR"));
        ano_de_lancamento = JOptionPane.showInputDialog("ANO DE LANCAMENTO");
        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        ativo = JOptionPane.showInputDialog("Ativo?");
        marca = JOptionPane.showInputDialog("Marca");
        modelo = JOptionPane.showInputDialog("Modelo");
        
        Eletronico eEntrada = new Eletronico(nome, descricao, valor, ano_de_lancamento, quantidade, ativo, marca, modelo);
        
        contEle = new ControleEletronico();
        Eletronico eSaida = contEle.inserir(eEntrada);
        
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
    
    public static void Alterar() throws SQLException, ClassNotFoundException
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        nome = JOptionPane.showInputDialog("NOME");
        descricao = JOptionPane.showInputDialog("DESCRICAO"); 
        valor = Double.parseDouble(JOptionPane.showInputDialog("VALOR"));
        ano_de_lancamento = JOptionPane.showInputDialog("ANO DE LANCAMENTO");
        quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
        ativo = JOptionPane.showInputDialog("Ativo?");
        marca = JOptionPane.showInputDialog("Marca");
        modelo = JOptionPane.showInputDialog("Modelo");
        
        Eletronico eEntrada = new Eletronico(id, nome, descricao, valor, ano_de_lancamento, quantidade, ativo, marca, modelo);

        contEle = new ControleEletronico();
        
        Eletronico eSaida = contEle.alterar(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
    
    public static void Listar() throws SQLException, ClassNotFoundException 
    {
        nome = JOptionPane.showInputDialog("NOME");
        Eletronico eEntrada = new Eletronico(nome);   
        contEle = new ControleEletronico();        
        List<Eletronico> eSaida = contEle.listar(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.get(0).toString());
    }
    
    public static void Buscar() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Eletronico eEntrada = new Eletronico(id);
        contEle = new ControleEletronico(); 
        Eletronico eSaida = contEle.buscar(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
    
    public static void Excluir() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Eletronico eEntrada = new Eletronico(id);
        contEle = new ControleEletronico(); 
        Eletronico eSaida = contEle.excluir(eEntrada);
        JOptionPane.showMessageDialog(null,eSaida.toString());
    }
}
