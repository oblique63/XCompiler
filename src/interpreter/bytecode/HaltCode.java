package interpreter.bytecode;

import interpreter.VirtualMachine;

public class HaltCode extends ByteCode {
    public HaltCode(){}

    @Override
    public void init(String args) {}

    @Override
    public void execute(VirtualMachine vm) {
        vm.stopRunning();
    }

    @Override
    public String getArgs() {
        return "";
    }
}
