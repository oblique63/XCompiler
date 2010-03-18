package interpreter;

import java.util.HashMap;


public class CodeTable {
    private static HashMap<String, String> codeMap = new HashMap<String, String>();
    private static String[] codes = {
        "Args","Bop","Call","Falsebranch","Goto","Halt","Label",
        "Lit","Load","Read","Return","Store","Write",
    };

    public static void init() {
        String code, codeClass;
        for (int i=0; i < codes.length; i++) {
            code = codes[i].toUpperCase();
            codeClass = codes[i]+"Code";
            codeMap.put(code,codeClass);
        }
    }

    public static String get(String code) {
        return codeMap.get(code);
    }
}
