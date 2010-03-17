package interpreter.bytecode;

import interpreter.VirtualMachine;

public class StoreCode extends ByteCode {
    private int value;
    private String id;
    public StoreCode(){}

    //@Override
    public void init(String args) {
        String argList[] = args.split("\\s");
        value = Integer.parseInt(argList[0]);
        id = argList[1];
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
