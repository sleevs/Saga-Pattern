package br.com.jsnsoftware.command;

import org.springframework.stereotype.Component;

@Component
public class ConcreteCommand extends Command{

    private Receiver receiver ;

    public ConcreteCommand(Receiver receiver){
        this.receiver = receiver ;
    }

    @Override
    public void execute(String msg) {
        receiver.action(msg);
    }
}
