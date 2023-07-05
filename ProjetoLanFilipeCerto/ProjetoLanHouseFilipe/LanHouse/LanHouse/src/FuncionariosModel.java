import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class FuncionariosModel {

    public static void create(FuncionariosBean funcionario, Connection con) throws SQLException {
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO funcionario (CPF, nome, telefone) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
        st.setString(1, funcionario.getCPF());
        st.setString(2, funcionario.getNome());
        st.setString(3, funcionario.getTelefone());
        st.execute();

        ResultSet generatedKeys = st.getGeneratedKeys();
        if (generatedKeys.next()) {
            funcionario.setIdFuncionario(generatedKeys.getInt(1));
        }

        st.close();
    }

    static HashSet<FuncionariosBean> listAll(Connection con) throws SQLException {
        Statement st;
        HashSet<FuncionariosBean> list = new HashSet<>();
        st = con.createStatement();
        String sql = "SELECT idFuncionario, CPF, nome, telefone FROM funcionario";
        ResultSet result = st.executeQuery(sql);
        while (result.next()) {
            list.add(new FuncionariosBean(result.getInt(1), result.getString(2), result.getString(3), result.getString(4)));
        }
        return list;
    }
}
