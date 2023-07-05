import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ClientesModel {
    
    
    
    static void create(ClientesBean c, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO cliente (cpf, nome, endereco, telefone, dataCadastro, idFuncionario) "
                + "VALUES (?,?,?,?,?,CAST(? AS INTEGER))");
        st.setString(1, c.getCpf());
        st.setString(2, c.getNome());
        st.setString(3, c.getEndereco());
        st.setString(4, c.getTelefone());
        st.setString(5, c.getDataCadastro());
        st.setString(6, c.getIdFuncionario());
        st.execute();
        st.close();
    }

    static HashSet<ClientesBean> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<ClientesBean> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT cpf, nome, endereco, telefone, dataCadastro, idFuncionario FROM cliente";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new ClientesBean(result.getString(1), result.getString(2), result.getString(3),
                    result.getString(4), result.getString(5), result.getString(6)));
        }
        return list;
    }
    
    static HashSet<String> listarClientesComFuncionarios(Connection con) throws SQLException {
        Statement st;
        HashSet<String> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT c.nome " +
                     "FROM Cliente c " +
                     "JOIN Funcionario f ON c.CPF = f.CPF";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(result.getString(1));
        }
        return list;
    }
    
     static List<String> listarFuncionariosComQuantidadeClientes(Connection con) throws SQLException {
        Statement st;
        List<String> resultList = new ArrayList<>();
        st = con.createStatement();
        String sql = "SELECT f.nome AS nome_funcionario, COUNT(c.CPF) AS quantidade_clientes " +
                     "FROM Funcionario f " +
                     "LEFT JOIN (SELECT idFuncionario, CPF FROM Cliente) c ON f.idFuncionario = c.idFuncionario " +
                     "GROUP BY f.nome " +
                     "ORDER BY quantidade_clientes ASC";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            String nomeFuncionario = result.getString("nome_funcionario");
            int quantidadeClientes = result.getInt("quantidade_clientes");
            String resultado = "Nome do Funcionário: " + nomeFuncionario + ", Qnt Clientes cadastrados: " + quantidadeClientes;
            resultList.add(resultado);
        }
        return resultList;
    }
    
    
    
}
