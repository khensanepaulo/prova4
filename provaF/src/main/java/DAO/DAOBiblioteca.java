package DAO;

import model.ModelBiblioteca;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
public class DAOBiblioteca extends ConexaoMySql {

    public int salvarBibliotecaDAO(ModelBiblioteca pModelBiblioteca){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_biblioteca ("
                    + "pk__id_biblioteca,"
                    + "nome"
                + ") VALUES ("
                    + "'" + pModelBiblioteca.getIdBiblioteca() + "',"
                    + "'" + pModelBiblioteca.getNome() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    public ModelBiblioteca getBibliotecaDAO(int pIdBiblioteca){
        ModelBiblioteca modelBiblioteca = new ModelBiblioteca();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__id_biblioteca,"
                    + "nome"
                 + " FROM"
                     + " tbl_biblioteca"
                 + " WHERE"
                     + " pk__id_biblioteca = '" + pIdBiblioteca + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBiblioteca.setIdBiblioteca(this.getResultSet().getInt(1));
                modelBiblioteca.setNome(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelBiblioteca;
    }

    public ArrayList<ModelBiblioteca> getListaBibliotecaDAO(){
        ArrayList<ModelBiblioteca> listamodelBiblioteca = new ArrayList();
        ModelBiblioteca modelBiblioteca = new ModelBiblioteca();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk__id_biblioteca,"
                    + "nome"
                 + " FROM"
                     + " tbl_biblioteca"
                + ";"
            );

            while(this.getResultSet().next()){
                modelBiblioteca = new ModelBiblioteca();
                modelBiblioteca.setIdBiblioteca(this.getResultSet().getInt(1));
                modelBiblioteca.setNome(this.getResultSet().getString(2));
                listamodelBiblioteca.add(modelBiblioteca);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelBiblioteca;
    }


    public boolean atualizarBibliotecaDAO(ModelBiblioteca pModelBiblioteca){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_biblioteca SET "
                    + "pk__id_biblioteca = '" + pModelBiblioteca.getIdBiblioteca() + "',"
                    + "nome = '" + pModelBiblioteca.getNome() + "'"
                + " WHERE "
                    + "pk__id_biblioteca = '" + pModelBiblioteca.getIdBiblioteca() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }


    public boolean excluirBibliotecaDAO(int pIdBiblioteca){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_biblioteca "
                + " WHERE "
                    + "pk__id_biblioteca = '" + pIdBiblioteca + "'"
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