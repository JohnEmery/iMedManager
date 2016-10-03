package inventorymanager;

//  John Emery

public class Item {

  private String name;
  private String path;

  
  Item (String N,String Q){
      name=N;
      path=Q;
  }
  
  // getter method for name
  String getName(){
      return name;
  }
  
  // getter method for path
  String getPath(){
      return path;
  }
  
  // setter method for name
  void setName(String N){
    name=N;  
  }
  
  // setter method for path
  void setPath(String Q){
      path=Q;
  }
  
}
