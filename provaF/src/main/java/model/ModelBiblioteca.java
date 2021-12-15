package model;
public class ModelBiblioteca {

    private int IdBiblioteca;
    private String nome;

    public ModelBiblioteca(){}

    public void setIdBiblioteca(int pIdBiblioteca){
        this.IdBiblioteca = pIdBiblioteca;
    }
    public int getIdBiblioteca(){
        return this.IdBiblioteca;
    }

    public void setNome(String pNome){
        this.nome = pNome;
    }
    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "ModelBiblioteca {" + "::IdBiblioteca = " + this.IdBiblioteca + "::nome = " + this.nome +  "}";
    }
}