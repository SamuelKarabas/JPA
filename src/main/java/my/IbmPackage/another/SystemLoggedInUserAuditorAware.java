package my.IbmPackage.another;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class SystemLoggedInUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(System.getProperty("user.name"));
    }

}
