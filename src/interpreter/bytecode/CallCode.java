package interpreter.bytecode;

import interpreter.VirtualMachine;

public class CallCode extends ByteCode {
    private String funcName;
    public CallCode(){}

    @Override
    public void init(String args) {
        funcName = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getArgs() {
        return funcName;
    }
}
