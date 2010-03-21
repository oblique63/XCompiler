package interpreter;

import interpreter.bytecode.ByteCode;
<<<<<<< HEAD
import interpreter.bytecode.LabelCode;
=======
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
import java.util.Vector;


public class Program {
<<<<<<< HEAD
    private int codeNum;
=======
    private int codeCount;
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
    private Vector<ByteCode> codes;
    private Vector<Integer> labelIndexList;

    public Program() {
<<<<<<< HEAD
        codeNum = 0;
        codes = new Vector<ByteCode>();
        labelIndexList = new Vector<Integer>();
=======
        codeCount = 0;
        codes = new Vector<ByteCode>();
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
    }

    public void addCode(ByteCode bytecode) {
        codes.add(bytecode);
<<<<<<< HEAD

        String codeClass = bytecode.getClass().getName().replaceFirst("interpreter.bytecode.", "");
        // Keep track of where all the LABEL codes are located
        if (codeClass.matches("LabelCode"))
            labelIndexList.add(codeNum);

        codeNum += 1;
=======
        codeCount += 1;
        String codeClass = bytecode.getClass().getName();
        if (codeClass.matches("LabelCode"))
            labelIndexList.add(codeCount);

        //System.out.println("Added Code: "+bytecode.getClass().getName());
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
    }

    public ByteCode getCode(int codeNum) {

        return resolveAddress(codeNum);
    }

    private ByteCode resolveAddress(int codeNum) {
        ByteCode code = codes.get(codeNum);
<<<<<<< HEAD
        String codeClass = code.getClass().getName().replaceFirst("interpreter.bytecode.", "");
        String label, address;

        if (codeClass.matches("FalsebranchCode|GotoCode|CallCode|ReturnCode")) {
            label = code.getArgs();

            for (int index = 0; index < labelIndexList.size(); index++) {
                String targetLabel = codes.get(labelIndexList.get(index)).getArgs();

                if(label.matches(targetLabel)) {
                    address = Integer.toString(labelIndexList.get(index));
                    code.init(address);
                    break;
                }
            }
=======
        String codeClass = code.getClass().getName();
        codeClass = codeClass.replaceFirst("interpreter.bytecode.", "");
        //System.out.println(codeClass);
        String label, address;

        if (codeClass.matches("FalsebranchCode|GotoCode|CallCode|ReturnCode")) {

            label = code.getArgs();
            // NOT WORKING!
            for (int index = 0; index < labelIndexList.size(); index++)
                if(label.matches(codes.get(labelIndexList.get(index)).getArgs())) {
                    address = Integer.toString(labelIndexList.get(index));
                    code.init(address);
                    index = labelIndexList.size();
                }
            
>>>>>>> 8eccb4f90a5bb6446929eef5cb449ede59553f1d
        }
        
        return code;
    }
}
