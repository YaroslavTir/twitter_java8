package dao;

import domain.Twit;

import java.util.List;
import java.util.Map;

/**
 * @author ymolodkov
 * @date 01/01/15.
 * @since 0.1
 */
interface TwitDAO {


    long countTwitsByUserName(String name);

    List<String> collectList();

    Map<Boolean, List<Twit>> mapByName(String name);

    String stringTextByName(String name);

    void fillData();

}
