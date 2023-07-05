
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        Connection con = c.getConnection();
        int op = 0;
        do{
            op = menu();
            try {
                switch (op) {
                    case 1: new FuncionariosController().createFuncionario(con);
                            break;
                    case 2: new ClientesController().createCliente(con);
                            break;
                    case 3: new FuncionariosController().listarFuncionarios(con);
                            break;
                    case 4: new ClientesController().listarClientes(con);
                            break;
                    case 5:
                            new ClientesController().listarClientesComFuncionarios(con);
                             break;
                     case 6:
                            new ClientesController().listarFuncionariosComQuantidadeClientes(con);
                              break;
                            
                   
                }
            }catch(SQLException ex) {
                //ex.printStackTrace();
                System.out.println(ex.getMessage());
                continue;
            }
        } while(op>0 && op<7);  
        con.close();
    }    
    
    private static int menu() {
        System.out.println("");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Inserir um novo Funcionario");
        System.out.println("2 - Inserir um novo Cliente");
        System.out.println("3 - Exibir todos os Funcionarios");
        System.out.println("4 - Exibir todos os Clientes");
        System.out.println("5 - Exibir Funcionarios que tambem sao clientes");
        System.out.println("6 - Exibir nome dos Funcinarios e quantos clientes registrou");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}
