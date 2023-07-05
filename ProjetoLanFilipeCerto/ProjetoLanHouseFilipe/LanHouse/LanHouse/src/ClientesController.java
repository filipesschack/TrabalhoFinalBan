import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClientesController {
    public void createCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo cliente: ");
        System.out.print("CPF: ");
        String cpf = input.nextLine();
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Endereço: ");
        String endereco = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        System.out.print("Data de Cadastro: ");
        String dataCadastro = input.nextLine();
        System.out.print("ID do Funcionário: ");
        String idFuncionario = input.nextLine();
        
        ClientesBean cb = new ClientesBean(cpf, nome, endereco, telefone, dataCadastro, idFuncionario);
        ClientesModel.create(cb, con);
        System.out.println("Cliente criado com sucesso!!");
    }

    void listarClientes(Connection con) throws SQLException {
        HashSet<ClientesBean> all = ClientesModel.listAll(con);
        Iterator<ClientesBean> it = all.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    void listarClientesComFuncionarios(Connection con) throws SQLException {
        HashSet<String> all = ClientesModel.listarClientesComFuncionarios(con);
        Iterator<String> it = all.iterator();
        while (it.hasNext()) {
            System.out.println("Nome: " + it.next());
        }
        
    }
    
    void listarFuncionariosComQuantidadeClientes(Connection con) throws SQLException {
        List<String> resultList = ClientesModel.listarFuncionariosComQuantidadeClientes(con);
        for (String resultado : resultList) {
            System.out.println(resultado);
        }
        
    }
    
}
