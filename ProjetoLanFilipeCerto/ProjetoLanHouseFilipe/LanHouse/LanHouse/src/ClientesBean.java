import java.util.HashSet;
import java.util.Iterator;

public class ClientesBean {
   private String cpf;
   private String nome;
   private String endereco;
   private String telefone;
   private String dataCadastro;
   private String idFuncionario;
   
   public ClientesBean(String cpf, String nome, String endereco, String telefone, String dataCadastro, String idFuncionario) {
       this.cpf = cpf;
       this.nome = nome;
       this.endereco = endereco;
       this.telefone = telefone;
       this.dataCadastro = dataCadastro;
       this.idFuncionario = idFuncionario;
   }
   
   public String getCpf() {
       return cpf;
   }

   public void setCpf(String cpf) {
       this.cpf = cpf;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getEndereco() {
       return endereco;
   }

   public void setEndereco(String endereco) {
       this.endereco = endereco;
   }

   public String getTelefone() {
       return telefone;
   }

   public void setTelefone(String telefone) {
       this.telefone = telefone;
   }

   public String getDataCadastro() {
       return dataCadastro;
   }

   public void setDataCadastro(String dataCadastro) {
       this.dataCadastro = dataCadastro;
   }

   public String getIdFuncionario() {
       return idFuncionario;
   }

   public void setIdFuncionario(String idFuncionario) {
       this.idFuncionario = idFuncionario;
   }

   public String toString() {
       return "CPF: " + cpf +
              ", Nome: " + nome +
              ", Endereço: " + endereco.replaceAll("\\s+", "") +
              ", Telefone: " + telefone.replaceAll("\\s+", "") +
              ", Data de Cadastro: " + dataCadastro +
              ", ID do Funcionário: " + idFuncionario;
   }
}