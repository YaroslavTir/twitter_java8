package domain;

import lombok.Data;

/**
 * @author ymolodkov
 * @date 01/01/15.
 * @since 0.1
 */
@Data
public class UserSubscribe {
    private Integer id;
    private Integer userId;
    private Integer followedUserId;
}
