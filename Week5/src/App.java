/*
#####################################
#    Author: Alan Huynh (s1557984)  #
#    Project: Week 5 Activity       #
#    Date: August 20, 2024          #
#    OS: Fedora 34                  #
#    JDK Version: 21.0.4.7          #
#####################################
*/

class App {
    public static void main(String[] args) {
        giveEmphasis("xxx");
    }
    public static void giveEmphasis(String string) {
        
        // Work best with monospace fonts
        int len = string.length();
        
        System.out.println(separator(len + 6));
        System.out.println("*" + separator(len + 4, " ") + "*");
        System.out.println("*  " + string + "  *");
        System.out.println("*" + separator(len + 4, " ") + "*");
        System.out.println(separator(len + 6));
    }
    public static String separator() {
        return separator(21);
    }
    public static String separator(int count) {
        return separator(count, "*");
    }
    public static String separator(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
}