class Util {
    public static String capitalize(String str) {
        String result;
        System.out.printf("Before: %s\n", str);
        if (str == null || str.isBlank()) {
            result = str;
            System.out.printf("After: %s\n", result);
            return result;
        }

        if (str.length() == 1) {
            result = str.toUpperCase();
            System.out.printf("After: %s\n", result);
            return result;
        }

        result = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        System.out.printf("After: %s\n", result);
        return result;
    }
}