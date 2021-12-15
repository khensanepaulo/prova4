package view;

import controller.ControllerBiblioteca;
import controller.ControllerGenero;
import model.Modellivro;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static controller.ControllerBiblioteca.cadastrarbiblioteca;
import static controller.ControllerGenero.cadastrargenero;
import static controller.Controllerlivro.*;

public class BibliotecaView {
    static BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

    public static void menu() throws IOException {
        String option = "";

        do {
            System.out.println("A. CRUD biblioteca");
            System.out.println("B. Sair");

            try {
                option = obj.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("\n");

            switch (option.toUpperCase()) {
                case "A":
                    System.out.println("A. Cadastrar biblioteca");
                    System.out.println("B. Cadastrar generos");
                    System.out.println("C. Editar genero");
                    System.out.println("D. Cadastrar livro");
                    System.out.println("E. listar livro pelo id");
                    System.out.println("F. LISTAR TODOS OS LIVROS DE 1 BIBLIOTECA ESPECÍFICA");
                    System.out.println("G. LISTAR TODOS OS LIVROS DE DETERMINADO GÊNERO");
                    System.out.println("H. SAIR");

                    try {
                        option = obj.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("\n");

                    switch (option.toUpperCase()) {
                        case "A":
                            cadastrarbiblioteca(false , 0);
                            break;

                        case "B":
                             cadastrargenero(false , 0);
                            break;

                        case "C":
                           ControllerGenero.atualizarGeneroController();
                            break;

                        case "D":
                            cadastrarlivro(false, 0);
                            break;

                        case "E": listlivros(0);

                            break;

                        case "F": listbybiblioteca();
                            break;

                        case "G": ;listbygenero();
                            break;

                        case "H":
                            System.out.println(" saiu do sistema");
                            break;

                        default:
                            System.out.println("Opcao invalida");
                            break;
                    }
            }


        }
        while (!option.toUpperCase().equals("B")) ;
    }
}




