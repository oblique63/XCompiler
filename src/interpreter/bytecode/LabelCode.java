package interpreter.bytecode;

import interpreter.VirtualMachine;

public class LabelCode extends ByteCode{
    private String label;
    public LabelCode(){}

    @Override
    public void init(String args) {
        label = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public boolean equals(ByteCode code) {
        Class thisClass = LabelCode.class;
        if (thisClass.isInstance(code) && code.getArgs().matches(label))
            return true;
        else
            return false;
    }

    @Override
    public String getArgs() {
        return label;
    }
}
