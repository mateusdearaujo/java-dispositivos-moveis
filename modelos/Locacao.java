package revisaodm2021n.modelos;

import java.util.Date;

public abstract class Locacao
{
    private Date datalocacao;
    private Date dataevolucao;
    private double precototal;
    private int qtdedias;
    
    private void incluir(){};
    private void baixar(){};
}
