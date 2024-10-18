package arcdz.spring_boot_sqlite;

import arcdz.spring_boot_sqlite.config.AppProps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class Controller {

    private final AppProps appProps;
    private final BookRepository bookRepository;

    @GetMapping("/hello")
    public String getMessage() {
        return "{ 'message': '" + appProps.message() + "'}";
    }

    @GetMapping("/add")
    public String add(){
        bookRepository.save(new Book().author("test").name("test"));

        return "ok";
    }
}
