package controller;

import model.ModelBiblioteca;
import DAO.DAOBiblioteca;
import view.BibliotecaView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ControllerBiblioteca {

    private static DAOBiblioteca daoBiblioteca = new DAOBiblioteca();
    static BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
    private static ModelBiblioteca pModelBiblioteca;

    public static void cadastrarbiblioteca(boolean flEdit, int id) throws IOException, IOException {
        System.out.println("Nome da biblioteca");
        String nome = obj.readLine();
        System.out.println("\n");
        System.out.println("biblioteca salva");
        daoBiblioteca.salvarBibliotecaDAO(pModelBiblioteca);
        BibliotecaView.menu();

    }

    public void salvarBibliotecaController(ModelBiblioteca pModelBiblioteca){
        this.daoBiblioteca.salvarBibliotecaDAO(pModelBiblioteca);
    }

    public ModelBiblioteca getBibliotecaController(int pIdBiblioteca){
        return this.daoBiblioteca.getBibliotecaDAO(pIdBiblioteca);
    }

    public ArrayList<ModelBiblioteca> getListaBibliotecaController(){
        return this.daoBiblioteca.getListaBibliotecaDAO();
    }

    public boolean atualizarBibliotecaController(ModelBiblioteca pModelBiblioteca){
        return this.daoBiblioteca.atualizarBibliotecaDAO(pModelBiblioteca);
    }

    public boolean excluirBibliotecaController(int pIdBiblioteca){
        return this.daoBiblioteca.excluirBibliotecaDAO(pIdBiblioteca);
    }
}