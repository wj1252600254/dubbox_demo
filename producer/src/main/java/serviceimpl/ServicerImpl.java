package serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import service.UserService;

@Service(version = "1.0.0")
public class ServicerImpl implements UserService {
    @Override
    public String getName() {
        return "sjtu-wjj";
    }
}
