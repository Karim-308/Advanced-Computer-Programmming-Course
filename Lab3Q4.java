


 class MyStringBuffer
{
    private char[] charArr ;

   public MyStringBuffer(String s)
    {
        charArr = s.toCharArray();
    }

    public void print()
    {
        for (int i = 0 ; i<charArr.length ; i++)
        System.out.print(charArr[i]);
        System.out.println();
    }

    public int indexOf (char c)
    {
        for (int i = 0 ; i<charArr.length ; i++)
        {
            if (charArr[i]==c)
            return i ;
        }
        return -1;

    }


   public  int length ()
   {
    return charArr.length;

   }

   public MyStringBuffer erase (int index , int length )
    {
        char[] new_arr = new char[charArr.length-length];
        System.arraycopy(charArr, 0, new_arr, 0, index);
        System.arraycopy(charArr, index+length, new_arr, index, charArr.length-length-index);
        return new MyStringBuffer(new  String(new_arr));

    }

    
        public MyStringBuffer insert(int index, String str) {
            char[] strChars = str.toCharArray();
            char[] new_arr = new char[charArr.length + strChars.length];
            System.arraycopy(charArr, 0, new_arr, 0, index);
            System.arraycopy(strChars, 0, new_arr, index, strChars.length);
            System.arraycopy(charArr, index, new_arr, index + strChars.length, charArr.length - index);
            return new MyStringBuffer(new String(new_arr));
        }

    


}








public class MyString {
    public static void main(String[] args)  {

        MyStringBuffer s = new MyStringBuffer("progamming");
        
        s.print();

        System.out.println(s.indexOf('o'));
        
        System.out.println(s.length());

       MyStringBuffer eraseBuffer= s.erase(1, 2);
       eraseBuffer.print();
        
       s.insert(2, "KARIM").print();

      






    }
}
