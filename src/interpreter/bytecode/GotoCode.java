package interpreter.bytecode;

import interpreter.VirtualMachine;

public class GotoCode extends ByteCode {
    private String label;
    public GotoCode(){}

    @Override
    public void init(String args) {
        label = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getArgs() {
        return label;
    }

    //@Override
    public boolean equals(ByteCode code) {
        Class thisClass = GotoCode.class;
        if (thisClass.isInstance(code) && code.getArgs().matches(label))
            return true;
        else
            return false;
    }
}
