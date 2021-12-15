package DAO;

import model.Modellivro;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

public class DAOlivro extends ConexaoMySql {


    public int salvarlivroDAO(Modellivro pModellivro){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_livro ("
                    + "pk__idlivro,"
                    + "nome,"
                    + "autor"
                + ") VALUES ("
                    + "'" + pModellivro.getIdlivro() + "',"
                    + "'" + pModellivro.getNome() + "',"
                    + "'" + pModellivro.getAutor() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }


    public Modellivro getlivroDAO(int pIdlivro){
        Modellivro modellivro = new Modellivro();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__idlivro,"
                    + "nome,"
                    + "autor"
                 + " FROM"
                     + " tbl_livro"
                 + " WHERE"
                     + " pk__idlivro = '" + pIdlivro + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modellivro.setIdlivro(this.getResultSet().getInt(1));
                modellivro.setNome(this.getResultSet().getString(2));
                modellivro.setAutor(this.getResultSet().getString(3));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modellivro;
    }


    public ArrayList<Modellivro> getListalivroDAO(){
        ArrayList<Modellivro> listamodellivro = new ArrayList();
        Modellivro modellivro = new Modellivro();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__idlivro,"
                    + "nome,"
                    + "autor"
                 + " FROM"
                     + " tbl_livro"
                + ";"
            );

            while(this.getResultSet().next()){
                modellivro = new Modellivro();
                modellivro.setIdlivro(this.getResultSet().getInt(1));
                modellivro.setNome(this.getResultSet().getString(2));
                modellivro.setAutor(this.getResultSet().getString(3));
                listamodellivro.add(modellivro);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodellivro;
    }


    public boolean atualizarlivroDAO(Modellivro pModellivro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_livro SET "
                    + "pk__idlivro = '" + pModellivro.getIdlivro() + "',"
                    + "nome = '" + pModellivro.getNome() + "',"
                    + "autor = '" + pModellivro.getAutor() + "'"
                + " WHERE "
                    + "pk__idlivro = '" + pModellivro.getIdlivro() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }


    public boolean excluirlivroDAO(int pIdlivro){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_livro "
                + " WHERE "
                    + "pk__idlivro = '" + pIdlivro + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}