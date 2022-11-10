class RemoveVowels{
    public static void remove(String str){
        char[] ch = str.toCharArray();
        for(int i =0; i<ch.length; i++){
            if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' ||
             ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U'){
                continue;
            }
            System.out.print(ch[i]);
        }
    }

    public static void main(String[] args){

        String str = "MuhammadArifBrohi";
       
        RemoveVowels.remove(str);
        
    }
}
