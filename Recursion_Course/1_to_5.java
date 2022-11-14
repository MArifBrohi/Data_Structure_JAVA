class Main{
  public static void recursive_call(int n){
    
    /* BASE CASE*/
    
    if(n == 0){
      return;
    }
    /* PRINT */
    System.out.println(n);
    
    /* RECURSUVE CALL */
    recursive_call(n-1);
  }
  public static void main(String []args){
    int N = 5;
    recursive_call(N);
  }
}
