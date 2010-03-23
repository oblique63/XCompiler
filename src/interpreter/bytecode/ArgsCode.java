package interpreter.bytecode;

import interpreter.VirtualMachine;

public class ArgsCode extends ByteCode {
    private int numOfArgs;
    public ArgsCode(){}

    @Override
    public void init(String args) {
        numOfArgs = Integer.parseInt(args);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int offset = vm.runStackSize() - numOfArgs;
        vm.newRunStackFrameAt(offset);
    }

    @Override
    public String getArgs() {
        return Integer.toString(numOfArgs);
    }
}
