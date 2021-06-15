public class Main {
    public static boolean IsLetter(String a) {
        for(int i = 0; i < a.length(); ++i) {
            if (!Character.isLetter(a.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String string1 = "ABCDEFGEH";
        String string2 = "FEGDA";
        String longer = Main.StringUtils.BetterString(string1, string2, (s1, s2) -> s1.length() > s2.length() );
        System.out.println(longer);
        String first = Main.StringUtils.BetterString(string1, string2, (s1, s2) -> true );
        System.out.println(first);
        System.out.println(IsLetter("ABc1as"));
    }

    class StringUtils {
        StringUtils() {
        }

        public static String BetterString(String s1, String s2, CompareString compS) {
            return compS.compare(s1, s2) ? s1 : s2;
        }
    }
}
