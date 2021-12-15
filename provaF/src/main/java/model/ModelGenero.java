package model;

public class ModelGenero {

    private int IdGenero;
    private String nome;


    public ModelGenero(){}


    public void setIdGenero(int pIdGenero){
        this.IdGenero = pIdGenero;
    }

    public int getIdGenero(){
        return this.IdGenero;
    }


    public void setNome(String pNome){
        this.nome = pNome;
    }

    public String getNome(){
        return this.nome;
    }

    @Override
    public String toString(){
        return "ModelGenero {" + "::IdGenero = " + this.IdGenero + "::nome = " + this.nome +  "}";
    }
}