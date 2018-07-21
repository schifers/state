package br.com.schifers.state.statemachine.state;

import br.com.schifers.state.enumerator.EstadoEnum;
import br.com.schifers.state.enumerator.EventoEnum;
import br.com.schifers.state.statemachine.Solicitacao;

public class AguardandoAnalise implements Estado {
    public void executar(Solicitacao solicitacao, EventoEnum evento) {
        solicitacao.executarTransicao(EstadoEnum.AGUARDANDO_ANALISE, evento);
    }

    public void escreverNome() {
        System.out.println("Solicitacao - Aguardando analise");
    }
}
