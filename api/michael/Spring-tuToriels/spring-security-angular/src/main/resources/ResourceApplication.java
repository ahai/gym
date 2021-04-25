@SpringBootApplication
@RestController
class ResourceApplication {

    @RequestMapping("/")
    @CrossOrigin(origins="*", maxAge=3600)
    public Message home() {
      return new Message("Hello World");
    }

  public static void main(String[] args) {
    SpringApplication.run(ResourceApplication.class, args);
  }

}

class Message {
  private String id = UUID.randomUUID().toString();
  private String content;
  public Message(String content) {
    this.content = content;
  }
  // ... getters and setters and default constructor
}