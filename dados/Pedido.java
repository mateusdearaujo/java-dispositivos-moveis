package revisaodm2021n.dados;

public class Pedido 
{
    private int id;
    private int ele_id;
    private int cli_id;
    private String data;
    
    public Pedido(int id) 
    {
        this.id = id;
    }
    
    public Pedido(String data) 
    {
        this.data = data;
    }
    
    public Pedido(int ele_id, int cli_id, String data) 
    {
        this.ele_id = ele_id;
        this.cli_id = cli_id;
        this.data = data;
    }
    
    public Pedido(int id, int ele_id, int cli_id, String data) 
    {
        this.id = id;
        this.ele_id = ele_id;
        this.cli_id = cli_id;
        this.data = data;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getEle_id()
    {
        return ele_id;
    }

    public void setEle_id(int ele_id) 
    {
        this.ele_id = ele_id;
    }

    public int getCli_id()
    {
        return cli_id;
    }

    public void setCli_id(int cli_id)
    {
        this.cli_id = cli_id;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }
    
    @Override
    public String toString()
    {
        return "Pedido{" + "id=" + this.id + ", ele_id=" + this.ele_id + ", cli_id=" + this.cli_id + '"' + ". cli_id=" + this.cli_id + '"' + '}';
    }
}
