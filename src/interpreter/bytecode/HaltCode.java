package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    public HaltCode(){}

    //@Override
    public void init() {}

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
