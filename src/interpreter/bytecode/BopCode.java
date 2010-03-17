package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;
    public BopCode(){}

    public void init(String args) {
        operator = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
