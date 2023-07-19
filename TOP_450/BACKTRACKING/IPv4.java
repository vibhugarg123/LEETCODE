package TOP_450.BACKTRACKING;

import java.util.ArrayList;
import java.util.List;

public class IPv4 {
    StringBuilder stringBuilder = new StringBuilder();

    public ArrayList<String> genIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 16) {
            res.add("-1");
            return res;
        }
        generate(s, res);
        return res;
    }

    private boolean isValidPart(String s) {
        // Length of each part in Ipv4 must be <=4
        if (s.length() == 0 || s.length() > 4) {
            return false;
        }
        // Trailing zeroes not allowed
        if (s.length() > 1 && s.startsWith("0")) return false;

        // Valid ipv4 must be in range [0,255]
        int addr = Integer.parseInt(s);
        return addr >= 0 && addr <= 255;
    }

    // string divide it in 3 parts i.e i, j, k
    // 1st part: [0-i] + [i+1,j], [j+1,k], [k+1, n-1]
    private void generate(String s, List<String> res) {
        for (int i = 0; i < s.length() - 1; i++) {
            String partA = s.substring(0, i + 1);
            if (!isValidPart(partA)) continue;

            for (int j = i + 1; j < s.length(); j++) {

                String partB = s.substring(i + 1, j + 1);
                if (!isValidPart(partB)) continue;

                for (int k = j + 1; k < s.length(); k++) {
                    String partC = s.substring(j + 1, k + 1);
                    if (!isValidPart(partC)) continue;

                    String partD = s.substring(k + 1, s.length());
                    if (!isValidPart(partD)) continue;

                    res.add(partA + "." + partB + "." + partC + "." + partD);
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ipv4 = new IPv4().genIp("6207291");
        for (String ip : ipv4) {
            System.out.println(ip + " ");
        }
    }
}