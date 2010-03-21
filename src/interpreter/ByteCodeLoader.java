package interpreter;

import interpreter.bytecode.ByteCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ByteCodeLoader {
    private BufferedReader programFile;

    public ByteCodeLoader(String programPath) throws IOException {
        programFile = new BufferedReader(new FileReader(programPath));
    }
    
    public Program loadCodes() {
        Program program = new Program();
<<<<<<< HEAD
        //CodeTable.init();
=======
        CodeTable.init();
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
        try {
            while (programFile.ready()) {
                String line = programFile.readLine();
                // For each line read, separate the bytecode from its arguments,and store the 2 strings
                // in an array (where code[0] is the bytecode and code[1] is the string of its arguments)...
                String[] code = line.split("\\s",2);
                
                String codeClass = CodeTable.get(code[0]);
                ByteCode bytecode = (ByteCode)(Class.forName("interpreter.bytecode."+codeClass).newInstance());

                if (code.length > 1)
                    bytecode.init(code[1]);
                else
                    bytecode.init("");
                
                program.addCode(bytecode);
            }
        } catch (Exception e) {}

        return program;
    }

<<<<<<< HEAD
    /*public static void main(String[] args) {
        try{
            ByteCodeLoader foo = new ByteCodeLoader(args[0]);
            Program pro = foo.loadCodes();
            ByteCode code = pro.getCode(0);
            System.out.println(code.getClass()+" "+code.getArgs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
=======
    public static void main(String[] args) {
        try{
            ByteCodeLoader foo = new ByteCodeLoader("/home/oblique/Desktop/test");
            Program pro = foo.loadCodes();
            ByteCode code = pro.getCode(0);
            System.out.println(code.getArgs());
        } catch (Exception e) {}
    }
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
}
