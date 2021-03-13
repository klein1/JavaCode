package Tools;

public class T_jiami {

    private static char code(char c, int k) {
        if (c >= 'a' && c <= 'z') {
            c += k % 26;
            if (c < 'a') {
                c += 26;
            } else if (c > 'z') {
                c -= 26;
            }
            c -= 32;
        }

        else if (c >= 'A' && c <= 'Z') {
            c += k % 26;
            if (c < 'A') {
                c += 26;
            } else if (c > 'Z') {
                c -= 26;
            }
            c += 32;
        }

        return c;
    }

    public static String encrypt(String str, int k) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            result.append(code(c, k));
        }
        return result.toString();
    }

    public static String decrypt(String str, int k) {
        return encrypt(str, -k);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("IamChinese", 5));
        System.out.println(decrypt("vYCkXQOVOC", 10));
    }
}


