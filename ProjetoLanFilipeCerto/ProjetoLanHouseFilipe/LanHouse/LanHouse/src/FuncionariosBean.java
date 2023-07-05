public class FuncionariosBean {
   private int idFuncionario;
   private String CPF;
   private String nome;
   private String telefone;
   
   public FuncionariosBean(int idFuncionario, String CPF, String nome, String telefone) {
       this.idFuncionario = idFuncionario;
       this.CPF = CPF;
       this.nome = nome;
       this.telefone = telefone;
   }

   
    public int getIdFuncionario() {
        return idFuncionario;
    }

  
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

 
    public String getCPF() {
        return CPF;
    }

  
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

  
    public String getNome() {
        return nome;
    }

  
    public void setNome(String nome) {
        this.nome = nome;
    }

   
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
   
    public String toString(){
        return "ID: " + idFuncionario + ", CPF: " + CPF + ", Nome: " + nome + ", Telefone: " + telefone;
    }
}
