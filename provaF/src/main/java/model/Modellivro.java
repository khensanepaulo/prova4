package model;

public class Modellivro {

    private int Idlivro;
    private String nome;
    private String autor;


    public Modellivro(){}


    public void setIdlivro(int pIdlivro){
        this.Idlivro = pIdlivro;
    }

    public int getIdlivro(){
        return this.Idlivro;
    }


    public void setNome(String pNome){
        this.nome = pNome;
    }

    public String getNome(){
        return this.nome;
    }


    public void setAutor(String pAutor){
        this.autor = pAutor;
    }

    public String getAutor(){
        return this.autor;
    }

    @Override
    public String toString(){
        return "Modellivro {" + "::Idlivro = " + this.Idlivro + "::nome = " + this.nome + "::autor = " + this.autor +  "}";
    }
}