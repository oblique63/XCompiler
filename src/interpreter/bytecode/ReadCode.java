package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReadCode extends ByteCode {
    public ReadCode(){}

    @Override
    public void init(String args){}
    
    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getArgs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
