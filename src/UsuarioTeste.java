public class UsuarioTeste {
    public static void main(String[] args){
        Usuario meuUsuario = new Usuario();
        meuUsuario.setCódigo(1);
        meuUsuario.setNome("lucas");
        meuUsuario.setSenha("etec#111");
        meuUsuario.setStatus(StatusUsuarioEnum.ATIVO);
        meuUsuario.setTentativas_de_acesso(3);

        meuUsuario.exibirDados();
        System.out.println(meuUsuario.autenticar("etec#11"));
        System.out.println("Tentativas de Acesso: " + meuUsuario.getTentativas_de_acesso());
    }
}
