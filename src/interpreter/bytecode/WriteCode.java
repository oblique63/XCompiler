package interpreter.bytecode;

import interpreter.VirtualMachine;

public class WriteCode extends ByteCode {
    public WriteCode(){}

    @Override
    public void init(String args){}

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peekRunStack());
    }

    @Override
    public String getArgs() {
        return "";
    }
}
