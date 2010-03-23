package interpreter.bytecode;

import interpreter.VirtualMachine;

public class FalsebranchCode extends ByteCode{
    private String label;
    public FalsebranchCode(){}

    @Override
    public void init(String args) {
        label = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int boolValue = vm.popRunStack();
        if (boolValue > 0) {
            int goToAddress = Integer.parseInt(label.split("<<")[1].split(">>")[0]);
            vm.setProgramCounter(goToAddress);
        }
    }

    @Override
    public String getArgs() {
        return label;
    }
}
