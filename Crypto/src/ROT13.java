import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private int shift;

    ROT13(Character cs, Character cf) {
        this.shift = cf - cs;
    }

    ROT13() {
        this.shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        StringBuilder crypted = new StringBuilder();

        for(int i = 0; i < text.length(); i++) {
            char t = text.charAt(i);

            if(!Character.isAlphabetic(t)){
                crypted.append(t);
                continue;
            }
            if ((Character.isUpperCase(t) && t > 'M') && t < 'Z') {
                t -= shift;
            } else if ((Character.isLowerCase(t) && t > 'm') && t < 'z'){
                t -= shift;
            } else {
                t += shift;
            }
            crypted.append(t);
        }

        return crypted.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        if (s.charAt(0) == c) {
            return s;
        }

        int position = s.indexOf(c);

        String start = s.substring(position);
        String end = s.substring(0, position);

        return start+end;
    }

}
