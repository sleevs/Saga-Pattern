package br.com.jsnsoftware.command;

import br.com.jsnsoftware.model.PaymentModel;

public abstract class Command {

    public abstract void execute(String msg);
}
