package interpreter;

import interpreter.bytecode.ByteCode;
import java.io.FileInputStream;
import java.io.IOException;


public class ByteCodeLoader {
    private FileInputStream programFile;

    public ByteCodeLoader(String programPath) throws IOException {
        programFile = new FileInputStream(programPath);
    }
    
    public Program loadCodes() {

        Program program = new Program();
        String code, codeClass;
        ByteCode bytecode;
        
            try {
                codeClass = CodeTable.get(code);
                bytecode = (ByteCode)(Class.forName("interpreter.bytecode"+codeClass).newInstance());
                program.addByteCode(bytecode);
            } catch (Exception e) {}

        return program;
    }
}
