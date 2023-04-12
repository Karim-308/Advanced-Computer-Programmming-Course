

import java.time.LocalDate;
import java.util.Scanner;











 class Book{

    static int bookCount = 0;
    private final int ID;
   

    private String title;
   

    private LocalDate releaseDate ;
  
    private double price;

  

    public  Book( String title , LocalDate releaseDate2 , double price)
    {
        this.ID = ++bookCount;
        this.title=title;
        this.price=price;
        this.releaseDate=releaseDate2;

    }

   

    public double getPrice() {
        return price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void print(){ System.out.print(this);};

    public int getID() {
        return ID;
    }
    
    @Override
    public String  toString()
    {
        return (" The book #"+getID() + "\n Title is  "+getTitle() + "\n The is releaased on "+ getReleaseDate()+"\n Sold for: $"+getPrice());
}

    @Override
   public boolean equals ( Object o )
    {
    if (this ==o )
    return true;
    
    if (!(o instanceof Book ))
    return false ;
    
    Book  b = (Book) o ;
    if (this.getTitle().equals(b.getTitle()) && this.getReleaseDate().equals(b.getReleaseDate()))
    return true;
    
    else return false;
    
    
    }
   
    }
    


class TextBook extends Book
{

private int numOfPages;


public TextBook (int numOfPages,String title , LocalDate releaseDate , double price)
{

    super(title, releaseDate, price);
    this.numOfPages=numOfPages;
    
}


public int getNumOfPages() {
    return numOfPages;
}

@Override
public void print()
{

    System.out.println(toString());
    
    
}
@Override 
public String toString()
{
    return super.toString() + "\n The number Of Pages: "+getNumOfPages();
    
}

@Override 
public boolean equals ( Object o )

{
     if (this == o) {
      return true;
      //different data type
    } 
    if (!(o instanceof TextBook)) {
      return false;
    }
    TextBook b = (TextBook) o;
        if (super.equals(o) && this.getNumOfPages() == b.getNumOfPages())
            return true;
     return false;
    
    
    
}


}
class AudioBook extends Book {

    private int numOfMinutes;

    public AudioBook(int numOfMinutes, String title, LocalDate releaseDate, double price) {
        super(title, releaseDate, price);
        this.numOfMinutes = numOfMinutes;
    }

    public int getNumOfMinutes() {
        return numOfMinutes;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumber of minutes: " + getNumOfMinutes();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof AudioBook))
            return false;

        AudioBook b = (AudioBook) o;
        if (super.equals(o) && ( getNumOfMinutes() == b.getNumOfMinutes()))
            return true;

        return false;
    }
}





public class Books {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter the number of Books");
        Scanner input = new Scanner(System.in);

        int BookCount =input.nextInt();
        input.nextLine();

        Book[] books = new Book[BookCount];

        for (int  i =0 ; i< BookCount ; i++)
    {
        System.out.print("Enter the type of book (text/audio): ");
        String bookType = input.nextLine();

       System.out.print("Enter the title: ");
        String title = input.nextLine();

        System.out.print("Enter the release date (yyyy-mm-dd): ");
        LocalDate releaseDate = LocalDate.parse(input.nextLine());
        System.out.print("Enter the price: ");

        double price = input.nextDouble();
        input.nextLine();

        if (bookType.equalsIgnoreCase("text")){
            System.out.print("Enter the number of pages: ");
            int numPages = input.nextInt();
            input.nextLine();
            books[i] = new TextBook(numPages,title,releaseDate,price);
        } else if (bookType.equalsIgnoreCase("audio"))
         {
            System.out.print("Enter the length in minutes: ");
            int lengthInMinutes = input.nextInt();
            input.nextLine();
          books[i] = new AudioBook(lengthInMinutes,title,releaseDate,price);
        }
        else {
            System.out.println("Invalid book type entered. Exiting program.");
            return;
    }

}

    System.out.println("List of entered books:");
    for (int i = 0 ; i <BookCount ; i++) {
        books[i].print();
    }

        input.close();
    }
    
}
