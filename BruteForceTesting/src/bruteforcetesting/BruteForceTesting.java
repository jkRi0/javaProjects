package bruteforcetesting;
import java.util.*;
    public class BruteForceTesting {
        public static void main(String[] args) {
            Scanner key=new Scanner(System.in);
            System.out.println("(1)Characters, (2)numbers");
            String choice = key.nextLine(), start = "";
            switch(choice){
                case "1":
                    String keys[]={" ","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                            "0","1","2","3","4","5","6","7","8","9","`","~","!","@","#","$","%","^","&","*","(",")","_","-","=","+",
                            "[","{","}","]","'",";",":","/","?",".",">",",","<","|"};
                    String word="";
                    System.out.print("Input 8 Digit: ");
                    word=key.nextLine();
                    for(int a=0; a<93; a++){
                        for(int b=0; b<93; b++){
                            for(int c=0; c<93; c++){
                                for(int d=0; d<93; d++){
                    for(int e=0; e<93; e++){
                        for(int f=0; f<93; f++){
                            for(int g=0; g<93; g++){
                                for(int h=0; h<93; h++){
                                    String store = keys[h]+keys[g]+keys[f]+keys[e]+keys[d]+keys[c]+keys[b]+keys[a];
                                    System.out.println(store+"                  "+a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g+" "+h);
                                    char ch1=store.charAt(1),
                                            ch2=store.charAt(2),
                                            ch3=store.charAt(3),
                                            ch4=store.charAt(4),
                                            ch5=store.charAt(5),
                                            ch6=store.charAt(6),
                                            ch7=store.charAt(7);
                                    String convert1=Character.toString(ch1),
                                            convert2=Character.toString(ch2),
                                            convert3=Character.toString(ch3),
                                            convert4=Character.toString(ch4),
                                            convert5=Character.toString(ch5),
                                            convert6=Character.toString(ch6),
                                            convert7=Character.toString(ch7);
                                    if(convert1.equals(" ")){
                                        String extra = word+"       ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert2.equals(" ")){
                                        String extra = word+"      ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert3.equals(" ")){
                                        String extra = word+"     ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert4.equals(" ")){
                                        String extra = word+"    ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert5.equals(" ")){
                                        String extra = word+"   ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert6.equals(" ")){
                                        String extra = word+"  ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(convert7.equals(" ")){
                                        String extra = word+" ";
                                        if(extra.equals(store)){
                                            System.out.println("\nFound it!\n");
                                            System.out.println("(R)retry  (S)stop");
                                            start=key.nextLine();
                                            if(start.equals("R")){
                                                System.out.print("\n");
                                                main(null);
                                            }
                                            else if(start.equals("S")){
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    else if(word.equals(store)){
                                        System.out.println("\nFound it!\n");
                                        System.out.println("(R)retry  (S)stop");
                                        start=key.nextLine();
                                        if(start.equals("R")){
                                            System.out.print("\n");
                                            main(null);
                                        }
                                        else if(start.equals("S")){
                                            System.exit(0);
                                        }
                                    }
                                }
                            }   
                        }
                    }
                                }
                            }   
                        }
                    }
                    break;
                case "2":
                    numbers();
                    break;
                default:
                    System.out.println("(R)retry  (S)stop");
                    start=key.nextLine();
                    if(start.equals("R")){
                        System.out.print("\n");
                        main(null);
                        System.exit(0);
                    }
                    else if(start.equals("S")){
                        System.exit(0);
                    }
                    break;
            }
        }
        public static void numbers(){
            Scanner key=new Scanner(System.in);
            String num1[]={"0","1","2","3","4","5","6","7","8","9"};
            String num2[]={"0","1","2","3","4","5","6","7","8","9"};
            String num3[]={"0","1","2","3","4","5","6","7","8","9"};
            String num4[]={"0","1","2","3","4","5","6","7","8","9"};
            System.out.print("Input 4 Digit: ");
            String num=key.next();
            for(int a=0; a<10; a++){
                for(int b=0; b<10; b++){
                    for(int c=0; c<10; c++){
                        for(int d=0; d<10; d++){
                            String pass = num1[a]+num2[b]+num3[c]+num4[d];
                            System.out.println(pass);
                            if(num.equals(pass)){
                                System.out.println("\nFound it!");
                                System.exit(0);
                            }
                        }
                    }   
                }
            }
        }
    }
