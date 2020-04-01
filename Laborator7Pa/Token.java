import java.util.Set;

public class Token implements Comparable<Token> {
    int value;
    int m;
    boolean blank;

    public Token(int value, int m, boolean blank) {
        this.value = value;
        this.m = m;
        this.blank = blank;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        value=value%m;
        if (value == 0)
            this.blank = true;
        else {
            this.blank = false;
        }
        this.value = value;
    }

    public boolean isBlank() {
        return blank;
    }

    public void setBlank(boolean blank) {
        this.blank = blank;
        if(this.blank==true)
            value=0;
    }

    @Override
    public int compareTo(Token o) {
        if(o.value>this.value)
            return 1;
        if(o.value<this.value)
            return -1;
        if(o.value== 0)
            return 1;
        return 0;
    }
}
