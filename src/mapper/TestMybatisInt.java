package mapper;

import org.springframework.stereotype.Service;

import bean.User;
@Service
public interface TestMybatisInt {
	int deleteTest(User user);
}
