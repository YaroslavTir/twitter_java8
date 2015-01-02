package dao

import spock.lang.Specification

/**
 * @author ymolodkov
 * @since 0.1
 * @date 01/01/15.
 */
class TwitDAOImplTest extends Specification {
    def "FirstMethod"() {
        setup:
            def twitDAO = new TwitDAOImpl()
            twitDAO.fillData()
        expect:
            twitDAO.countTwitsByUserName() >= 10;
    }
}
