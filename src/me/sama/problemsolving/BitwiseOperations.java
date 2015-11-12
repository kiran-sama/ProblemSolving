package me.sama.problemsolving;

/**
 * Created by ksama on 10/8/15.
 */
public class BitwiseOperations {

  public static int bitwiseAdd(int a, int b){
    int result = a ^ b; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
    int carry = (a & b) << 1; // 1+1=2
    if (carry != 0) {
      return bitwiseAdd(result, carry);
    }
    return result;
  }

  public static int bitwiseSubstract(int a, int b){
    return bitwiseAdd(a,(~b+1));
  }

  public static int negate(int a){
    return ~a;
  }

  public static void main(String args[]){
    int a=100,b=90;
    System.out.println(bitwiseSubstract(b, a));
    System.out.println(negate(a));
    System.out.println(negate(b));
    findDuplicate();
  }

  public static void findDuplicate(){
    int[] nos = {0};
    int xor = 0;
    for(int i=0;i<nos.length; i++){
       xor = i ^ xor;
    }
    System.out.println(xor);
  }
}
