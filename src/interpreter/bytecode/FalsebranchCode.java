package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalsebranchCode extends ByteCode{
    private String label;
    public FalsebranchCode(){}

    //@Override
    public void init(String args) {
        label = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
