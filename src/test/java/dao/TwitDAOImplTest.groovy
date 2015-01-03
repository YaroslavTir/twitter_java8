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
            twitDAO.countTwitsByUserName("Artem") >= 10;
    }

    def "partitioningBy"(){
        setup:
            def twitDAO = new TwitDAOImpl()
            twitDAO.fillData()
        expect:
            def mapByName = twitDAO.mapByName("Artem")
            mapByName[true].size() > 0

    }

    def "lambda list collect "(){
        setup:
            def twitDAO = new TwitDAOImpl()
            twitDAO.fillData()
        expect:
            def collectList = twitDAO.collectList()
            collectList.size() > 0
    }


    def "joining"(){
        setup:
            def twitDAO = new TwitDAOImpl()
            twitDAO.fillData()
        expect:
            def texts = twitDAO.stringTextByName("Artem").split(";")
            texts.length > 0
    }
}
