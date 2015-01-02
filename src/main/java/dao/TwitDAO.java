package dao;

/**
 * @author ymolodkov
 * @date 01/01/15.
 * @since 0.1
 */
interface TwitDAO {

    long countTwitsByUserName();

    void fillData();

}
