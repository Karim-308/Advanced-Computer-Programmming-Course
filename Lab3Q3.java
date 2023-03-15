

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

   public void erase (int index , int length )
    { 
        for (int i = index ; i<(index+length) && i<charArr.length;i++ )
        {
                charArr[i]='\0';
        }

    }

    
        public void insert(int index, String str) {
            char[] strChars = str.toCharArray();
            char[] newChars = new char[charArr.length + strChars.length];
            System.arraycopy(charArr, 0, newChars, 0, index);
            System.arraycopy(strChars, 0, newChars, index, strChars.length);
            System.arraycopy(charArr, index, newChars, index + strChars.length, charArr.length - index);
            charArr = newChars;
        }

    


}



public class MyString 
    
{
    public static void main(String[] args)  {
   
        MyStringBuffer buffer = new MyStringBuffer("hello");

        buffer.print(); // Output: hello
    
        System.out.println(buffer.indexOf('l')); // Output: 2
    
        System.out.println(buffer.length()); // Output: 5
    
        buffer.erase(2, 2);
    
        buffer.print(); // Output: he
    
        buffer.insert(1, "llo");
    
        buffer.print(); // Output: hello
    }
}


