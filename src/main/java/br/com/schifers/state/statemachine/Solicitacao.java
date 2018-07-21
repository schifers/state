package br.com.schifers.state.statemachine;

import br.com.schifers.state.enumerator.EstadoEnum;
import br.com.schifers.state.enumerator.EventoEnum;
import br.com.schifers.state.statemachine.state.Cancelada;
import br.com.schifers.state.statemachine.state.Deferida;
import br.com.schifers.state.statemachine.state.Estado;

public class Solicitacao {
    private Estado estadoAtual;

    private boolean finalizada = false;

    private GerenciadorTransicao gerenciadorTransicao;

    public Solicitacao() {
        estadoAtual = EstadoEnum.CADASTRADA.getEstado();

        gerenciadorTransicao = new GerenciadorTransicao();

        gerenciadorTransicao.configurar();
    }

    public void executar(EventoEnum evento) {
        estadoAtual.executar(this, evento);
    }

    public void escreverNome() {
        this.estadoAtual.escreverNome();
    }

    public void mudarEstado(EstadoEnum estado) {
        estadoAtual = estado.getEstado();
    }

    public void terminar() {
        finalizada = true;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void executarTransicao(EstadoEnum origem, EventoEnum evento) {
        gerenciadorTransicao.executarTransicao(this, origem, evento);

        if (estadoAtual instanceof Deferida || estadoAtual instanceof Cancelada) {
            terminar();
        }
    }
}
