package br.com.schifers.state.statemachine.state;

import br.com.schifers.state.enumerator.EventoEnum;
import br.com.schifers.state.statemachine.Solicitacao;

public class Cancelada implements Estado {
    public void executar(Solicitacao solicitacao, EventoEnum evento) {
    }

    public void escreverNome() {
        System.out.println("Solicitacao - Cancelada");
    }
}
