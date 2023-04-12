//package labs;


import java.time.LocalDate;
import java.util.Scanner;











 class Book{

    static int bookCount = 0;
    private int ID;
   

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

    public void print(){};

    public int getID() {
        return ID;
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
 System.out.println( " The book"+getID() + " Title is  "+getTitle() + "\n No of Pages: "+ getNumOfPages()+"\n The is releaased on "+ getReleaseDate()+"\n Number of Pages:"+ getNumOfPages() +"\n Sold for: $"+getPrice());
}


}

class AudioBook extends Book
{
    private int numOfMinuntes;


public int getNumOfMinuntes() {
        return numOfMinuntes;
    }


public AudioBook (int lengthInMinutes,String title , LocalDate releaseDate , double price)
{

    super(title, releaseDate, price);
    this.numOfMinuntes=lengthInMinutes;
    
}

@Override
public void print()
{
 System.out.println( " The book"+getID() + " Title is  "+getTitle() + "\n No of Minutes: "+ getNumOfMinuntes()+"\n The is releaased on "+ getReleaseDate()+ "\n Sold for: $"+getPrice());
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
