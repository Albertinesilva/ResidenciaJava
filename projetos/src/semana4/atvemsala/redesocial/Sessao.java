package semana4.atvemsala.redesocial;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Sessao {

  private int idUsuario;
  private LocalDateTime dataHoraInicio;
  private LocalDateTime dataHoraFim;
  private ListaUsuarios usuarios;

  public Sessao() {
    dataHoraInicio = LocalDateTime.now();
  }

  public Sessao(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
    this.dataHoraInicio = LocalDateTime.now(); // Obtém a data e hora atuais;
    this.dataHoraFim = dataHoraFim;
  }

  public int getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(int idUsuario) {
    this.idUsuario = idUsuario;
  }

  public LocalDateTime getDataHoraInicio() {
    return dataHoraInicio;
  }

  public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
    this.dataHoraInicio = dataHoraInicio;
  }

  public LocalDateTime getDataHoraFim() {
    return LocalDateTime.now();
  }

  public void setDataHoraFim(LocalDateTime dataHoraFim) {
    this.dataHoraFim = dataHoraFim;
  }

  public void solicitarAutenticacao() {

    Scanner scan = new Scanner(System.in);
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    ListaSessoes listaSessoes = new ListaSessoes();

    System.out.println("\n\t========== LOGIN ==========");

    System.out.print("\n\tEmail: ");
    String email = scan.nextLine();

    System.out.print("\n\tSenha: ");
    String senha = scan.nextLine();

    Usuario usuarioEncontrado = null;
    for (Usuario usuario : listaUsuarios.getUsuarios()) {
      if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
        this.setIdUsuario(usuario.getId());
        listaSessoes.adicionarSessao(this);
        usuarioEncontrado = usuario;
        System.out.println("\n\tLogin realizado com sucesso!");
        Utils.pausar(scan);
        Utils.limparTela();
        break;
      }
    }

    if (usuarioEncontrado == null) {
      System.out.println("\n\tOps, e-mail ou senha incorretos.");
      Utils.pausar(scan);
      Utils.redeSocial();
    }
  }
}