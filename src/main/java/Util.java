public class Util {
    private Util(){}

    public static Integer checkEqualChar(char target, char comparison){
        if(target == comparison){
            return 1;
        }
        return 0;
    }

    public static Integer checkContains(String str, String strWord){
        if(str.contains(strWord)){
            return 1;
        }
        return 0;
    }

    public static StringBuilder setEmptyMsg(StringBuilder msg){
        if(msg.length() > 0){
            msg.append(" ");
        }
        return msg;
    }

}
