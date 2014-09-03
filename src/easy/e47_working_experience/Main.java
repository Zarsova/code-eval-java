package easy.e47_working_experience;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main implements Runnable {
    private final String fileName;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

    public Main(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            parseLines();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseLines() throws Exception {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        final Set<Integer> dateSet = new HashSet<>();
        final Calendar fromCal = Calendar.getInstance();
        final Calendar toCal = Calendar.getInstance();
        String line;

        while ((line = in.readLine()) != null) {
            if (line.length() > 0) {
                final String[] strArray = line.split("; ");
                dateSet.clear();
                for (String str : strArray) {
                    final String[] dateStrArray = str.split("-");
                    fromCal.setTime(dateFormat.parse(dateStrArray[0]));
                    toCal.setTime(dateFormat.parse(dateStrArray[1]));
                    for (Calendar j = fromCal; toCal.compareTo(j) >= 0; j.add(Calendar.MONTH, 1)) {
                        dateSet.add(j.getTime().hashCode());
                    }
                }
                System.out.println(dateSet.size() / 12);
            }
        }
        in.close();
    }

    public static void main(String[] args) {
        new Main(args[0]).run();
    }
}
