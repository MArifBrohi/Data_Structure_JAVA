class ReverseVowels{
    public static void reverse(String str){
        char ch[] = str.toCharArray();
        int i =0;
        int j = ch.length-1;

        while(i<j){

            while(ch[i] != 'a' && ch[i] != 'e' && ch[i] != 'i' && ch[i] != 'o' && ch[i] != 'u'){
                i++;
            }
            while(ch[j] != 'a' && ch[j] != 'e' && ch[j] != 'i' && ch[j] != 'o' && ch[j] != 'u'){
                j--;
            }
         
            if(i>=j){
                break;
            }
          
            char chr = ch[i];
            ch[i] = ch[j];
            ch[j] = chr;

            i++;
            j--;

        }
        for(char chr : ch){
            System.out.print(chr);
        }
    }
    public static void main(String []args){
        String str = "sukkuribauniversity";

        System.out.println("Before Reverse:\n "+str);
        System.out.println("After Reverse: ");

        ReverseVowels.reverse(str);
    }
}
