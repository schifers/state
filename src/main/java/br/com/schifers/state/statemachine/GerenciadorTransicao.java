package br.com.schifers.state.statemachine;

import br.com.schifers.state.enumerator.EstadoEnum;
import br.com.schifers.state.enumerator.EventoEnum;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorTransicao {
    static List<Transicao> transicoes;

    public void configurar() {
        transicoes = new ArrayList<Transicao>();

        transicoes.add(new Transicao(EstadoEnum.CADASTRADA, EstadoEnum.CANCELADA, EventoEnum.CANCELAR));
        transicoes.add(new Transicao(EstadoEnum.CADASTRADA, EstadoEnum.AGUARDANDO_DISTRIBUICAO, EventoEnum.ENVIAR));
        transicoes.add(new Transicao(EstadoEnum.AGUARDANDO_DISTRIBUICAO, EstadoEnum.CANCELADA, EventoEnum.CANCELAR));
        transicoes.add(new Transicao(EstadoEnum.AGUARDANDO_DISTRIBUICAO, EstadoEnum.AGUARDANDO_ANALISE, EventoEnum.DISTRIBUIR));
        transicoes.add(new Transicao(EstadoEnum.AGUARDANDO_ANALISE, EstadoEnum.CANCELADA, EventoEnum.CANCELAR));
        transicoes.add(new Transicao(EstadoEnum.AGUARDANDO_ANALISE, EstadoEnum.EM_ANALISE, EventoEnum.INICIAR_ANALISE));
        transicoes.add(new Transicao(EstadoEnum.EM_ANALISE, EstadoEnum.CANCELADA, EventoEnum.CANCELAR));
        transicoes.add(new Transicao(EstadoEnum.EM_ANALISE, EstadoEnum.DEFERIDA, EventoEnum.DEFERIR));
    }

    public void executarTransicao(Solicitacao solicitacao, EstadoEnum origem, EventoEnum evento) {
        Transicao transicaoAtual = null;

        for (Transicao t : transicoes) {
            if (t.getOrigem().equals(origem) && t.getEvento().equals(evento)) {
                transicaoAtual = t;
            }
        }

        if (transicaoAtual != null) {
            transicaoAtual.executarTransicao(solicitacao);
        }
    }
}
