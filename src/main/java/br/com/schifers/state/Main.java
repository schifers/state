package br.com.schifers.state;

import br.com.schifers.state.enumerator.EventoEnum;
import br.com.schifers.state.statemachine.Solicitacao;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Solicitacao solicitacao = new Solicitacao();

        while (!solicitacao.isFinalizada()) {
            solicitacao.escreverNome();

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Selecione um evento: ");
            System.out.println("(1) Cancelar (2) Deferir (3) Distribuir (4) Enviar (5) Iniciar analise");
            String tecla = keyboard.nextLine();

            solicitacao.executar(EventoEnum.recuperarEventoPorCodigo(tecla));
        }
    }
}
