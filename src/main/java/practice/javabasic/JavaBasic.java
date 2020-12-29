package practice.javabasic;

public class JavaBasic {

    public void bb() {
        System.out.println( "hi" );
    }

    public String[] split(String str) {
        String[] name = str.split(",");
        return name;
    }

    public String returnStr(String str) {
        return str;
    }

    public static void main(String[] args) {
        char a = 'A';
        String b = "aa";
        System.out.println( "Hello, world!" );
        JavaBasic m = new JavaBasic();
        m.aa();
        m.bb();

        String str = "1,2";
        String[] arr;
        arr = m.split(str);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

    private void aa() {

        System.out.println( "hi hi" );
    }

}
