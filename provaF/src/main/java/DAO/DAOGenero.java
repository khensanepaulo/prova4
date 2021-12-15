package DAO;

import model.ModelGenero;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

public class DAOGenero extends ConexaoMySql {


    public int salvarGeneroDAO(ModelGenero pModelGenero){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_genero ("
                    + "pk__id_genero,"
                    + "nome"
                + ") VALUES ("
                    + "'" + pModelGenero.getIdGenero() + "',"
                    + "'" + pModelGenero.getNome() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }


    public ModelGenero getGeneroDAO(int pIdGenero){
        ModelGenero modelGenero = new ModelGenero();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__id_genero,"
                    + "nome"
                 + " FROM"
                     + " tbl_genero"
                 + " WHERE"
                     + " pk__id_genero = '" + pIdGenero + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelGenero.setIdGenero(this.getResultSet().getInt(1));
                modelGenero.setNome(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelGenero;
    }


    public ArrayList<ModelGenero> getListaGeneroDAO(){
        ArrayList<ModelGenero> listamodelGenero = new ArrayList();
        ModelGenero modelGenero = new ModelGenero();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__id_genero,"
                    + "nome"
                 + " FROM"
                     + " tbl_genero"
                + ";"
            );

            while(this.getResultSet().next()){
                modelGenero = new ModelGenero();
                modelGenero.setIdGenero(this.getResultSet().getInt(1));
                modelGenero.setNome(this.getResultSet().getString(2));
                listamodelGenero.add(modelGenero);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelGenero;
    }


    public boolean atualizarGeneroDAO(ModelGenero pModelGenero){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_genero SET "
                    + "pk__id_genero = '" + pModelGenero.getIdGenero() + "',"
                    + "nome = '" + pModelGenero.getNome() + "'"
                + " WHERE "
                    + "pk__id_genero = '" + pModelGenero.getIdGenero() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }


    public boolean excluirGeneroDAO(int pIdGenero){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_genero "
                + " WHERE "
                    + "pk__id_genero = '" + pIdGenero + "'"
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