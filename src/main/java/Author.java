public class Author {
  private String firstName;
  private String lastName;
  private long id;
  public Author(){

  }

  public Author(long id, String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

}
