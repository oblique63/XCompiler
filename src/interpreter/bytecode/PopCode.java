package interpreter.bytecode;

import interpreter.VirtualMachine;

public class PopCode extends ByteCode {
    private int numOfPops;
    public PopCode() {}

    @Override
    public void init(String args) {
        numOfPops = Integer.parseInt(args);
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i < numOfPops; i++)
            vm.popRunStack();
    }

    @Override
    public String getArgs() {
        return Integer.toString(numOfPops);
    }

}
