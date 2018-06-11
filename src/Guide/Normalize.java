package Guide;

/**
 *
 * @author THAYCACAC
 */
public class Normalize {

    String content; 

    public Normalize(String content) {
        this.content = content;
    }

    //one space by special characters
    public String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        if (strings.length == 1) {
            return line;
        } else {
            for (int i = 0; i < strings.length; i++) {
                stringBuffer.append(strings[i]);
                //check last of string split
                if (i == strings.length - 1) {
                    break;
                }
                stringBuffer.append(" " + character);
                stringBuffer.append(" ");
            }
            return stringBuffer.toString().trim();
        }
    }

    //only one space between words and all character lowercase
    public String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        line = formatOneSpaceSpecial(line, "!");
        line = formatOneSpaceSpecial(line, "?");
        line = formatOneSpaceSpecial(line, ";");
        return line;
    }

    //only one space after comma (,), dot (.) and colon (:). 
    public String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        //check from first to last before .,:; then delete
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ':'
                    || stringBuffer.charAt(i + 1) == ';'
                    || stringBuffer.charAt(i + 1) == '?'
                    || stringBuffer.charAt(i + 1) == '!') {
                stringBuffer.deleteCharAt(i);
                i--;
            }
        }
        return stringBuffer.toString().trim();
    }

    //first character of word after dot is in Uppercase and other words are in lower case.
    public String firstAfterDotUpperCase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
        //check from first to last after . then UpperCase
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.'
                    || stringBuffer.charAt(i) == '?') {
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(stringBuffer.charAt(i + 2)));
            }
        }
        return stringBuffer.toString().trim();
    }

    //there are no spaces before and after sentence or word phrases in quotes (“”).
    int countQuetes = 0;
    int countApostrophe = 0;

    public String noSpaceQuotes(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String noSpaceApostrophe(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '\'' && countApostrophe % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countApostrophe++;
            } else if (stringBuffer.charAt(i) == '\'' && countApostrophe % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countApostrophe++;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String normalize() {
        this.content = formatOneSpace(this.content);
        this.content = formatSpecialCharacters(this.content);
        this.content = firstAfterDotUpperCase(this.content);
        this.content = noSpaceQuotes(this.content);
        this.content = noSpaceApostrophe(this.content);
        return this.content;
    }
}
