package br.com.schifers.state.statemachine.state;

import br.com.schifers.state.enumerator.EventoEnum;
import br.com.schifers.state.statemachine.Solicitacao;

public interface Estado {
    void executar(Solicitacao solicitacao, EventoEnum evento);

    void escreverNome();
}
