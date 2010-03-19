package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ReturnCode extends ByteCode {
    private String funcName;
    public ReturnCode(){}

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

    //@Override
    public boolean equals(ByteCode code) {
        Class thisClass = ReturnCode.class;
        if (thisClass.isInstance(code) && code.getArgs().matches(funcName))
            return true;
        else
            return false;
    }
}
