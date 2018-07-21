package br.com.schifers.state.statemachine;

import br.com.schifers.state.enumerator.EstadoEnum;
import br.com.schifers.state.enumerator.EventoEnum;

public class Transicao {
    private EstadoEnum origem;

    private EstadoEnum destino;

    private EventoEnum evento;

    public Transicao(EstadoEnum origem, EstadoEnum destino, EventoEnum evento) {
        this.origem = origem;
        this.destino = destino;
        this.evento = evento;
    }

    public void executarTransicao(Solicitacao solicitacao) {
        solicitacao.mudarEstado(destino);
    }

    public EstadoEnum getOrigem() {
        return this.origem;
    }

    public EventoEnum getEvento() {
        return this.evento;
    }
}
