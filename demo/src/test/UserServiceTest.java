import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.example.demo.model.Usuario;
import com.example.demo.service.serviceImplement.servuser;

class UserServiceTest {


@Mock
private  userrepository userrepos;
@InjectMocks
private servuser sevuser;

private User user;
    
@BeforeEach
    void setup(){
MockitoAnnotations.initMocks(testClass this);

user = new Usuario;
user.setName("fernando");
user.setApellidos("Parra");
user.setCategdocente("profesor");
user.setClave("123123");

    }
    @Test
void findAll() {
    when(servuser.findAll()).thenReturn(Arrays.asList(user));
    assertNotNull(servuser.findAll());
    }
}


