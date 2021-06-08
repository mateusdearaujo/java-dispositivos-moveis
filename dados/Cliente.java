package revisaodm2021n.dados;

public class Cliente 
{
    private int id;
    private String nome;
    private int idade;
    
    public Cliente(int id)
    {
        this.id = id;
    }
    
    public Cliente(String nome)
    {
        this.nome = nome;
    }
        
    public Cliente(String nome, int idade)
    {
        this.nome = nome;
        this.idade = idade;
    }
    
    public Cliente(int id, String nome, int idade)
    {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
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

    public int getIdade()
    {
        return idade;
    }

    public void setIdade(int idade) 
    {
        this.idade = idade;
    }
    
    @Override
    public String toString()
    {
        return "Cliente{" + "id=" + this.id + ", nome=" + this.nome + ", idade=" + this.idade + '"' + '}';
    }
}
