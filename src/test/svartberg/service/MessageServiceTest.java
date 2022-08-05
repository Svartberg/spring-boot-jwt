package svartberg.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import svartberg.model.AppMessage;
import svartberg.model.AppUser;
import svartberg.repository.MessageRepository;
import svartberg.repository.UserRepository;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MessageServiceTest {

    @Mock
    UserRepository userRepository;
    @Mock
    MessageRepository messageRepository;
    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    MessageService messageService;

    @Test
    public void test_save_Should_Return() {
    }

    @Test
    public void test_get_Should_Return_List_Message() {

    }
}