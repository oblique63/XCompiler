package interpreter.bytecode;
import interpreter.VirtualMachine;


public abstract class ByteCode {
    public abstract void init(String args);
    public abstract void execute(VirtualMachine vm);
    public abstract String getArgs();
<<<<<<< HEAD
=======
    public abstract boolean equals(ByteCode code);

>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
}