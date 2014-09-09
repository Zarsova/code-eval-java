package mdrt.m15_email_validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Runnable {
    private final String fileName;

    public Main(final String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws IOException {
        final BufferedReader in = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                parseLine(line);
            }
        }
        in.close();
    }

    final Pattern localAndDomain = Pattern.compile("(^.*)@([^@]+)$");
    final Pattern validDomain = Pattern.compile("^[\\-|\\.|a-z|A-Z|0-9]+$");
    final Pattern validAText = Pattern.compile("^[!|#|\\$|%|&|'|\\*|\\+|\\-|/|=|?|^|_|`|{|\\||}|~|\\.|a-z|A-Z|0-9]+$");
    final Pattern validQuotedString = Pattern.compile("^\".*[^\\\\]\"$");

    private void parseLine(String line) {
        final String email = line;
        final Matcher m = localAndDomain.matcher(line);
        boolean isEmail = true;
        if (m.find()) {
            final String local = m.group(1);
            final String domain = m.group(2);
            if (!isValidLocal(local)) {
                isEmail = false;
            }
            if (!isValidDomain(domain)) {
                isEmail = false;
            }
        } else {
            isEmail = false;
        }
        System.out.println(isEmail);
    }

    private boolean isValidDomain(String domain) {
        if (domain.endsWith(".") || domain.startsWith(".") || domain.contains("..")) {
            return false;
        }
        if (validDomain.matcher(domain).find()) {
            return true;
        }
        return false;
    }

    private boolean isValidLocal(String local) {
        if (local.endsWith(".") || local.startsWith(".") || local.contains("..")) {
            return false;
        }
        return isQuotedString(local) ? isValidQuotedString(local) : isValidAText(local);
    }

    private boolean isValidAText(String local) {
        if (validAText.matcher(local).find()) {
            return true;
        }
        return false;
    }

    private boolean isValidQuotedString(String local) {
        return validQuotedString.matcher(local).find();
    }

    private boolean isQuotedString(String local) {
        return local.startsWith("\"") && local.endsWith("\"");
    }


    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
