import java.time.LocalDate;
import java.util.Date;

import static javax.management.Query.or;

public class Usuario {
    private int código;
    private String nome;
    private String senha;
    private int tentativas_de_acesso;
    private boolean primeiro_acesso ;
    private LocalDate data_de_inativação;//dataInativacao
    private StatusUsuarioEnum status;

    public int getCódigo() {return código;}

    public void setCódigo(int código) {this.código = código;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSenha() {return senha;}

    public void setSenha(String senha) {
        this.senha = senha;
        this.primeiro_acesso = false;
        this.status = StatusUsuarioEnum.ATIVO;
        this.tentativas_de_acesso = 0;
    }

    public int getTentativas_de_acesso() {return tentativas_de_acesso;}

    public void setTentativas_de_acesso(int tentativas_de_acesso) {this.tentativas_de_acesso = tentativas_de_acesso;}

    public boolean isPrimeiro_acesso() {return primeiro_acesso;}

    public void setPrimeiro_acesso(boolean primeiro_acesso) {this.primeiro_acesso = primeiro_acesso;}

    public LocalDate getData_de_inativação() {return data_de_inativação;}

    public void setData_de_inativação(LocalDate data_de_inativação) {this.data_de_inativação = data_de_inativação;}

    public StatusUsuarioEnum getStatus() {return status;}

    public void setStatus(StatusUsuarioEnum status) {this.status = status;}

    public Usuario(){
        this.senha = "etec#123";
        this.primeiro_acesso = true;
        status = StatusUsuarioEnum.ATIVO;
    }

    void inativar_usuario(){
        this.data_de_inativação = LocalDate.now();
        this.primeiro_acesso = false;
        status = StatusUsuarioEnum.INATIVO;
    }

    void exibirDados() {
        System.out.println("Codigo: " + código);
        System.out.println("Usuario: " + nome);
        System.out.println("Senha: " + senha);
        System.out.println("Trocar senha:" + primeiro_acesso);
        System.out.println("Status: " + status);
    }


    String autenticar(String senha){
        //this.senha = senha;
        if (status.equals(StatusUsuarioEnum.INATIVO) || status.equals(StatusUsuarioEnum.BLOQUEADO) ){
            return "Acesso negado";
        }
            if (tentativas_de_acesso >= 3){
                status = StatusUsuarioEnum.BLOQUEADO;
                return "Acesso negado";
            }
                if (this.senha == senha) {
                    tentativas_de_acesso = 0;
                    return "acesso liberado";
                }else{
                    tentativas_de_acesso += 1;
                    return "Usuario/senha invalidos";
                }
    }
}
