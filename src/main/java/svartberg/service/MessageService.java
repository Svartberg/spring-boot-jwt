package svartberg.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import svartberg.dto.MessageDataDTO;
import svartberg.dto.MessageResponseDTO;
import svartberg.exception.CustomException;
import svartberg.model.AppMessage;
import svartberg.model.AppUser;
import svartberg.repository.MessageRepository;
import svartberg.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class MessageService {

  private final UserRepository userRepository;
  private final MessageRepository messageRepository;
  private final ModelMapper modelMapper;

  public void save(final MessageDataDTO appMessageDto) {
    final AppUser user = mustFindUser(appMessageDto);
    final AppMessage appMessage = modelMapper.map(appMessageDto, AppMessage.class);
    appMessage.setUser(user);
    messageRepository.save(appMessage);
  }

  public List<MessageResponseDTO> get(final MessageDataDTO appMessageDto) {

    final AppUser user = mustFindUser(appMessageDto);

    List<AppMessage> getMessages = messageRepository.findTop10ByUserOrderByIdDesc(user);

    return getMessages.stream().map(e -> {
      MessageResponseDTO msg = modelMapper.map(e, MessageResponseDTO.class);
      msg.setUsername(user.getUsername());
      return msg;
    }).collect(Collectors.toList());
  }

  private AppUser mustFindUser(MessageDataDTO appMessageDto) {
    final AppUser user = userRepository.findByUsername(appMessageDto.getUserName());
    if (user == null) {
      throw new CustomException("User Id is not found", HttpStatus.UNPROCESSABLE_ENTITY);
    }
    return user;
  }
}
