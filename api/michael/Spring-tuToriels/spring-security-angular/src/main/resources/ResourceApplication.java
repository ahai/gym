@SpringBootApplication
@RestController
@EnableResourceServer
class ResourceApplication {

  @RequestMapping("/")
  public Message home() {
    return new Message("Hello World");
  }

  public static void main(String[] args) {
    SpringApplication.run(ResourceApplication.class, args);
  }
}

public class ResourceApplication extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().authorizeRequests()
      .anyRequest().authenticated();
  }
      class Message {
      private String id = UUID.randomUUID().toString();
      private String content;
      public Message(String content) {
      this.content = content;
    }
  }
}