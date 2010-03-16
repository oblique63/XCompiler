package ast;

import lexer.Symbol;
import lexer.Token;
import visitor.*;

public class FloatTree extends AST {
    private Symbol symbol;

    public FloatTree(Token tok) {
        this.symbol = tok.getSymbol();
    }
    
    public Object accept(ASTVisitor v) {
        return v.visitFloatTree(this);
    }

    public Symbol getSymbol() {
        return symbol;
    }

}
