package br.com.schifers.state.enumerator;

import br.com.schifers.state.statemachine.state.*;

public enum EstadoEnum {
    AGUARDANDO_ANALISE(new AguardandoAnalise()),
    AGUARDANDO_DISTRIBUICAO(new AguardandoDistribuicao()),
    CADASTRADA(new Cadastrada()),
    CANCELADA(new Cancelada()),
    DEFERIDA(new Deferida()),
    EM_ANALISE(new EmAnalise());

    private Estado estado;

    EstadoEnum(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return this.estado;
    }
}
