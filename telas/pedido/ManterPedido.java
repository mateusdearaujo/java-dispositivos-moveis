package revisaodm2021n.telas.pedido;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import revisaodm2021n.controles.ControlePedido;
import revisaodm2021n.dados.Pedido;

public class ManterPedido {
    static int id;
    static int ele_id;
    static int cli_id;
    static String data;
    
    static ControlePedido contPed;
    
    public static void Inserir() throws SQLException, ClassNotFoundException 
    {
       ele_id = Integer.parseInt(JOptionPane.showInputDialog("ID ELETRONICO"));
       cli_id = Integer.parseInt(JOptionPane.showInputDialog("ID CLIENTE"));
       data = JOptionPane.showInputDialog("DATA");
       Pedido pEntrada = new Pedido(ele_id, cli_id, data);
       contPed = new ControlePedido();
       Pedido pSaida = contPed.inserir(pEntrada);
       JOptionPane.showMessageDialog(null, pSaida.toString());
    }
    
    public static void Alterar() throws SQLException, ClassNotFoundException
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        ele_id = Integer.parseInt(JOptionPane.showInputDialog("ID ELETRONICO"));
        cli_id = Integer.parseInt(JOptionPane.showInputDialog("ID CLIENTE"));
        data = JOptionPane.showInputDialog("DATA");
        Pedido pEntrada = new Pedido(id, ele_id, cli_id, data);
        contPed = new ControlePedido();
        Pedido pSaida = contPed.alterar(pEntrada);
        JOptionPane.showMessageDialog(null, pSaida.toString());
    }
    
    public static void Listar() throws SQLException, ClassNotFoundException 
    {
        data = JOptionPane.showInputDialog("DATA");
        Pedido pEntrada = new Pedido(data);
        contPed = new ControlePedido();
        List<Pedido> pSaida = contPed.listar(pEntrada);
        JOptionPane.showMessageDialog(null, pSaida.get(0).toString());
    }
    
    public static void Buscar() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido pEntrada = new Pedido(id);
        contPed = new ControlePedido();
        Pedido pSaida = contPed.buscar(pEntrada);
        JOptionPane.showMessageDialog(null, pSaida.toString());
    }
    
    public static void Excluir() throws SQLException, ClassNotFoundException 
    {
        id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido pEntrada = new Pedido(id);
        contPed = new ControlePedido();
        Pedido pSaida = contPed.excluir(pEntrada);
        JOptionPane.showMessageDialog(null, pSaida.toString());
    }
}
