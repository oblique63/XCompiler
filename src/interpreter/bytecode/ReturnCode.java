package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String funcName;
    public ReturnCode(){}

    //@Override
    public void init(){}
    public void init(String args) {
        funcName = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
