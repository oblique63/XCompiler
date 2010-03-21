package interpreter.bytecode;

import interpreter.VirtualMachine;

public class BopCode extends ByteCode {
    private String operator;
    public BopCode(){}

    @Override
    public void init(String args) {
        operator = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getArgs() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

<<<<<<< HEAD
=======
    @Override
    public boolean equals(ByteCode code) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
}
