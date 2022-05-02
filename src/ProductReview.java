import java.util.*;

class ProductReview
{
    private String name;
    private String review;

    /** Constructs a ProductReview object and initializes the instance variables. */
    public ProductReview(String pName, String pReview)
    {
        name = pName;
        review = pReview;
    }

    /** Returns the name of the product. */
    public String getName()
    {
        return name;
    }

    /** Returns the review of the product. */
    public String getReview()
    {
        return review;
    }
}

class ReviewCollector
{
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    /** Constructs a ReviewCollector object and initializes the instance variables. */
    public ReviewCollector()
    {
        reviewList = new ArrayList<ProductReview>();
        productList = new ArrayList<String>();
    }

    /** Adds a new review to the collection of reviews, as described in Part (a). */
    public void addReview(ProductReview prodReview)
    {
        reviewList.add(prodReview);
        productList.add(prodReview.getName());
    }

    /** Returns the number of good reviews for a given product name, as described in Part (b). */
    public int getNumGoodReviews(String prodName)
    {
      int good = 0;
        for(ProductReview review: reviewList){
          if(review.getName().contains(prodName)){
            if(review.getReview().contains("best")){
              good++;
            }
          }
        }
      return good;
    }

  public void printLists(){
    System.out.print("\n");
    System.out.println("Review list");
    for(ProductReview review : reviewList){
      System.out.println(review.getName()+": "+ review.getReview());
    }
    System.out.print("\n");
     System.out.println("Product list");
    for(String product : productList){
      System.out.println(product);
    }
  }

    // There may be instance variables, constructors, and methods not shown.
  public static void main(String[] args){
    ProductReview apple = new ProductReview("Apple", "best ever TBH");
    ProductReview apple2 = new ProductReview("Apple", "i hate apples so bad");
    ProductReview apple3 = new ProductReview("Apple", "my best friend likes apples");
    ProductReview banana = new ProductReview("Banana", "Also not very good");
    ProductReview nectarine = new ProductReview("Nectarine", "Kinda good");
    ReviewCollector reviews = new ReviewCollector();

    reviews.addReview(apple);
    reviews.addReview(apple2);
    reviews.addReview(apple3);
    reviews.addReview(banana);
    reviews.addReview(nectarine);
    reviews.printLists();

    System.out.print("\n");
    System.out.println("Good review search for Apple: " + reviews.getNumGoodReviews("Apple"));
    
  }
}