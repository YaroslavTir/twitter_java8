package domain;

import lombok.Data;

/**
 * @author ymolodkov
 * @date 01/01/15.
 * @since 0.1
 */
@Data
public class Twit {

    private Integer id;
    private String text;
    private Integer userId;
}
