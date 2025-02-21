package app;

import exceptions.DBException;
import storage.Cell;
import storage.Tuple;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public void processInput(DB dbApp) throws DBException {
        StringBuffer command = new StringBuffer("SELECT * FROM Students WHERE gpa = 4.0 AND id > 100");
        Iterator pag;
        try {
            pag = dbApp.parseSQL(command);
        } catch (Exception e) {
            throw new DBException(e);
        }
        ArrayList<String> arrStr = new ArrayList<>();
        boolean first = true;
        while (pag != null && pag.hasNext()) {
            Tuple t = (Tuple) pag.next();
            if (first) {
                arrStr.add(concat(true, t));
                first = false;
            }
            arrStr.add(concat(false, t));
        }
        outputResults(arrStr);
    }

    private void outputResults(ArrayList<String> arrStr) {
        String results = "";
        results = computeResult(arrStr);
        results += "command executed successfully";
        System.out.println(results);
    }

    private String computeResult(ArrayList<String> arrStr) {
        String result = "";
        for (String s : arrStr) {
            result += s.substring(0, s.length() - 2) + "\n";
            result += newLine(s) + "\n";
        }
        result += "\n\n";
        return result;
    }

    private String newLine(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += ".";
        }
        return result;
    }

    private String concat(boolean flag, Tuple t) {
        String s = "";
        for (Cell cell : t.getCells()) {
            s += calcStringLen((flag ? cell.getKey() : cell.getValue()) + "");
        }
        return s;

    }

    private String calcStringLen(String s) {
        String tmp = "";
        for (int i = 0; i < 15; i++) {
            if (i < s.length())
                continue;
            tmp += " ";
        }
        s += tmp + "| ";
        return s;
    }
}
