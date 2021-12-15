package controller;

import model.Modellivro;
import DAO.DAOlivro;
import view.BibliotecaView;

import java.io.IOException;
import java.util.ArrayList;

import static controller.ControllerBiblioteca.obj;

public class Controllerlivro {

    private static DAOlivro daolivro;
    private static Modellivro pModellivro;

    public static void cadastrarlivro(boolean flEdit, int id) throws IOException, IOException {
        System.out.println("Nome do livro");
        String nome = obj.readLine();
        System.out.println("\n");
        System.out.println("livro ssalvo salva");
        daolivro.salvarlivroDAO(pModellivro);
        BibliotecaView.menu();

    }
    public static void printarlivros( Modellivro modellivro) {
        Modellivro livro = null;
        System.out.println("livro ID: " + livro.getIdlivro());
        System.out.println("nome: " + livro.getnome());
    }

    public static void listlivros(int id) {
        System.out.println("-----------------------------------------------");
        ArrayList<Modellivro> listamodellivro = new ArrayList();
        Modellivro modellivro = new Modellivro();

        for (livro : livros) {
            if (id == 0) {
                printarLivros(livro);
            }
            else {
                if (item.getIdItem() == id) {
                    printarProdutos(item);
                }
            }
        }

    }
    public static void listbybiblioteca(

            (int id) {
        System.out.println("-----------------------------------------------");
        ArrayList<Modellivro> listamodellivro = new ArrayList();
        Modellivro modellivro = new Modellivro();

        for (livro : livros) {
            if (id == 0) {
                printarLivros(livro);
            }
            else {
                if (item.getIdItem() == id) {
                    printarProdutos(item);
                }
            }
        }

    }
    public static void listbygenero(

            () {
        System.out.println("-----------------------------------------------");
        ArrayList<Modellivro> listamodellivro = new ArrayList();
        Modellivro modellivro = new Modellivro();

        for (livro : livros) {
            if (id == 0) {
                printarLivros(livro);
            }
            else {
                if (item.getIdItem() == id) {
                    printarProdutos(item);
                }
            }
        }

    }




    public int salvarlivroController(Modellivro pModellivro){
        return this.daolivro.salvarlivroDAO(pModellivro);
    }


    public Modellivro getlivroController(int pIdlivro){
        return this.daolivro.getlivroDAO(pIdlivro);
    }


    public ArrayList<Modellivro> getListalivroController(){
        return this.daolivro.getListalivroDAO();
    }


    public boolean atualizarlivroController(Modellivro pModellivro){
        return this.daolivro.atualizarlivroDAO(pModellivro);
    }


    public boolean excluirlivroController(int pIdlivro){
        return this.daolivro.excluirlivroDAO(pIdlivro);
    }
}