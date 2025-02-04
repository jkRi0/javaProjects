package string_manipulation;

public class String_manipulation {
    public static void main(String[] args) {
        String a = "sheee";
        String b = "eeesh";
        String merge = "";
        
        System.out.println(a.length());
        System.out.println(a.toUpperCase()); 
        System.out.println(a.toLowerCase());
        System.out.println(merge = merge.concat(a).concat(b));
        System.out.println(a.indexOf('s')); 
        System.out.println(a.substring(2)); 
        System.out.println(a.compareTo(b));
        System.out.println(a.charAt(a.length()-1));
        System.out.println(a.contains("he"));
        System.out.println("\n");
        String ahh = "Bruno Mars";
        System.out.print(ahh.charAt(0)); //B
        System.out.print(ahh.charAt(2)); //u
        System.out.print(ahh.charAt(4)); //o
        System.out.print(ahh.charAt(6)); //M
        
        String name = "\nJustine ken d. Rioveros";
        name = name.replace('d','D');
        name = name.replace("ken","AHHHH");
        System.out.print(name);
        
        String c="   Hello World ";
        System.out.println(c);
        String d=c.trim();
        System.out.println(d);
        String test = "a";
        
        
        char ch = ahh.charAt(0);
        String convert = Character.toString(ch);
        if(test.equals(convert)){
            System.out.println("There you are");
        }
    }
}
