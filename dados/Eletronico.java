package revisaodm2021n.dados;

public class Eletronico 
{
    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private String ano_de_lancamento;
    private int quantidade;
    private String ativo;
    private String marca;
    private String modelo;
    
    public Eletronico(int id)
    {
        this.id = id;
    }
    
    public Eletronico(String nome)
    {
        this.nome = nome;
    }
    
    public Eletronico(String nome, String descricao, double valor, String ano_de_lancamento, int quantidade, String ativo, String marca, String modelo)
    {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.ano_de_lancamento = ano_de_lancamento;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public Eletronico(int id, String nome, String descricao, double valor, String ano_de_lancamento, int quantidade, String ativo, String marca, String modelo)
    {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.ano_de_lancamento = ano_de_lancamento;
        this.quantidade = quantidade;
        this.ativo = ativo;
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public double getValor()
    {
        return valor;
    }

    public void setValor(double valor) 
    {
        this.valor = valor;
    }

    public String getAno_de_lancamento() 
    {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(String ano_de_lancamento) 
    {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public int getQuantidade() 
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public String getAtivo()
    {
        return ativo;
    }

    public void setAtivo(String ativo)
    {
        this.ativo = ativo;
    }

    public String getMarca()
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }
    
    @Override
    public String toString()
    {
        return "Eletronico{" + "id=" + this.id + ", nome=" + this.nome + ", descricao=" + this.descricao +
                ", valor=" + this.valor + ", ano_de_lancamento=" + this.ano_de_lancamento +
                ", quantidade=" + this.quantidade + ", ativo=" + this.ativo + ", marca=" + this.marca +
                ", modelo=" + this.modelo + '"' + '}';
    }
}
