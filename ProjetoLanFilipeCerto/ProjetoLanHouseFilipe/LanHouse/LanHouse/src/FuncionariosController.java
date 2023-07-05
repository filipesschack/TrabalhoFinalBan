import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FuncionariosController {
    
    public void createFuncionario(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo funcionário: ");
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        FuncionariosBean funcionario = new FuncionariosBean(0, cpf, nome, telefone); // ID definido como 0
        FuncionariosModel.create(funcionario, con);
        System.out.println("Funcionário criado com sucesso!!");
    }

    void listarFuncionarios(Connection con) throws SQLException {
        HashSet<FuncionariosBean> all = FuncionariosModel.listAll(con);
        Iterator<FuncionariosBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}
