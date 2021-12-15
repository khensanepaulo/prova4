package controller;

import model.ModelGenero;
import DAO.DAOGenero;
import view.BibliotecaView;

import java.io.IOException;
import java.util.ArrayList;

import static controller.ControllerBiblioteca.obj;


public class ControllerGenero {

    private static DAOGenero daoGenero = new DAOGenero();
    private static ModelGenero pModelGenero;

    public static void cadastrargenero(boolean flEdit, int id) throws IOException, IOException {
        System.out.println("Nome do genero");
        String nome = obj.readLine();
        System.out.println("\n");
        System.out.println("genero salvo");
        daoGenero.salvarGeneroDAO(pModelGenero);
        BibliotecaView.menu();
    }

    public static void atualizarGeneroController() {
    }


    public int salvarGeneroController(ModelGenero pModelGenero){
        return this.daoGenero.salvarGeneroDAO(pModelGenero);
    }


    public ModelGenero getGeneroController(int pIdGenero){
        return this.daoGenero.getGeneroDAO(pIdGenero);
    }


    public ArrayList<ModelGenero> getListaGeneroController(){
        return this.daoGenero.getListaGeneroDAO();
    }


    public boolean atualizarGeneroController(ModelGenero pModelGenero){
        return this.daoGenero.atualizarGeneroDAO(pModelGenero);
    }


    public boolean excluirGeneroController(int pIdGenero){
        return this.daoGenero.excluirGeneroDAO(pIdGenero);
    }
}