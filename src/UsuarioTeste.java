public class UsuarioTeste {
    public static void main(String[] args){
        Usuario meuUsuario = new Usuario();
        meuUsuario.setCódigo(1);
        meuUsuario.setNome("lucas");
        meuUsuario.setSenha("etec#111");
        meuUsuario.setStatus(StatusUsuarioEnum.ATIVO);

        meuUsuario.exibirDados();
        System.out.println(meuUsuario.autenticar("etec#111"));
    }
}
