package revisaodm2021n.telas.cliente;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import revisaodm2021n.controles.ControleCliente;
import revisaodm2021n.dados.Cliente;

public class ManterCliente {
    static int id;
    static String nome;
    static int idade;
   
    static ControleCliente contCli;
    
    public static void Inserir() throws SQLException, ClassNotFoundException 
    {
        nome = JOptionPane.showInputDialog("NOME");
        idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE"));       
        Cliente cEntrada = new Cliente(nome, idade);       
        contCli = new ControleCliente();
        Cliente cSaida = contCli.inserir(cEntrada);
        JOptionPane.showMessageDialog(null, cSaida.toString());
    }
    
    public static void Alterar() throws SQLException, ClassNotFoundException
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        nome = JOptionPane.showInputDialog("NOME");
        idade = Integer.parseInt(JOptionPane.showInputDialog("IDADE"));        
        Cliente cEntrada = new Cliente(id, nome, idade);        
        contCli = new ControleCliente();       
        Cliente cSaida = contCli.alterar(cEntrada);
        JOptionPane.showMessageDialog(null, cSaida.toString());
    }
    
    public static void Listar() throws SQLException, ClassNotFoundException 
    {
        nome = JOptionPane.showInputDialog("NOME");
        Cliente cEntrada = new Cliente(nome);
        contCli = new ControleCliente();
        List<Cliente> cSaida = contCli.listar(cEntrada);
        JOptionPane.showMessageDialog(null, cSaida.get(0).toString());
    }
    
    public static void Buscar() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cEntrada = new Cliente(id);
        contCli = new ControleCliente();
        Cliente cSaida = contCli.buscar(cEntrada);
        JOptionPane.showMessageDialog(null, cSaida.toString());
    }
    
    public static void Excluir() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Cliente cEntrada = new Cliente(id);
        contCli = new ControleCliente();
        Cliente cSaida = contCli.excluir(cEntrada);
        JOptionPane.showMessageDialog(null, cSaida.toString());
    }
}
