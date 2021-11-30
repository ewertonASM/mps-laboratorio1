package br.mps.business.control.memento;

import java.util.EmptyStackException;
import java.util.Stack;

import br.mps.business.model.Establishment;
import br.mps.infra.exceptions.BadRequestException;

public class CareTaker {
    private Stack<Momento> momentoStack = new Stack<>();
    private Establishment establishment;

    public CareTaker(Establishment establishment) {
        this.establishment = establishment;
    }

    public void backup() {
        this.momentoStack.push(this.establishment.save());
    }

    public void undo() throws BadRequestException {
        try {
            Momento poppedMomento = momentoStack.pop();

            this.establishment.restore(poppedMomento);
        } catch (EmptyStackException error) {
            throw new BadRequestException("Não foi possível desfazer a ação");
        }
    }
}
